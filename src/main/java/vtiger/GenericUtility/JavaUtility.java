package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * @author nasir
 */
public class JavaUtility {
public int getRandomNumber()
{
	Random r=new Random();
	int ran=r.nextInt(1000);
	return ran;
}
public String getSystemDate()
{
	Date d=new Date();
	String date=d.toString();
	return date;
}
public String getSystemDateInFormat()
{
	Date d=new Date();
	String[] dArr = d.toString().split(" ");
			String date = dArr[2];
			String month = dArr[1];
			String year = dArr[5];
			String time = dArr[3].replace(":","-");
			String cdate=date+" "+month+" "+year+" "+time;
			return cdate;
}
}
