package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Signup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com");
		
		driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']")).click();
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.xpath("//input[@class='textfield email required input_authentication email-suggest']")).sendKeys("gautam959880@gmail.com");
		driver.findElement(By.xpath("//input[@class='textfield required input_authentication']")).sendKeys("gauTam@1234");
		driver.findElement(By.xpath("//input[@value='Sign Up']")).click();
		driver.close();

	}

}
