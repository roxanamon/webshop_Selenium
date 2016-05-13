package webShop;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddToCart {

		 WebDriver driver = new FirefoxDriver();

			@Before
			public void Produkter(){
				
			driver.get(" http://store.demoqa.com/");
			
			}
			
//Verifiera att korrekt produkttitel visas i fönstret som dyker upp när man trycker på ”Add To Cart”
			
			@Test
			public void varukorga() throws InterruptedException {
				
				String Bobject=driver.findElement(By.xpath("//div[@class='product_description'][1]/h2")).getText();
				driver.findElement(By.linkText("More Info >")).click();

				driver.findElement(By.className("wpsc_buy_button")).click();
				TimeUnit.MILLISECONDS.sleep(2000);
				String Aobject= driver.findElement(By.id("fancy_notification_content")).getText();
				System.out.println(Aobject);

				Assert.assertTrue(Bobject,Aobject.contains(Bobject));
				driver.close();
			}
			

//b. Verifiera att ”Go to Checkout”-knappen fungerar
			
			@Test
			public void varukorgb() throws InterruptedException {
				driver.findElement(By.linkText("More Info >")).click();
				
				driver.findElement(By.className("wpsc_buy_button")).click();
				TimeUnit.MILLISECONDS.sleep(2000);
				driver.findElement(By.className("go_to_checkout")).click();
				
				Assert.assertTrue(driver.getTitle().contains("Checkout"));	
				driver.close();
			}
			
//c. Verifiera att ”Continue Shopping”-knappen fungerar
			
			@Test
			public void varukorgc() throws InterruptedException {
				String Bobject=driver.findElement(By.xpath("//div[@class='product_description'][1]/h2")).getText();
				driver.findElement(By.linkText("More Info >")).click();
				
				driver.findElement(By.className("wpsc_buy_button")).click();
				TimeUnit.MILLISECONDS.sleep(2000);
				driver.findElement(By.className("continue_shopping")).click();
				
				Assert.assertTrue(driver.getTitle().contains(Bobject));	
				driver.close();

			}		
}





