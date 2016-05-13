package webShop;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Produktsidor {

		 WebDriver driver = new FirefoxDriver();
		
			@Before
			public void Produkter(){
			driver.get(" http://store.demoqa.com/");
			}
			
//Verifiera att produktsidan innehåller Titel Produktbeskrivning Pris
			
			@Test
			public void produktsidor() throws InterruptedException {
				
				String title= driver.findElement(By.xpath("//div[@class='product_description'][1]/h2")).getText();
				String Edescription= driver.findElement(By.xpath("//div[@class='product_description']/p")).getText();
				String Eprice= driver.findElement(By.xpath("//div[@class='product_meta']/div/p")).getText();

				System.out.println("String description = "+ Edescription);
				System.out.println("String title = "+ title);
				System.out.println("String price = "+ Eprice);
				
				driver.findElement(By.linkText("More Info >")).click();
				//System.out.println("proName" + proName);
				
				String Adescription= driver.findElement(By.xpath("//div[@class='product_description']/p")).getText();
				String Aprice= driver.findElement(By.xpath("//div[@class='wpsc_product_price']/p[2]/span")).getText();
	
				System.out.println("String description = "+ Adescription);
				System.out.println("String title = "+ title);
				System.out.println("String price = "+ Aprice);
				 
				Assert.assertTrue(driver.getTitle().contains(title));
				Assert.assertEquals(Edescription, Adescription);
				Assert.assertEquals(Eprice, Aprice);

				driver.close();

			} 
			
//Verifiera att det går att lägga produkten i varukorgen
			
			@Test
			public void varukorg() throws InterruptedException {
				driver.findElement(By.xpath("//div[@class='product_description'][1]/h2")).getText();
				driver.findElement(By.linkText("More Info >")).click();
				
				String Bvarukorg=driver.findElement(By.className("count")).getText();

				driver.findElement(By.className("wpsc_buy_button")).click();
				TimeUnit.MILLISECONDS.sleep(2000);
				driver.findElement(By.className("continue_shopping")).click();

				String Avarukorg=driver.findElement(By.className("count")).getText();
				
				Assert.assertNotEquals(Bvarukorg, Avarukorg);
				
				driver.close();				
				
			}
		}







