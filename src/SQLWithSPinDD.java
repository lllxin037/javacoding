
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLWithSPinDD
{
	private static int THREAD_COUNT = 1;
	private static int LIMIT = 50;
	private static final int TIMES = 500;

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException 
	 */
	public static void main( String[] args ) throws Exception
	{
		Class.forName( "com.ddtek.jdbc.postgresql.PostgreSQLDriver" );

		String url = "jdbc:datadirect:postgresql://localhost:8432;DatabaseName=ihub;User=postgres;Password=postgres";
		Connection conn = DriverManager.getConnection( url );
		
		conn.setAutoCommit( false );
		
		createTableAndSP( conn );
		
		conn.setTransactionIsolation( Connection.TRANSACTION_READ_COMMITTED );


		long total_execute = 0;
		long total_fetch = 0;
		
		String sql = "SELECT test.test1.iid, test.test1.description, test.sp1(test.test1.iid) AS folder FROM test.test1";
		
		long[] result = multiRunTestWithDDDriver( TIMES, sql, LIMIT, conn );
		total_execute = result[0];
		total_fetch = result[1];
		System.out.println(THREAD_COUNT+" thread(s) times: " + TIMES +" average_execute=" + 
				(total_execute/THREAD_COUNT)/TIMES+" average_fetch="+ (total_fetch/THREAD_COUNT)/TIMES);
		
		String sql1 = "SELECT test.test1.iid, test.test1.description, test.sp2(test.test1.iid) AS folder FROM test.test1";
		result = multiRunTestWithDDDriver( TIMES, sql1, LIMIT, conn );
		total_execute = result[0];
		total_fetch = result[1];
		System.out.println(THREAD_COUNT+" thread(s) times: " + TIMES +" average_execute=" + 
				(total_execute/THREAD_COUNT)/TIMES+" average_fetch="+ (total_fetch/THREAD_COUNT)/TIMES);
		
		String sql2 = "SELECT test.test1.iid, test.test1.description, 'adfa/dbc' AS folder FROM test.test1";
		result = multiRunTestWithDDDriver( TIMES, sql2, LIMIT, conn );
		total_execute = result[0];
		total_fetch = result[1];
		System.out.println(THREAD_COUNT+" thread(s) times: " + TIMES +" average_execute=" + 
				(total_execute/THREAD_COUNT)/TIMES+" average_fetch="+ (total_fetch/THREAD_COUNT)/TIMES);
	}
	
	public static long[] multiRunTestWithDDDriver( int times, String sql, int limit, Connection conn ) throws Exception
	{
		long exeduration = 0;
		long iterduration = 0;

		for ( int i = 0; i < times; i++ )
		{
			// int level = conn.getTransactionIsolation( );
			
			conn.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
			String sqlWithLimit = sql; 
			sqlWithLimit += " LIMIT " + limit;
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
				String iid = res.getString( 1 );
				//System.out.println( "user name: " + iid );

			}
			iterduration += System.currentTimeMillis( ) - lstart;
			//System.out.println( "totle rows: " + count );
			conn.commit( );
		}
		
		System.out.println( "Driver exe duration: " + exeduration );
		System.out.println( "Driver iteral duration: " + iterduration );
		return new long[]{exeduration, iterduration};
	}

	private static void createTableAndSP(Connection conn) throws Exception
	{
		createTable1(conn);
		System.out.println("created table test.test1");
		createSP1(conn);
		System.out.println("created stored procedure test.sp1");
		createSP2(conn);
		System.out.println("created stored procedure test.sp2");
		populateTable(conn);
		System.out.println("inserted 1000 rows to test.test1");
	}
	
	private static void createTable1( Connection conn ) throws Exception
	{
		String removeTable = "drop table test.test1";

		String createTable = "CREATE TABLE test.test1( "
				+ " iid bigint NOT NULL,  description character varying(200)," 
				+ "  CONSTRAINT test1_p PRIMARY KEY (iid) )";

		PreparedStatement stmt = null;
		try
		{
			stmt = conn.prepareStatement( removeTable, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
			stmt.execute( );
			stmt.close( );
		}
		catch ( SQLException e )
		{
			// ignore if there is no table yet.
		}

		stmt = conn.prepareStatement( createTable, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
		stmt.execute( );
		stmt.close( );

		conn.commit( );
	}
	
	private static void createSP1( Connection conn ) throws Exception
	{
		String createSP = "CREATE OR REPLACE FUNCTION test.sp1(oneParam bigint) " +
				" RETURNS text AS \n" +
				" $BODY$ \n" +
				" DECLARE \n" +
				"   l_path TEXT; \n" +
				" BEGIN \n" +
				"   RETURN 'adfa/dbc';\n" +
				" END;\n" +
				" $BODY$\n" +
				" LANGUAGE plpgsql STABLE STRICT \n" + 
				" COST 100;";

		PreparedStatement stmt = null;

		stmt = conn.prepareStatement( createSP, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
		stmt.execute( );
		stmt.close( );

		conn.commit( );
	}
	
	private static void createSP2( Connection conn ) throws Exception
	{
		String createSP = "CREATE OR REPLACE FUNCTION test.sp2(oneParam bigint) " +
				" RETURNS text AS \n" +
				" $BODY$ \n" +
				" DECLARE \n" +
				"   l_path TEXT; \n" +
				" BEGIN \n" +
				"   RETURN NULL;\n" +
				" END;\n" +
				" $BODY$\n" +
				" LANGUAGE plpgsql STABLE STRICT \n" + 
				" COST 100;";

		PreparedStatement stmt = null;

		stmt = conn.prepareStatement( createSP, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
		stmt.execute( );
		stmt.close( );

		conn.commit( );
	}
	
	private static void populateTable( Connection conn ) throws Exception
	{
		int rowCount  = 1000;
		
		for ( int i = 0; i < rowCount; i++ )
		{
			StringBuffer sb = new StringBuffer( );
			sb.append( "insert into test.test1 " );
			sb.append( "values(" );
			sb.append( i );
			sb.append( ", \'short description for test\')" );

			String sql = sb.toString( );
			//System.out.println( "insert clause: " + sql );

			PreparedStatement stmt = conn.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE );
			stmt.execute( );
			stmt.close( );
		}

		conn.commit( );
	}
}
