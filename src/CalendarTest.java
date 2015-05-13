import java.util.Calendar;
import java.util.Date;


public class CalendarTest
{
	public static void main(String[] args)
	{
		long absoluteDate = 1382425200000L;
		
		Date tmpDate = new Date(absoluteDate);
		System.out.println("date: " + tmpDate);
		
		Calendar calEndDate = Calendar.getInstance();
		calEndDate.setLenient(false);
		calEndDate.setTimeInMillis( absoluteDate );
		
		int endYear = calEndDate.get( Calendar.YEAR );
		int endMonth = calEndDate.get( Calendar.MONTH );
		int endDate = calEndDate.get( Calendar.DATE );
		
		System.out.print("year: " + endYear + "\tmonth: " + endMonth + "\tdate: " + endDate);
	}
}
