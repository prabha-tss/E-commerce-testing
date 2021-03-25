package extenalprocess;

import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class suboperations {
	public void productinfo(WebDriver driver, ExtentTest signin_test,XSSFSheet product_Sheet,WebElement wmnLink) {
		PageFactory.initElements(driver, elementlocators.class);
		Actions mouseact = new Actions(driver);
		  mouseact.moveToElement(elementlocators.WmnLink).build().perform();
		  mouseact.moveToElement(wmnLink).build().perform();
		  wmnLink.click();
		String xp1="//*[@id='center_column']/ul/li[";
		String xp2="]/div/div[2]/h5/a";
		int pct = elementlocators.product.size();
		System.out.println("Product count is "+pct);
		String ctwind = driver.getWindowHandle();
		for (int j=1;j<=pct;j++) {
			WebDriverWait wit = new WebDriverWait(driver,20);
			wit.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='center_column']/ul/li//div//img")));
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			
			driver.findElement(By.xpath(xp1+j+xp2)).sendKeys(selectLinkOpeninNewTab);
			System.out.println("Tab Open"+driver.getWindowHandle());
			Set<String> winh = driver.getWindowHandles();
			for (String hnd : winh) {
				if(!ctwind.equals(hnd)) {
					driver.switchTo().window(hnd);
					int sheetct= product_Sheet.getLastRowNum();
					for(int i=1;i<=sheetct;i++) {
						String cellval= product_Sheet.getRow(i).getCell(0).toString();
						String temptit = elementlocators.title.getText();
						if(cellval.equals(temptit)) {
							System.out.println("we find the product");
						}
					}
					signin_test.pass("Product find");
					String bfqtval = elementlocators.qttxtbox.getText();
					elementlocators.qtpls.click();
					elementlocators.qtmins.click();
					String afqtval = elementlocators.qttxtbox.getText();
					if(bfqtval.equals(afqtval)) {
						System.out.println("qty butten is working fine");
						signin_test.pass("Qty Butten is working");
					}
					elementlocators.qttxtbox.clear();
					elementlocators.qttxtbox.sendKeys("5");
					Select sizesel = new Select(elementlocators.sizedropbox);
					sizesel.selectByVisibleText("M");
					driver.close();
				}
			}
			driver.switchTo().window(ctwind);
			
			
		  }		
	}
}
