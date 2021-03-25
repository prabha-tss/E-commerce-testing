package extenalprocess;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;


public class elementactions extends suboperations {
	static XSSFWorkbook workbook;
	static String eid;
	suboperations operation = new suboperations();
	
	
	public void accreat(WebDriver driver, ExtentTest ac_test ) throws IOException {
		PageFactory.initElements(driver, elementlocators.class);
		FileInputStream wb = new FileInputStream("F:\\Eclipse Works\\yourlaga\\inputdata\\testdata.xlsx");
		workbook = new XSSFWorkbook(wb);
		XSSFSheet eid_Sheet= workbook.getSheet("acemail");
		int eidRowCT = eid_Sheet.getLastRowNum();
		for(int i=1;i<=eidRowCT;i++) {
			XSSFRow row = eid_Sheet.getRow(i);
			String tempeid = row.getCell(0).toString();	
			elementlocators.emailbox.sendKeys(tempeid);
			elementlocators.cAcBtn.click();
			try {
				WebDriverWait wit = new WebDriverWait(driver,10);
				wit.until(ExpectedConditions.elementToBeClickable(elementlocators.fnam));
				boolean erdisp = elementlocators.fnam.isDisplayed();
				if(erdisp==true) {
					ac_test.pass(tempeid);
					eid=tempeid;
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			ac_test.fail("Test Data"+tempeid);
			driver.navigate().refresh();
		}	
		
	}
	public void signupform(WebDriver driver,ExtentTest AcFm_test) throws IOException {
		PageFactory.initElements(driver, elementlocators.class);
		FileInputStream wb = new FileInputStream("F:\\Eclipse Works\\yourlaga\\inputdata\\testdata.xlsx");
		workbook = new XSSFWorkbook(wb);
		XSSFSheet sup_Sheet= workbook.getSheet("signup_Dt");
		int rowct = sup_Sheet.getLastRowNum();
		for(int i =1;i<=rowct; i++) {
		
			try {
				boolean eidd = elementlocators.emailbox.isDisplayed();
				if(eidd==true) {
					elementlocators.emailbox.sendKeys(eid);
					elementlocators.cAcBtn.click();
					WebDriverWait wit = new WebDriverWait(driver,10);
					wit.until(ExpectedConditions.elementToBeClickable(elementlocators.fnam));
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			XSSFRow row = sup_Sheet.getRow(i);
			try {
				String Temp_tit = row.getCell(0).toString();
				if(Temp_tit.equalsIgnoreCase("mr")) {
					elementlocators.RB_mr.click();
				}
				if(Temp_tit.equalsIgnoreCase("mrs")) {
					elementlocators.RB_mrs.click();
				}
			} catch (NullPointerException e) {
				System.out.println(e);
			}
			try {
				String Temp_fnm = row.getCell(1).toString();
				elementlocators.fnam.sendKeys(Temp_fnm);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String Temp_lnm = row.getCell(2).toString();
				elementlocators.lnam.sendKeys(Temp_lnm);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String pwd = row.getCell(3).toString();
				elementlocators.pwd.sendKeys(pwd);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
			try {
				String Temp_Dt = row.getCell(4).toString();
				Select dt = new Select(elementlocators.day);
				dt.selectByVisibleText(Temp_Dt+"  ");
			} catch (NullPointerException e) {
				// TODO: handle exception
			}	
			try {
				String Temp_month = row.getCell(5).toString();
				Select month = new Select(elementlocators.month);
				month.selectByVisibleText(Temp_month);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
			try {
				String Temp_year = row.getCell(6).toString();
				Select year = new Select(elementlocators.year);
				year.selectByVisibleText(Temp_year);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String Temp_tkbox = row.getCell(7).toString();
				if(Temp_tkbox.equalsIgnoreCase("yes")) {
					elementlocators.tkbx1.click();
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
			try {
				String Temp_ads = row.getCell(8).toString();
				elementlocators.address.sendKeys(Temp_ads);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String Temp_cty = row.getCell(9).toString();
				elementlocators.city.sendKeys(Temp_cty);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String Temp_stat = row.getCell(10).toString();
				Select stat = new Select(elementlocators.state);
				stat.selectByVisibleText(Temp_stat);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String Temp_pin = row.getCell(11).toString();
				elementlocators.pin.sendKeys(Temp_pin);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String Temp_mno = row.getCell(12).toString();
				elementlocators.mno.sendKeys(Temp_mno);
				elementlocators.regbtn.click();
				
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				WebDriverWait wit = new WebDriverWait(driver,10);
				wit.until(ExpectedConditions.elementToBeClickable(elementlocators.witbtn));
				
				boolean brklop = elementlocators.witbtn.isDisplayed();
				if(brklop == true) {
					String TestRes = row.getCell(13).toString();
					AcFm_test.pass("Test Id"+ TestRes);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			for (WebElement er : elementlocators.ermsg) {
				AcFm_test.fail("Test Id"+ er.getText());
			}			
			String curl= driver.getCurrentUrl();
			driver.get(curl);
		}
	}
	public void login(WebDriver driver, ExtentTest signin_test) throws IOException {
		PageFactory.initElements(driver, elementlocators.class);
		elementlocators.loginclk.click();
		FileInputStream wb = new FileInputStream("F:\\Eclipse Works\\yourlaga\\inputdata\\testdata.xlsx");
		workbook = new XSSFWorkbook(wb);
		XSSFSheet Lg_Sheet= workbook.getSheet("Login_Data");
		int eidRo = Lg_Sheet.getLastRowNum();
		for(int i=1;i<=eidRo;i++) {
			XSSFRow row = Lg_Sheet.getRow(i);
			try {
				String eid = row.getCell(0).toString();
				elementlocators.Lgeid.sendKeys(eid);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				String LgPwd = row.getCell(1).toString();
				elementlocators.Lgpwd.sendKeys(LgPwd);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			elementlocators.Lgbtn.click();
			try {
				WebDriverWait wit = new WebDriverWait(driver,10);
				wit.until(ExpectedConditions.elementToBeClickable(elementlocators.witbtn));
				boolean brklop = elementlocators.witbtn.isDisplayed();
				if(brklop == true) {
					String tcid = row.getCell(2).toString();
					signin_test.pass(tcid);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			String tcid = row.getCell(2).toString();
			signin_test.fail(tcid);
			driver.get(driver.getCurrentUrl());
		}
		elementlocators.logo.click();
	}
	public void womanact(WebDriver driver, ExtentTest signin_test) throws IOException {
		  PageFactory.initElements(driver, elementlocators.class);
		  FileInputStream wb = new FileInputStream("F:\\Eclipse Works\\yourlaga\\inputdata\\testdata.xlsx");
			workbook = new XSSFWorkbook(wb);
			XSSFSheet product_Sheet= workbook.getSheet("Product_det");
		  operation.productinfo(driver,signin_test,product_Sheet,elementlocators.WmnLink);
		  operation.productinfo(driver,signin_test,product_Sheet,elementlocators.blouse);
		  operation.productinfo(driver,signin_test,product_Sheet,elementlocators.cdress);
		  operation.productinfo(driver,signin_test,product_Sheet,elementlocators.evedress);
		  operation.productinfo(driver,signin_test,product_Sheet,elementlocators.summerdress);
	}
}
