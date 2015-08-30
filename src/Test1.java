import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test1 {
	
	String expectedData = "";
	String actualData = "";
	boolean returnValue = false;
	static WebDriver driver = new FirefoxDriver();
	
	
//	@Rule
//	public ErrorCollector ec = new ErrorCollector();
	
	ReusableMethods reuse = new ReusableMethods(driver);
	
	@BeforeTest
	public static void launchWebsite (){
		driver.get("http://www.expedia.com/");
	}
	
	@Test
	public void testBundleDealTab() throws Exception{
		
		try{
			returnValue = reuse.testBundleDealsTabState("on");
			Assert.assertTrue(returnValue);
			
		}
		catch (Throwable t){
			throw new Exception("testBundleDealTab Failed");
		}
		
	}
	
	@Test
	public void testCarTab() throws Exception{
		
		try{
			
			returnValue = reuse.testCarsTabState("");
			Assert.assertTrue(returnValue);
			
		}
		catch (Throwable t){
			throw new Exception("testCarTab Failed");
		}
		
	}
	
	@Test
	public void testCruiseTab() throws Exception{
		
		try{
			
			returnValue = reuse.testCruisesTabState("");
			Assert.assertTrue(returnValue);
			
		}
		catch (Throwable t){
			throw new Exception("testCruiseTab Failed");
		}
		
	}
	
	@Test
	public void testFlightsTab() throws Exception{
		
		try{
			
			returnValue = reuse.testFlightsTabState("");
			Assert.assertTrue(returnValue);
			
		}
		catch (Throwable t){
			throw new Exception("testFlightsTab Failed");
		}
		
	}
	
	@Test
	public void testHotelsTab() throws Exception{
		
		try{
			
			returnValue = reuse.testHotelsTabState("");
			Assert.assertTrue(returnValue);
			
		}
		catch (Throwable t){
			throw new Exception("testHotelsTab Failed");
		}
		
	}
	
	@Test
	public void testThingsToDoTab() throws Exception{
		
		try{
			
			returnValue = reuse.testThingsToDoTabState("");
			Assert.assertTrue(returnValue);
			
		}
		catch (Throwable t){
			throw new Exception("testThingsToDoTab Failed");
		}
		
	}
	
	
	
	@AfterTest
	public static void closeBrowser (){
		driver.quit();
	}
	
}
