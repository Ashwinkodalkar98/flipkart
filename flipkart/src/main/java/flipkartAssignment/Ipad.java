package flipkartAssignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ipad {
	
	public static WebDriver driver;
	
    public static Ipad ip;
	
	public Ipad(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//object repository
	@FindBy(xpath="//button[@class=\"_2KpZ6l _2doB4z\"]")
	private WebElement click_on_cross;
	
	@FindBy(xpath="//input[@class=\"_3704LK\"]")
	private WebElement search_bar;
	
	@FindBy(xpath="(//a[@class=\"_2SqgSY\"])[2]")
	private WebElement click_on_filter ;
	
	@FindBy(xpath="(//div[contains(@class,'_4rR01T')])[1]")
	private WebElement click_on_product ;
	
	@FindBy(xpath="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	private WebElement cheakout_product ;
	
	@FindBy(xpath="//span[contains(text(),'Place Order')]")
	private WebElement place_order;
	
	@FindBy(xpath="//input[contains(@class,'_2IX_2- _17N0em')]")
	private WebElement enter_mn;
	
	@FindBy(xpath="//span[contains(text(),'CONTINUE')]")
	private WebElement countinue_btn;
	
	
	// action methods 
	
	public void clickOnCrossMark ()
	{
		click_on_cross.click();
	}
	
	public void clickOnSearchBox(String product)
	{
		search_bar.sendKeys(product+ Keys.ENTER);
	}
	
	public void clickOnFilter ()
	{
		click_on_filter.click();
	}
	
	
	public void clickOnProduct ()
	{
		 click_on_product.click();
	}
	
	public void addTocard ()
	{
		 cheakout_product.click();
	}
	
	
	public void clickOnPlaceOrder ()
	{
		place_order.click();
	}
	
	
	public void enterMobileNumber(String MN)
	{
		 enter_mn.sendKeys(MN);
	}
	
	
	public void clickOnCountinueBtn ()
	{
		countinue_btn.click();
	}
	
	
	public static void main(String args[]) throws InterruptedException
	{
	
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 ip = new Ipad(driver);
		 ip.clickOnCrossMark();
		 ip.clickOnSearchBox("ipad");
		 ip.clickOnFilter();
		 ip.clickOnProduct();
		 Thread.sleep(8000);
		 
	    // find parent & child window id 
	     String p_id = driver.getWindowHandle();
	     Set<String> c_id = driver.getWindowHandles();
	     
	     //changing focus from parent window to child window
	     for(String child:c_id)
	     {
	    	 if(!(p_id.equals(child)))
	    	 {
	    		 driver.switchTo().window(child);
	    		 Thread.sleep(5000);
	    		 ip.addTocard();
	    		 ip.clickOnPlaceOrder();
	    		 ip.enterMobileNumber("9545700540");
	    		 ip.clickOnCountinueBtn();
	    	 }
	     }
	   
	   	    
	  }

}



