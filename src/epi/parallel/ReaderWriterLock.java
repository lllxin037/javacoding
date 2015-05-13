package epi.parallel;

/**
 * http://blog.csdn.net/losing_coder/article/details/7497950
 * 
 * http://gee.cs.oswego.edu/dl/classes/EDU/oswego/cs/dl/util/concurrent/intro.
 * html
 */

/**
 * ����synchronized�ؼ�������this����ͬ������this������ܻ�����������ͬ��Ŀ�ģ�
 * ������AtomicInteger�н϶�Ļ�������߳�֮����໥�ȴ�
 * ����AtomicInteger������һ��С��ͬ���飬���������������this����ͬ�����߳̾���
 * ��ͨ�������һЩ������AtomicInteger�ĺܶ෽������lock-free�ģ���Scalability�нϴ�ĺô���
 * 
 * ������һЩ��������ǻ���Ӧ������synchronized������Atomic�������ȣ�������ǳ������߳���Ŀ���٣����߸ü���������һ���ȵ�ʱ��
 * �����ĳ����AtomicInteger�ĳ�������û��ʲô���
 * ��Ϊ�˽�Լ�ڴ棬���ǿ��Բ��û���synchronized�İ汾����AtomicIntegerFieldUpdater
 * ����Σ�����ж����������Ҫ��������ô��һ��synchronized���н������еĲ����Ȳ��ö��Atomic����Ҫ��
 * �����Ӵ���·���ϾͿ��Կ���������߳�֮�䲻������ͻ
 * ����ôһ��synchronized���һ��atomic����һ��CAS���������һ��synchronized�鴦���˶����Ҫ�����Ĳ���
 * ����ô�ͽ�Լ��CAS��������Ŀ��������нϸߵ����ܡ�
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