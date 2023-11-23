package MavenTestNG.MavenTestNG;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	@Parameters("Browser")
	@Test
	public void startBrowser(String browsername) {
		System.out.println("Selected browser-"+browsername);
		WebDriver driver=null;
		if(browsername.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browsername.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Google"),"Title Doesn't match");
		driver.quit();
		
	}
}
