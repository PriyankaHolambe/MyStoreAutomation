package newstorepckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProjectStore {

	protected static By tabSignin = By.xpath("//a[contains(text(),'Sign in')]");
	protected static By emailaddress = By.xpath("//input[ @id ='email']");
	protected static By password = By.xpath("//input[ @id ='passwd']");
	protected static By login = By.xpath("//button//span//i[@class='icon-lock left']");
	protected static By tabwomen = By.xpath( "// a[@title='Women']");

	@Test
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

		// Test Scenario 1: Login into MyStore with existing user
		WebElement signIn = driver.findElement(tabSignin);
		System.out.println("Hit SignIn Tab");
		signIn.click();

		WebElement mailaddress = driver.findElement(emailaddress);
		mailaddress.sendKeys("priyanka.holambe@gmail.com");
		WebElement loginpassword = driver.findElement(password);
		loginpassword.sendKeys("Jaigurudev6$");
		WebElement loginbutton = driver.findElement(login);
		loginbutton.click();

		// Test Scenario 2 : Verify 'MyAccount' page
		SoftAssert softAssert = new SoftAssert();
		boolean subtabWomen = driver.findElement(tabwomen).isDisplayed();
		
		softAssert.assertEquals(subtabWomen, true);

		// close Chrome Driver
		// driver.close();

	}

}
