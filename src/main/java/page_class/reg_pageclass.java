package page_class;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class reg_pageclass {
	
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"header\"]/div/div/div[1]/div[2]/div/div/div/ul/li[1]/a")
	WebElement account;
	
	@FindBy(xpath="//*[@id=\"username\"]")
	WebElement loginuser;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement loginpass;
	
	@FindBy(xpath="//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/div[1]/div/div[2]/ul/li[1]/div/div/form/select")
	WebElement drpdwn;
	
	@FindBy(xpath="/html/body/div[1]/section/div/div[2]/div/div[1]/div/div[3]/div/div/div/div[3]/div/div/div[2]/h3/a")
	WebElement chips;
	
	@FindBy(xpath="/html/body/div[1]/section/div/div/div/div/div/div[2]/div[1]/div/div[2]/div/ul/li/div/form/div[1]/div[1]/div[1]/input")
	WebElement checkchips;
	
	@FindBy(xpath="//*[@id=\"product-4279\"]/div[1]/div/div[2]/div/ul/li/div/form/div[2]/div[2]/button")
	WebElement cart;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div/div[1]/div/a")
	WebElement cartview;
	
	@FindBy(xpath="//*[@id=\"post-6561\"]/div[3]/div/a[1]")
	WebElement facebook;
	
	
	
	
	
	public reg_pageclass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void field() throws InterruptedException
	{
		Thread.sleep(2000);
		account.click();
	
		
	}
	
	public void test1(String username,String pwd) throws Exception
	{
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		loginuser.sendKeys(username);
		loginpass.sendKeys(pwd);
		
	}
	public void test2() {
		
		loginbtn.click();
		account.click();
	}
	
	public void mousehover()
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		
		
		
		Actions act=new Actions(driver);
		WebElement a=driver.findElement(By.xpath("//*[@id=\"menu-item-4297\"]/a"));
		act.moveToElement(a);
		WebElement snack=driver.findElement(By.xpath("//*[@id=\"menu-item-4298\"]/a"));
		act.moveToElement(snack);
		act.perform();
		snack.click();
		}
	
	public void dropdown() {
		drpdwn.click();
		Select ob1=new Select(drpdwn);
		ob1.selectByValue("popularity");		
	}
	
	public void checkbox() {
		chips.click();
		checkchips.click();
		if(checkchips.isSelected())     
		{
			System.out.println("checkbox is selected");
		}
		else
		{
			System.out.println("checkbox is not selected");
		}
		
	}
	
	public void cart() {
		cart.click();
		cartview.click();
	}
	
	public void dropdown2() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		Actions act=new Actions(driver);
		WebElement munnar=driver.findElement(By.xpath("//*[@id=\"menu-item-4138\"]/a"));
		act.moveToElement(munnar);
		WebElement blog=driver.findElement(By.xpath("//*[@id=\"menu-item-3156\"]/a"));
		act.moveToElement(blog);
		act.perform();
		blog.click();
	}
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tp-blog-page\"]/div/div[1]/div/div[1]/article[4]/div[2]/div[2]/div[1]/a"));
		
		js.executeScript("window.scrollBy(0,250)", "");
		
		Element.click();
	}
	
	public void swichtab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		facebook.click();
		ArrayList<String> windowdetails=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowdetails.get(0));
	}
	public void screenshot() throws Exception {
		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(s, new File("./screenshot/screeenshot.png"));
	}
	
	public void link()
	{
		List <WebElement> li= driver.findElements(By.tagName("a"));
		System.out.println("no of list elemets = "+li.size());
		
		for(WebElement ele : li) 
			{
			String link= ele.getAttribute("href");
			String linktext =ele.getText();
			System.out.println(link+"----------"+linktext);
	        }
	}
	
	public void tab() {
		
		String exp="Best Place to Buy Spices Online in India - Spice Munnar";
		String actual = driver.getTitle();
		System.out.println("Actual title------->"+actual);
		Assert.assertEquals(exp, actual);
	}
	
}
