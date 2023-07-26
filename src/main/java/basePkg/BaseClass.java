package basePkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait explicitWait;
	public static FluentWait<WebDriver> fl;
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\eclipse-workspace"
					+ "\\NovemberTDDPOM\\src\\main\\java\\configPkg\\config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		  String browserName = prop.getProperty("browser");
			switch(browserName) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
			 	driver = new EdgeDriver();
			 	break;
			default: 
				System.err.println("Browser not supported");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds
					(Long.valueOf(prop.getProperty("implicitWaitTime"))));
			explicitWait = new WebDriverWait
					(driver, Duration.ofSeconds(Long.valueOf(prop.getProperty("explicitWaitTime"))));
			fl = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(Long.valueOf(prop.getProperty("fluentWaitTime"))))
						.pollingEvery(Duration.ofSeconds(Long.valueOf(prop.getProperty("pollingFrequency"))))
						.ignoring(NoSuchElementException.class);
			driver.get(prop.getProperty("testURL"));
	  }
	
	public void tearDown() {
		  driver.quit();
	  }
	
	public void backToLastPage() {
		  driver.navigate().back();  
	  }

}
