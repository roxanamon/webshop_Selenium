package webShop;


import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Checkout {

		 WebDriver driver = new FirefoxDriver();
		
			@Before
			public void Produkter(){				
			driver.get(" http://store.demoqa.com/");
			}

//a. Tom varukorg	i. Verifiera att texten ”Oops, there is nothing in your cart.” visas
			@Test
			public void checkouta() throws InterruptedException {
				
				driver.findElement(By.linkText("More Info >")).click();
				driver.findElement(By.className("wpsc_buy_button")).click();
				
				TimeUnit.MILLISECONDS.sleep(5000);
				driver.findElement(By.className("go_to_checkout")).click();
				
				TimeUnit.MILLISECONDS.sleep(2000);
				while (!driver.findElements(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]")).isEmpty()){
				driver.findElement(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]")).click();
				}
				String Adelete = driver.findElement(By.className("entry-content")).getText();	
				
				TimeUnit.MILLISECONDS.sleep(2000);
				Assert.assertEquals ("Oops, there is nothing in your cart.", Adelete);
				
			}	
							
}	


