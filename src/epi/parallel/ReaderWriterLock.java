package epi.parallel;

/**
 * http://blog.csdn.net/losing_coder/article/details/7497950
 * 
 * http://gee.cs.oswego.edu/dl/classes/EDU/oswego/cs/dl/util/concurrent/intro.
 * html
 */

/**
 * 由于synchronized关键字利用this对象同步，而this对象可能还被用于其他同步目的，
 * 因此相对AtomicInteger有较多的机会造成线程之间的相互等待
 * 。而AtomicInteger本身有一个小的同步块，因而不和其他利用this对象同步的线程竞争
 * ，通常会更好一些。而且AtomicInteger的很多方法都是lock-free的，对Scalability有较大的好处。
 * 
 * 不过在一些情况，我们还是应该利用synchronized而不是Atomic包。首先，如果我们程序中线程数目较少，或者该计数器不是一个热点时，
 * 用锁的程序和AtomicInteger的程序性能没有什么差别
 * 。为了节约内存，我们可以采用基于synchronized的版本或者AtomicIntegerFieldUpdater
 * 。其次，如果有多个计数器需要操作，那么在一个synchronized块中进行所有的操作比采用多个Atomic对象要好
 * 。这点从代码路径上就可以看出。如果线程之间不发生冲突
 * ，那么一个synchronized块和一个atomic对象一个CAS操作。如果一个synchronized块处理了多个需要保护的操作
 * ，那么就节约了CAS操作的数目，因而具有较高的性能。
 * 
 */

public class ReaderWriterLock
{
	private int waitingWriters;
	private int waitingReaders;

	// multiple readers
	private int activeReaders;

	private Thread currentWriter = null;
	private Object readLock = new Object();
	private Object writeLock = new Object();

	public ReaderWriterLock()
	{
		activeReaders = 0;
		waitingWriters = 0;
	}

	public void readLock() throws InterruptedException
	{
		if (Thread.interrupted())
			throw new InterruptedException();

		InterruptedException ex = null;

		synchronized (readLock)
		{
			if (!canStartReader())
			{
				while (true)
				{
					try
					{
						readLock.wait();

						if (canStartWaitingReader())
							return;
					}
					catch (InterruptedException e)
					{
						ex = e;
						break;
					}

				}
			}
		}

		if (ex != null)
		{
			notifyWriter();
			throw ex;
		}
	}

	public void readUnlock()
	{
		boolean toNotify = false;
		synchronized (this)
		{
			activeReaders--;
			if (activeReaders == 0 && waitingWriters > 0)
				toNotify = true;
		}

		if (toNotify)
			notifyWriter();
	}
	
	private void notifyWriter()
	{
		synchronized (writeLock)
		{
			writeLock.notifyAll();
		}
	}

	private void notifyReader()
	{
		synchronized (readLock)
		{
			readLock.notifyAll();
		}
	}

	private synchronized boolean canStartReader()
	{
		if (currentWriter != null && waitingWriters > 0)
		{
			waitingReaders++;
			return false;
		}

		activeReaders++;
		return true;
	}

	private synchronized boolean canStartWaitingReader()
	{
		if (currentWriter != null || waitingWriters > 0)
			return false;

		waitingReaders--;
		activeReaders++;
		return true;
	}

	private synchronized boolean canStartWriter()
	{
		if (currentWriter != null || activeReaders > 0)
		{
			waitingWriters++;
			return false;
		}

		currentWriter = Thread.currentThread();
		return true;
	}

	private synchronized boolean canStartWaitingWriter()
	{
		if (currentWriter != null || activeReaders > 0)
			return false;

		currentWriter = Thread.currentThread();
		waitingWriters--;
		return true;
	}

	public int getActiveReaderCount()
	{
		return activeReaders;
	}

	public void writeLock() throws InterruptedException
	{
		if (Thread.interrupted())
			throw new InterruptedException();

		InterruptedException ex = null;

		synchronized (writeLock)
		{
			if (!canStartWriter())
			{
				while (true)
				{
					try
					{
						writeLock.wait();

						if (canStartWaitingWriter())
							return;
					}
					catch (InterruptedException e)
					{
						ex = e;
						break;
					}

				}
			}
		}

		if (ex != null)
		{
			notifyReader();
			throw ex;
		}
	}

	public void writeUnlock()
	{
		Object toNotify = null;

		synchronized (this)
		{
			currentWriter = null;

			if (waitingWriters == 0 && waitingReaders > 0)
				toNotify = readLock;
			else if (waitingWriters > 0)
				toNotify = writeLock;
		}

		if (toNotify != null)
			toNotify.notifyAll();
	}
}