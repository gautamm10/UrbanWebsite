package Testing;

import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Bedroom_link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='topnav_item bedroomunit']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Beds with Storage')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Baltoro High Gloss Hydraulic Storage White Bed ')]")).click();
		Set<String>ids = driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		 //*[@id="add-to-cart-button"]
		  // driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
		   System.out.println(driver.findElement(By.xpath("//h1[@class='product-title']")).getText());
		   //driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		   driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[3]/div[3]/div[1]/div[2]/div[1]/div[7]/form[1]/div[1]/div[2]/div[2]/div[3]/button[1]")).click();

	}

}
