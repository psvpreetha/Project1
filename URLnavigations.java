package stepDefinitions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.jxls.reader.XLSReader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class URLnavigations 
{
	public static WebDriver driver;
	
	@Given("^DBS url is clicked$")
	public void DBS_url_is_clicked()
	{	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\srividya.preetha\\Downloads\\selenium-java-3.141.59\\driviers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.dbs.com.sg/index/default.page");
		driver.manage().window().maximize();
	}

	@And("^website is loaded completely$")
	public void website_is_loaded_completely()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	}
	
	@When("^click on Learn More$")	
	public void click_on_Learn_More()  throws InterruptedException
	{
		driver.findElement(By.xpath("//p[@class='dbs-group']//button[@class='btn btn-primary']")).click();
		Thread.sleep(3000);
	}
	@When("^Scroll down and navigate to Singapore on left panel$")
	public void scroll_down_and_navigate_to_Singapore_on_left_panel()  throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='sideNav']//li[3]//a[1]")).click();
		Thread.sleep(3000);
		
	}	    
	
	@Then("^Read and write the table in excel sheet$")
	public void read_and_write_the_table_in_excel_sheet() 
	{
	
	   String beforeXPath = " //*[@id=\"bodywrapper\"]/div[2]/section/div[1]/div[2]/div/div[5]/table/tbody/tr[ ";
	   String afterXPath = " ]/td[1] ";
	   
	   List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/section/div[1]/div[2]/div/div[5]/table//tr"));
	   System.out.println("Total number of rows:" + rows.size());
	   int rowCount =  rows.size();
	   
	 //  XLSReader reader = new XLSReader("C:/Users/srividya.preetha/Downloads/selenium-java-3.141.59/data/datasheet.xlsx");
	   //reader.addSheet("Tabledata");
	   //reader.addColumn("Tabledata","Business")
	  
	   for (int i=1; i <=rowCount; i++)
			   {
		   			String actualXpath = beforeXPath + i +  afterXPath;
		   			//WebElement Element = driver.findElement(By.xpath(actualXpath));
		   			String business = driver.findElement(By.xpath(actualXpath)).getText();
		   			System.out.print(business);
			   }
	  
	 //reader.setCellData("Tabledata","Business",i,business);
	}

	
	@Given("^Click on About$")
	public void Click_on_About()  throws InterruptedException
	{
		driver.findElement(By.xpath(" //*[@id=\"flpHeader\"]/header/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
	}

	@When("^Click on Who we are$")
	public void click_on_Who_we_are()  throws InterruptedException
	{
		
		driver.findElement(By.linkText("Who We Are")).click();	
		Thread.sleep(3000);
		
	}
	
	@When("^Click on Awards and Accolades$")
	public void click_on_Awards_and_Accolades() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.linkText("Our Awards & Accolades")).click();
		Thread.sleep(3000);
	}
	
	@Then("^Read to number of awards$")
	public void read_to_number_of_awards() 
	{		
		
		List<WebElement> Awards =  driver.findElements(By.tagName("h3"));
		System.out.println("Total number of awards are:" + (Awards.size() - 1));
	}

	@Then("^Print report$")
	public void print_report()
	{
		String tag = "h3"; 
        List<WebElement> award =  driver.findElements(By.tagName(tag));
        for(int i=0;i<award.size();i++){
            System.out.println(" Award Name: " + award.get(i).getText());
        }
}}

	

	



