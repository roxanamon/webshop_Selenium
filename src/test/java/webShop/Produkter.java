package webShop;

import org.junit.Test;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	
	public class Produkter {
		
		 WebDriver driver = new FirefoxDriver();

		
			@Before
			public void Produkter(){
				
			driver.get(" http://store.demoqa.com/");
			
			}
			
//Verifiera att ”Buy Now”-knappen leder till produktens produktsida
				
			@Test
			public void testi(){
			
			String proName = driver.findElement(By.cssSelector(".product_description>h2")).getText();
			driver.findElement(By.className("buynow")).click();
			
			String buyPro = driver.findElement(By.cssSelector(".prodtitle")).getText();
			Assert.assertEquals(proName, buyPro);
			driver.close();
		
			}	
		
			
//Verifiera att man kommer till produktens produktsida om man trycker på bilden

			@Test
			public void testii(){
				
			String proName = driver.findElement(By.cssSelector(".product_description>h2")).getText();
			driver.findElement(By.cssSelector(".slide")).click();
						
			String buyPro = driver.findElement(By.cssSelector(".prodtitle")).getText();
			System.out.println(buyPro);
			Assert.assertEquals(proName, buyPro);
			driver.close();

			}
			
			
//Verifiera att ”More Info”-länken leder till produktens produktsida

			@Test
			public void testiii(){
				
			String proName = driver.findElement(By.xpath("//div[@class='product_description'][1]/h2")).getText();
			driver.findElement(By.linkText("More Info >")).click();
			System.out.println("proName" + proName);
			String buyPro = driver.findElement(By.cssSelector(".prodtitle")).getText();
			System.out.println(buyPro);
			Assert.assertEquals(proName, buyPro);
			
			driver.close();

			}
			
//Verifiera att tre produkter visas i bildspelet och att det bläddras automatiskt TIPS: Produkten som aktuellt visas finns alltid i första div-elementet med class ”slide” i elementet som representerar bild			
	
			@Test
			public void testiv() throws InterruptedException{
			
				ArrayList<String> list = new ArrayList();
				
				for(int i=0 ; i<5 ; i++){
					
				String proName = driver.findElement(By.xpath("//div[@class='product_description'][1]/h2")).getText();
				System.out.println("first element"+ proName);
				
				if(!list.contains(proName))
				list.add(proName);
				
				TimeUnit.MILLISECONDS.sleep(5000);
				}
				
			System.out.println("list"+ list);
			Assert.assertEquals(3,list.size());

			driver.close();
			}
			
//Verifiera att det går att bläddra manuellt i bildspelet
			
			@Test
			public void testv() throws InterruptedException{		

				driver.findElement(By.xpath("//ul[@class='group']/a[2]")).click();
				TimeUnit.MILLISECONDS.sleep(1000);

				Assert.assertEquals(driver.findElement(By.xpath("//*[@id='slides']/div[1]/div[1]/h2")).getText(),"iPhone 5");
				
				driver.findElement(By.xpath("//ul[@class='group']/a[1]")).click();
				TimeUnit.MILLISECONDS.sleep(1000);

				Assert.assertEquals(driver.findElement(By.xpath("//*[@id='slides']/div[1]/div[1]/h2")).getText(),"Magic Mouse");
				
				driver.findElement(By.xpath("//ul[@class='group']/a[3]")).click();
				TimeUnit.MILLISECONDS.sleep(1000);

				Assert.assertEquals(driver.findElement(By.xpath("//*[@id='slides']/div[1]/div[1]/h2")).getText(),"iPod Nano Blue");
				
				driver.close();

			}
		}





