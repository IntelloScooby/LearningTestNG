import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ReusableMethods {
	
	private WebDriver driver;
	private String actualValue = "";
	
	public ReusableMethods(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	
	public boolean testFlightsTabState(String expectedValue){
		
		actualValue = driver.findElement(By.cssSelector("#tab-flight-tab")).getAttribute("class");	
		
		if (actualValue.equals(expectedValue)){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public boolean testHotelsTabState(String expectedValue){
		
		actualValue = driver.findElement(By.cssSelector("#tab-hotel-tab")).getAttribute("class");		
		
		if (actualValue.equals(expectedValue)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean testBundleDealsTabState(String expectedValue){
		
		actualValue = driver.findElement(By.cssSelector("#tab-package-tab")).getAttribute("class");		
		
		if (actualValue.equals(expectedValue)){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public boolean testCarsTabState(String expectedValue){
		
		actualValue = driver.findElement(By.cssSelector("#tab-car-tab")).getAttribute("class");	
		
		if (actualValue.equals(expectedValue)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean testCruisesTabState(String expectedValue){
		
		actualValue = driver.findElement(By.cssSelector("#tab-cruise-tab")).getAttribute("class");	
		
		if (actualValue.equals(expectedValue)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean testThingsToDoTabState(String expectedValue){
		
		actualValue = driver.findElement(By.cssSelector("#tab-activity-tab")).getAttribute("class");	
		
		if (actualValue.equals(expectedValue)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void datePicker(String dd, String mm, String yyyy) throws Exception{
		
		WebElement nextButton;
		boolean dateFound = false;
		String testDay, testMonth, testYear, expectedDate, actualDate; 
		List<WebElement> dates = new ArrayList <WebElement> ();
		
		expectedDate = dd.concat(mm).concat(yyyy);
		nextButton = driver.findElement(By.xpath("//*[@id='home-page']/div[17]/div/div/button[2]"));		
		dates = driver.findElement(By.xpath("//*[@id='home-page']/div[17]/div/div/section[1]/ul")).findElements(By.tagName("a"));
			
		for (WebElement e: dates){
			testDay = e.getAttribute("data-day");
			testMonth = e.getAttribute("data-month");
			testYear = e.getAttribute("data-year");
			
			actualDate = testDay.concat(testMonth).concat(testYear);
			
			if (expectedDate.equals(actualDate)){
				e.click();
				dateFound = true;
			}
			
		}
		
		
		for (int i=0; i<10 && !dateFound; i++){
			
			dates = driver.findElement(By.xpath("//*[@id='home-page']/div[17]/div/div/section[2]/ul")).findElements(By.tagName("a"));
			
			for (WebElement e: dates){
				testDay = e.getAttribute("data-day");
				testMonth = e.getAttribute("data-month");
				testYear = e.getAttribute("data-year");
				
				actualDate = testDay.concat(testMonth).concat(testYear);
				
				if (expectedDate.equals(actualDate)){
					e.click();
					//dateValue = e.getText();
					dateFound = true;
				}
				
			}
			
			if (!dateFound){
				nextButton.click();
			}
			
		}
		
		if (!dateFound){
			throw new Exception("Invalid Date");
		}
		
		
	}
}
