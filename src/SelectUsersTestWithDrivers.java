
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectUsersTestWithDrivers
{
	private static Object lock = new Object();
	private static Object mainlock = new Object();
	private static long total_execute = 0;
	private static long total_fetch = 0;
	
	private static int THREAD_COUNT = 1;
	private static int LIMIT = 50;
	private static final int TIMES = 500;
	
	private static Integer leftcount = new Integer(THREAD_COUNT);
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException 
	 */
	public static void main( String[] args ) throws ClassNotFoundException, SQLException, InterruptedException
	{
		String sql = "SELECT ac_cluster.v_user.user_login_name, ac_cluster.v_user.time_stamp, ac_cluster.v_user.user_iid, ac_cluster.v_folder_path(ac_cluster.v_user.home_folder_iid) AS UserHomeFolder, ac_cluster.v_user.description FROM ac_cluster.v_user WHERE ac_cluster.v_user.is_active = 'T' ORDER BY UPPER( ac_cluster.v_user.user_login_name ) ASC";

		//String sql1 = "SELECT ac_cluster.v_user.user_login_name, ac_cluster.v_user.time_stamp, ac_cluster.v_user.user_iid, ac_cluster.v_user.description FROM ac_cluster.v_user WHERE ac_cluster.v_user.is_active = 'T' ORDER BY UPPER( ac_cluster.v_user.user_login_name ) ASC";
		
		RunningThread[] running = new RunningThread[THREAD_COUNT];
		for(int i = 0;i < running.length; i++)
		{
			running[i] = new RunningThread(TIMES, sql, LIMIT, i, true);
			running[i].start( );
		}
		synchronized(mainlock)
		{
			mainlock.wait();
		}
		
		
		System.out.println(THREAD_COUNT+" thread(s) times: " + TIMES +" average_execute=" + 
				(total_execute/THREAD_COUNT)/TIMES+" average_fetch="+ (total_fetch/THREAD_COUNT)/TIMES);
	}
	
	static class RunningThread extends Thread
	{
		String SQL;
		int limit;
		String threadNum;
		int times;
		boolean useDD = false;
		public RunningThread(int times, String sql, int lim, int threadNum, boolean useDD)
		{
			SQL = sql;
			limit = lim;
			this.threadNum = String.valueOf( threadNum );
			this.times = times;
			this.useDD = useDD;

		}
		public void run()
		{
			System.out.println( "thread " +  threadNum + "start" );
			try
			{
				long[] result;
				if(useDD)
				{
					result = SelectUsersTestWithDrivers.multiRunTestWithDDDriver( times, SQL, limit );
				}
				else
				{
					result = SelectUsersTestWithDrivers.multiRunTestWithPostgresqlDriver( times, SQL, limit );
				}
				synchronized(lock)
				{
					total_execute += result[0];
					total_fetch += result[1];
				}
				
			}
			catch ( ClassNotFoundException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
			catch ( SQLException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
			
			
			
			synchronized(leftcount)
			{
				leftcount -= 1;
				if(leftcount==0)
				{
					synchronized(mainlock)
					{
						mainlock.notify();	
					}
				}
			}
			
			System.out.println( "thread " + threadNum + " end ");
			
		}
		
	}

	public static long[] multiRunTestWithDDDriver( int times, String sql, int limit ) throws ClassNotFoundException, SQLException
	{
		long exeduration = 0;
		long iterduration = 0;
		long closeduration=0;
		for ( int i = 0; i < times; i++ )
		{
			Class.forName( "com.ddtek.jdbc.postgresql.PostgreSQLDriver" );

			String url = "jdbc:datadirect:postgresql://localhost:8432;DatabaseName=ihub;User=postgres;Password=postgres;InsensitiveResultSetBufferSize=8192";
			//String url = "jdbc:datadirect:postgresql://localhost:8432;DatabaseName=ihub;User=postgres;Password=postgres;InsensitiveResultSetBufferSize=1024;MaxPooledStatements=2;ResultSetMetaDataOptions=0";
			Connection conn = DriverManager.getConnection( url );
			conn.setAutoCommit( false );
			// int level = conn.getTransactionIsolation( );
			conn.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
			String sqlWithLimit = sql + " LIMIT " + limit;
			PreparedStatement stmt = conn.prepareStatement( sqlWithLimit, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY );
			stmt.setFetchSize( 201 );
			long start = System.currentTimeMillis( );
			ResultSet res = stmt.executeQuery( );
			exeduration += System.currentTimeMillis( ) - start;
			int count = 0;
			// res.next( );
			long lstart = System.currentTimeMillis( );
			while ( res.next( ) )
			{
				count++;
				//String name = res.getString( 1 );
			//	System.out.println( "user name: " + name );

			}
			iterduration += System.currentTimeMillis( ) - lstart;
			//System.out.println( "totle rows: " + count );
			conn.commit( );
			long cstart = System.currentTimeMillis( );
			conn.close( );
			closeduration += System.currentTimeMillis( ) - cstart;
			//System.out.println( "WithDDDriver close duration: " + closeduration );
		}
		
		System.out.println( "WithDDDriver exe duration: " + exeduration );
		System.out.println( "WithDDDriver iteral duration: " + iterduration );
		return new long[]{exeduration, iterduration};
	}
 
	public static long[] multiRunTestWithPostgresqlDriver( int times, String sql, int limit ) throws ClassNotFoundException, SQLException
	{
		long exeduration = 0;
		long iterduration = 0;
		long closeduration=0;
		for ( int i = 0; i < times; i++ )
		{
			Class.forName( "org.postgresql.Driver" );

			String url = "jdbc:postgresql://localhost:8432/ihub?user=postgres&password=postgres";
			Connection conn = DriverManager.getConnection( url );
			conn.setAutoCommit( false );
			// int level = conn.getTransactionIsolation( );
			conn.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
			String sqlWithLimit = sql + " LIMIT " + limit;
			PreparedStatement stmt = conn.prepareStatement( sqlWithLimit, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY );
			stmt.setFetchSize( 201 );
			long start = System.currentTimeMillis( );
			ResultSet res = stmt.executeQuery( );
			exeduration += System.currentTimeMillis( ) - start;
			int count = 0;
			// res.next( );
			long lstart = System.currentTimeMillis( );
			while ( res.next( ) )
			{
				count++;
				//String name = res.getString( 1 );
			//	System.out.println( "user name: " + name );

			}
			iterduration += System.currentTimeMillis( ) - lstart;
			//System.out.println( "totle rows: " + count );
			conn.commit( );
			long cstart = System.currentTimeMillis( );
			conn.close( );
			closeduration += System.currentTimeMillis( ) - cstart;
			//System.out.println( "WithPostgresqlDriver close duration: " + closeduration );
		}
		System.out.println( "WithPostgresqlDriver exe duration: " + exeduration );
		System.out.println( "WithPostgresqlDriver iteral duration: " + iterduration );
		return new long[]{exeduration, iterduration};
	}

}
