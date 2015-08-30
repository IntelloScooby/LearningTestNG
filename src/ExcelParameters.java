import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import supportingLibraries.ExcelOperations;


public class ExcelParameters {
	
	private String filePath = "//Users//mikitashah//Documents//workspace//LearningTestNG//TestData.xlsx";
	ExcelOperations excel = new ExcelOperations(filePath);
	private WebDriver driver = new FirefoxDriver();
	
//	@BeforeTest
//	public void launchApplication(){
//		driver.get("http://www.expedia.com/");
//		driver.findElement(By.cssSelector("#tab-flight-tab")).click();
//	}
	
	
	@Test(dataProvider="getData")
	public void testFlight (Hashtable<String,String> data) throws InterruptedException{
		
		driver.get("http://www.expedia.com/");
		driver.findElement(By.cssSelector("#tab-flight-tab")).click();
		
		driver.findElement(By.cssSelector("#flight-origin")).sendKeys(data.get("origin"));
		driver.findElement(By.cssSelector("#flight-destination")).sendKeys(data.get("destination"));
		driver.findElement(By.cssSelector("#flight-departing")).sendKeys(data.get("departing"));
		driver.findElement(By.cssSelector("#flight-returning")).sendKeys(data.get("arriving"));
		
		WebElement adult = driver.findElement(By.cssSelector("#flight-adults"));
		WebElement children = driver.findElement(By.cssSelector("#flight-children"));
		
		Select ddAdult = new Select(adult);
		Select ddChildren = new Select(children);
		
		ddAdult.selectByVisibleText(data.get("adults"));
		ddChildren.selectByVisibleText(data.get("children"));
		
		driver.findElement(By.cssSelector("#search-button")).click();
		
		Thread.sleep(5000L);
		
		driver.close();
		
//		driver.findElement(By.cssSelector("#flight-origin")).sendKeys("Chicago");
//		driver.findElement(By.cssSelector("#flight-destination")).sendKeys("HNL");
//		driver.findElement(By.cssSelector("#flight-departing")).sendKeys("9/3/2015");
//		driver.findElement(By.cssSelector("#flight-returning")).sendKeys("9/4/2015");
//		
//		WebElement adult = driver.findElement(By.cssSelector("#flight-adults"));
//		WebElement children = driver.findElement(By.cssSelector("#flight-children"));
//		
//		Select ddAdult = new Select(adult);
//		Select ddChildren = new Select(children);
//		
//		ddAdult.selectByValue("1");
//		ddChildren.selectByValue("1");
		
		
//		System.out.println(data.get("origin"));
//		System.out.println(data.get("destination"));
//		System.out.println(data.get("departing"));
//		System.out.println(data.get("arriving"));
//		System.out.println(data.get("adults"));
//		System.out.println(data.get("children"));
		
		
		
	}
	
//	@AfterTest
//	public void closeApplication(){
//		driver.close();
//	}
	
	@DataProvider
	public Object[][] getData(){
		
		//Object [][] data = null;
		Hashtable <String, String> table = null;
		String sheetName = "flightTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColCount(sheetName);
		
		Object [][] data = new Object[rows-1][1];
		
		for (int r=1; r<rows; r++){
			
			table = new Hashtable<String, String>();
			
			for (int c=0; c<cols; c++){
				
				String key = excel.getCellData(sheetName, 0, c);
				String value = excel.getCellData(sheetName, r, c);			
				table.put(key, value);
				data [r-1][0] = table;
			}
			
		}
		
		
		return data;
		
	}
	
}
