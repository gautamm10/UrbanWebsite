package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com");
		
		driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']")).click();
		driver.findElement(By.linkText("Log In")).click();
		//for email....
		driver.findElement(By.xpath("//input[@class='email required input_authentication']")).sendKeys("ga97932030@gmail.com");
		// for password......
		driver.findElement(By.xpath("//input[@class='required input_authentication']")).sendKeys("gauTam@1234");
		//for login button
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		driver.findElement(By.id("search")).sendKeys("sofa");

		driver.findElement(By.xpath("//button[@id='search_button']")).click();
		System.out.println(driver.findElement(By.xpath("(//span[@class='name'])[1]")).getText());

		String price = driver.findElement(By.xpath("(//a[@class='product-title-block'] //span[@class='pricing'])[1]")).getText();
				//price contains like "Starting From rs68,364

		String actualPrice = price.substring(14);

		System.out.println(actualPrice);

		driver.findElement(By.xpath("//img[@alt='Franco Sofa (Licorice Italian Leather)']")).click();

		String RealPrice = driver.findElement(By.xpath("//div[@class='price final']")).getText();

		System.out.println(RealPrice);

		if(actualPrice.equals(RealPrice)) {

		System.out.println("Price before clicking "+actualPrice+"Price after clicking "+RealPrice);

		}else {

		System.out.println("Price does not match...");
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		System.out.println("Title of the page is "+driver.getTitle()); 
		
		driver.findElement(By.linkText("Change Pincode")).click();

		WebElement pincode = driver.findElement(By.xpath("//input[@class='user-pincode']")); 
		pincode.clear();

		pincode.sendKeys("110001");

		driver.findElement(By.xpath("//button[@class='primary action-button btn-sm']")).click();

		Thread.sleep(2000);

		System.out.println("item delivery date is: "+driver.findElement(By.xpath("//div[@class='delivery-date']")).getText());
		//select quantity 3.. 
		Select dropDown = new Select( driver.findElement(By.id("select_0_quantity")));

		dropDown.selectByVisibleText("3"); 
		Thread.sleep(2000);

		//after select then we can get the total price and print on the console...

		System.out.println("Total price after selecting the quantity 3 is: "+driver.findElement(By.xpath("//div[@class='final-price']")).getText());
		 // go to home page and click on logout...

		driver.findElement(By.xpath("//img[@class='logo-img']")).click();
		Actions profile = new Actions(driver);
		WebElement menu2 = driver.findElement(By.xpath("//li[@class='header__topBarIconList_profile-icon']"));
		profile.moveToElement(menu2).perform();
		driver.findElement(By.id("logout")).click();
		driver.close();
		
	}
}

