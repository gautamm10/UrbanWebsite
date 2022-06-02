package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']")).click();
		driver.findElement(By.linkText("Log In")).click();
		//for email section....
		driver.findElement(By.xpath("//input[@class='email required input_authentication']")).sendKeys("ga97932030@gmail.com");
		// for password fields
		driver.findElement(By.xpath("//input[@class='required input_authentication']")).sendKeys("gauTam@1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		

	}

}
