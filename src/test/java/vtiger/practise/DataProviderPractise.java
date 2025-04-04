package vtiger.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
@Test(dataProvider="getData")
public void tc1(String name,int price)
 {
	System.out.println(name+"--->"+price);
}
@DataProvider
public Object[][] getData()
{
		 Object[][] data=new Object[3][2];
		 data[0][0]="samsung";
		 data[0][1]=12000;
		 data[1][0]="iphone";
		 data[1][1]=5000;
		 data[2][0]="samsung123";
		 data[2][1]=100000;
		return data;
}
}