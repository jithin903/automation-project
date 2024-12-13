package test_class;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base_class.baseclass;
import page_class.reg_pageclass;
import projectutilities.xlutilities;


public class reg_testclass extends baseclass
{

@Test
public void projecttest() throws Exception 
{
	reg_pageclass ob=new reg_pageclass(driver);
	
	ob.field();
	String xl="F:\\Jithin jose\\projectlogin.xlsx";
	String sheet="Sheet1";


	int rowCount =xlutilities.getrRowCount(xl, sheet);
	System.out.println(rowCount);
	
	for(int i=1;i<=rowCount;i++)
	{
		String username=xlutilities.getCellValue(xl, sheet, i, 0);
		System.out.println("username--->"+username);
		String pwd=xlutilities.getCellValue(xl, sheet, i, 1);
		System.out.println("password--->"+pwd);
		
		ob.test1(username, pwd);
		ob.test2();
		
		
		
	
		
		
}
	ob.mousehover();
	Thread.sleep(2000);
	ob.dropdown();
	ob.checkbox();
	ob.cart();
	ob.dropdown2();
	Thread.sleep(2000);
	ob.scroll();
	ob.swichtab();
	ob.screenshot();
	ob.link();
	ob.tab();
}

}
