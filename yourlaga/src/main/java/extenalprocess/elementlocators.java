package extenalprocess;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class elementlocators {
	//Sign Link
	@FindBy(xpath="//*[@class='login']")
	public static WebElement loginclk;
	@FindBy(xpath="//*[@id='SubmitCreate']")
	public static WebElement cAcBtn;
	@FindBy(xpath="//*[@id='create_account_error']/ol/li")
	public static WebElement eremsg;
	@FindBy(xpath="//*[@id='email_create']")
	public static WebElement emailbox;
	@FindBy(xpath="//*[@title='Log me out']")
	public static WebElement logout;
	
	@FindBy(xpath="//*[@id='email']")
	public static WebElement Lgeid;
	@FindBy(xpath="//*[@id='passwd']")
	public static WebElement Lgpwd;
	@FindBy(xpath="//*[@id='SubmitLogin']")
	public static WebElement Lgbtn;
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	public static WebElement logo;
	
	
	
	//Sign Form element
	@FindBy(xpath="//*[@for='id_gender1']")
	public static WebElement RB_mr;
	@FindBy(xpath="//*[@for='id_gender2']")
	public static WebElement RB_mrs;
	@FindBy(xpath="//*[@id='customer_firstname']")
	public static WebElement fnam;
	@FindBy(xpath="//*[@id='customer_lastname']")
	public static WebElement lnam;
	@FindBy(xpath="//*[@id='passwd']")
	public static WebElement pwd;
	@FindBy(xpath="//*[@id='days']")
	public static WebElement day;
	@FindBy(xpath="//*[@id='months']")
	public static WebElement month;
	@FindBy(xpath="//*[@id='years']")
	public static WebElement year;
	@FindBy(xpath="//*[@id='newsletter']")
	public static WebElement tkbx1;
	@FindBy(xpath="//*[@id='address1']")
	public static WebElement address;
	@FindBy(xpath="//*[@id='city']")
	public static WebElement city;
	@FindBy(xpath="//*[@id='id_state']")
	public static WebElement state;
	@FindBy(xpath="//*[@id='postcode']")
	public static WebElement pin;
	@FindBy(xpath="//*[@id='id_country']")
	public static WebElement countrys;
	@FindBy(xpath="//*[@id='phone_mobile']")
	public static WebElement mno;
	@FindBy(xpath="//*[@id='submitAccount']")
	public static WebElement regbtn;
	
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[1]/a")
	public static WebElement witbtn;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li")
	public static List <WebElement>  ermsg;
	
	
	
	
	// Product Search
	@FindBy(xpath="//*[@id='center_column']/ul/li//div//img")
	public static List <WebElement> product;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public static WebElement WmnLink;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	public static WebElement Tshirts;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a")
	public static WebElement blouse;
	@FindBy(xpath="//*[@id='center_column']//h1")
	public static WebElement title;
	@FindBy(xpath="//*[@id='quantity_wanted_p']/a[2]")
	public static WebElement qtpls;
	@FindBy(xpath="//*[@id='quantity_wanted_p']/a[1]")
	public static WebElement qtmins;
	@FindBy(xpath="//*[@id='quantity_wanted']")
	public static WebElement qttxtbox;
	@FindBy(xpath="//*[@id='group_1']")
	public static WebElement sizedropbox;
	@FindBy(xpath="//*[@id='add_to_cart']/button")
	public static WebElement addtocart;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a")
	public static WebElement cdress;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[2]/a")
	public static WebElement evedress;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a")
	public static WebElement summerdress;
	
	
	
	
	
	
	
	
	

}
