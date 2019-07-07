package newstorepckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ProjectStore {

	protected static By tabSignin = By.xpath("//a[contains(text(),'Sign in')]");
	protected static By emailaddress = By.xpath("//input[ @id ='email']");
	protected static By password = By.xpath("//input[ @id ='passwd']");
	protected static By login = By.xpath("//button//span//i[@class='icon-lock left']");
	protected static By btnwomen = By.xpath("// a[@title='Women']");
	protected static By btndresses = By.xpath("//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']");
	protected static By btntshirts = By.xpath("//div[@id='block_top_menu']/ul/li[3]/a[@title='T-shirts']");
	protected static By btnorderhistry = By.xpath("//span[contains(text(),'Order history and details')]");
	protected static By btncreditslip = By.xpath("//span[contains(text(),'My credit slips')]");
	protected static By btnaddress = By.xpath("//span[contains(text(),'My addresses')]");
	protected static By btnpersonalinfo = By.xpath("//span[contains(text(),'My personal information')]");
	protected static By btnmywishlst = By.xpath("//span[contains(text(),'My wishlists')]");
	protected static By selecteditem = By.xpath("//img[@alt='Faded Short Sleeve T-shirts']");
	protected static By iconlist = By.xpath("//a[contains(text(),'List')]");
	protected static By btnmore = By.xpath("(//div[@class='product-container'])[1]/div/div[3]/div/div[2]/a[2]/span");
	protected static By selecteditemtitle = By.xpath("//h1[@itemprop='name']");
	protected static By btnaddtocart = By.xpath("//span[contains(text(),'Add to cart')]");
	protected static By btnclosewindow = By.xpath("//span[@title='Close window']");
	protected static By btnshoppingcart = By.xpath("//a[@title='View my shopping cart']//span[2]");
	protected static By txtcartitemdescription = By.xpath("//td[@class='cart_description']//p/a");

	@Test(enabled = true)
	// Login with existing user and verifies 'My Account'
	// page
	public void TC_01() {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open 'MyStore' URL
		String website = "http://automationpractice.com/index.php";
		String expectedTitle = "My Store";
		driver.get(website);
		String actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("MyStore website opened.Happy Shopping!");
		} else {
			System.out.println("Sorry unable to open 'MyStore' website");
		}

		// Maximize the window
		driver.manage().window().maximize();

		// Login into MyStore with existing user
		WebElement signIn = driver.findElement(tabSignin);
		System.out.println("User please SignIn");
		signIn.click();

		WebElement mailaddress = driver.findElement(emailaddress);
		mailaddress.sendKeys("priyanka.holambe@gmail.com");
		WebElement loginpassword = driver.findElement(password);
		loginpassword.sendKeys("Jaigurudev6$");
		WebElement loginbutton = driver.findElement(login);
		loginbutton.click();

		// Verify elements on 'MyAccount' page

		WebElement womenBtn = driver.findElement(btnwomen);
		WebElement dressesBtn = driver.findElement(btndresses);
		WebElement tshirtBtn = driver.findElement(btntshirts);
		WebElement orderhistoryBtn = driver.findElement(btnorderhistry);
		WebElement creditslipsBtn = driver.findElement(btncreditslip);
		WebElement addressBtn = driver.findElement(btnaddress);
		WebElement personalinfoBtn = driver.findElement(btnpersonalinfo);
		WebElement mywishlistBtn = driver.findElement(btnmywishlst);

		AssertJUnit.assertEquals(true, womenBtn.isDisplayed());
		AssertJUnit.assertEquals(true, dressesBtn.isDisplayed());
		AssertJUnit.assertEquals(true, tshirtBtn.isDisplayed());
		AssertJUnit.assertEquals(true, orderhistoryBtn.isDisplayed());
		AssertJUnit.assertEquals(true, creditslipsBtn.isDisplayed());
		AssertJUnit.assertEquals(true, addressBtn.isDisplayed());
		AssertJUnit.assertEquals(true, personalinfoBtn.isDisplayed());
		AssertJUnit.assertEquals(true, mywishlistBtn.isDisplayed());

		System.out.println("My account page is successfully verified.User can proceed.");

		driver.close();

	}

	@Test(enabled = true)
	// Login into MyStore ,select an shopping item and verify if the same is added
	// into cart
	public void TC_02() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open 'MyStore' URL
		String website = "http://automationpractice.com/index.php";
		driver.get(website);

		// Maximize the window
		driver.manage().window().maximize();

		// Login into MyStore with existing user
		WebElement signIn = driver.findElement(tabSignin);
		System.out.println("User please SignIn");
		signIn.click();

		WebElement mailaddress = driver.findElement(emailaddress);
		mailaddress.sendKeys("priyanka.holambe@gmail.com");
		WebElement loginpassword = driver.findElement(password);
		loginpassword.sendKeys("Jaigurudev6$");
		WebElement loginbutton = driver.findElement(login);
		loginbutton.click();

		// Add item to cart from 'MyAccount' page and verify whether the same item is
		// added into cart
		driver.findElement(btnwomen).click();
		// click 'list' label
		Thread.sleep(4000);
		driver.findElement(iconlist).click();
		// click 'more' button
		Thread.sleep(4000);
		driver.findElement(btnmore).click();
		// Get title of selected item
		String titletext = driver.findElement(selecteditemtitle).getText();
		System.out.println(titletext);
		driver.findElement(btnaddtocart).click();

		// Close the pop up window
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnclosewindow));
		driver.findElement(btnclosewindow).click();
		// Open the shopping cart option
		driver.findElement(btnshoppingcart).click();
		String cartitemtext = driver.findElement(txtcartitemdescription).getText();
		// Verify if the selected item is added into the cart
		AssertJUnit.assertEquals(true, cartitemtext.contentEquals(titletext));
		System.out.println("Chosen item is succesfully added into cart");
		driver.close();

	}

}
