package yourlaga;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import extenalprocess.elementactions;
import extenalprocess.elementlocators;

public class login extends elementactions {

	static WebDriver driver;
	static ChromeOptions options;
	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = new ExtentSparkReporter("F:\\Eclipse Works\\yourlaga\\Test_Email Report\\yourlagatestres.html");
	
	
	
	 @BeforeSuite
	  public void beforeSuite() throws IOException {
		 System.setProperty("webdriver.chrome.driver", "F:\\Selenium Driver\\chromedriver.exe");
			options = new ChromeOptions();
			options.addArguments("-start-maximized");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			driver = new ChromeDriver(options);
			driver.get("http://automationpractice.com/index.php");
			//Path of the excel file
			
	  }
  
  @BeforeMethod
  public void beforeMethod() {
	  extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("swaglabs");
		spark.config().setReportName("swaglabsTest");
  }
  @Test(priority=0)
  public void acCreation() throws IOException {
	  elementactions elact = new elementactions();
	  PageFactory.initElements(driver, elementlocators.class);
	  ExtentTest Ac_test = extent.createTest("SignUp Test");
	  ExtentTest AcFm_test = extent.createTest("SignUp Test Form");
	  ExtentTest signin_test = extent.createTest("Login Test Form");
	  elementlocators.loginclk.click();
	  elact.accreat(driver,Ac_test);
	  elact.signupform(driver, AcFm_test);
	  elementlocators.logout.click();
	  elementlocators.loginclk.click();
	  WebDriverWait cAcbtnwait = new WebDriverWait(driver,10);
	  cAcbtnwait.until(ExpectedConditions.elementToBeClickable(elementlocators.cAcBtn));
	  elact.login(driver, signin_test);
	  
  }
  @Test(priority=1)
  public void productchking() throws IOException{
	  elementactions elact = new elementactions();
	  PageFactory.initElements(driver, elementlocators.class);
	  ExtentTest productnav = extent.createTest("product Searching");
	  elact.womanact(driver, productnav);	  
	  
  }
  @AfterMethod
  public void afterMethod() {
	  extent.flush();
  }

 

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
