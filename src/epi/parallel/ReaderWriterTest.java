package epi.parallel;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReaderWriterTest
{

	public static void main(String[] args)
	{
		BankCard bc = new BankCard();
		ReaderWriterLock lock = new ReaderWriterLock();
		ExecutorService pool = Executors.newCachedThreadPool();
		Consumer cm1 = new Consumer(bc, lock);
		CreditChecker cm2 = new CreditChecker(bc, lock, 1);
		CreditChecker cm3 = new CreditChecker(bc, lock, 2);
		CreditChecker cm4 = new CreditChecker(bc, lock, 3);
		pool.execute(cm1);
		pool.execute(cm2);
		pool.execute(cm3);
		pool.execute(cm4);
	}
}

class BankCard
{
	private String cardid = "XZ456789";
	private int balance = 5000;

	public String getCardid()
	{
		return cardid;
	}

	public void setCardid(String cardid)
	{
		this.cardid = cardid;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int balance)
	{
		this.balance = balance;
	}
}

class Consumer implements Runnable
{
	BankCard bc = null;
	ReaderWriterLock lock = null;

	Consumer(BankCard bc, ReaderWriterLock lock)
	{
		this.bc = bc;
		this.lock = lock;
	}

	public void run()
	{
		Random r = new Random();
		try
		{
			while (true)
			{
				lock.writeLock();
				int expense = r.nextInt(1000) + 500;
				bc.setBalance(bc.getBalance() - expense);
				System.out.println("Spent money " + expense
						+ " and the balance becomes " + bc.getBalance());
				lock.writeUnlock();

				if (bc.getBalance() <= 0)
					break;
				Thread.sleep(3 * 1000);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class CreditChecker implements Runnable
{
	BankCard bc = null;
	int type = 0;
	ReaderWriterLock lock = null;

	CreditChecker(BankCard bc, ReaderWriterLock lock, int type)
	{
		this.bc = bc;
		this.lock = lock;
		this.type = type;
	}

	public void run()
	{
		try
		{
			while (true)
			{
				lock.readLock();
				System.out.println("credit checker " + type
						+ " get the balance " + bc.getBalance());
				lock.readUnlock();

				if (bc.getBalance() <= 0)
					break;

				Thread.sleep(1 * 1000);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}