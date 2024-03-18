package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.InboxPage;
import pages.LoginPage;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;

	public static LoginPage loginPage;
	public static InboxPage inboxPage;

	public Logger log = Logger.getLogger(BaseTest.class);

	public static FileInputStream fis = null;

	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(readproperty("url"));
		loginPage = new LoginPage(driver);
		inboxPage = new InboxPage(driver);
	}

	public static String readproperty(String key) {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir");
		try {
			fis = new FileInputStream(path + "/src/test/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
		}
		return prop.getProperty(key);
	}

	public void reportInit() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport.html");
		report.attachReporter(spark);

	}

}
