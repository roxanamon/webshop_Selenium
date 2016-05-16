package webShop;

	
	

import org.junit.Test;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

	
	public class Latest_Blog_Post {
		
		 WebDriver driver = new FirefoxDriver();
		
		 
			@Before
			public void Produkter(){
				
			driver.get(" http://store.demoqa.com/");
			
			}
			
//Verifiera att ”Latest Blog Post”-sektionen visar produkter	
			
			@Test
			public void testi(){
			
				List<WebElement> list = driver.findElements(By.xpath("//*[@id='footer']/section[2]/ul/li"));
				Assert.assertEquals("Error unexpected number of items", 4, list.size());
				  
			}
	
//Verifiera att produkttitlarna leder till produktens produktsida

			@Test
			public void testii(){
				
				//det funkar med följande koder också
				/*
				 public void testii() throws InterruptedException {
				String prodTitle = driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[1]")).getText();
				driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[1]")).click();
				assertEquals(prodTitle,driver.findElement(By.xpath("//*[@id='single_product_page_container']/div/div[2]/h1")).getText());
				} 
				 */
			
				String proName = driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[1]")).getText();
							
					if(proName.endsWith ("...")) {
						proName = proName.substring(0, proName.length()-3);
						 //proName = proName.substring(0, proName.indexOf("-"));
					}
				
				driver.findElement(By.className("more")).click();
				System.out.println("proName" + proName);
				String details = driver.findElement(By.cssSelector(".prodtitle")).getText();

				System.out.println(details);
				Assert.assertTrue("Unexpected product name, blog post title: " + proName + " - product page title: " + details, details.contains(proName));
				
				driver.close();

				}

			
//Verifiera att man kommer till produktens produktsida om man trycker på bilden
				@Test
				public void testiii() throws InterruptedException {
	
				String prodTitle = driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[1]")).getText();
				
				
				driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[2]")).click();
				driver.findElement(By.xpath("//*[@id='single_product_page_container']/div/div[2]/h1")).getText();
						
				if(prodTitle.endsWith ("...")) {
					prodTitle = prodTitle.substring(0, prodTitle.length()-3);
					 //proName = proName.substring(0, proName.indexOf("-"));
				}
				System.out.println(prodTitle);
				
				Assert.assertTrue(driver.findElement(By.xpath("//*[@id='single_product_page_container']/div/div[2]/h1")).getText().contains(prodTitle));
	
				driver.close();

				} 
				

//Verifiera att ”More Details”-länken leder till produktens produktsida								
				@Test
				public void testiv() throws InterruptedException {
	
				String prodTitle = driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[1]")).getText();
				driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[1]/a[3]")).click();
			
				
				if(prodTitle.endsWith ("...")) {
					prodTitle = prodTitle.substring(0, prodTitle.length()-3);
					 //proName = proName.substring(0, proName.indexOf("-"));
				}
	
				Assert.assertTrue(driver.findElement(By.xpath("//*[@id='single_product_page_container']/div/div[2]/h1")).getText().contains(prodTitle));

				driver.close();

				} 
			}
			
		








