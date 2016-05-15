package webShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


//Verifiera då även att rätt produktkategori visas (trycker man t.ex. på ”Accessories” så ska kategorien ”Accessories” öppnas)

public class ProductCategory {
	
		 WebDriver driver = new FirefoxDriver();
		
			@Before
			public void Produkter(){
				
			driver.get("http://store.demoqa.com/");
			
			}
						
					@Test
					public void testProductcategori() throws Exception {
						
					Actions select1 = new Actions(driver);
					WebElement prodCat = driver.findElement(By.id("menu-item-33"));
					select1.moveToElement(prodCat).perform();
					WebElement accessories = driver.findElement(By.xpath("//*[@id='menu-item-34']/a"));
					accessories.click();
					Assert.assertEquals("Accessories | ONLINE STORE",  driver.getTitle());
					
					driver.close();
					
					}
				
					
					@Test
					public void testProductcategori2() throws Exception {
						
					Actions select2 = new Actions(driver);
					WebElement prodCat = driver.findElement(By.id("menu-item-33"));
					select2.moveToElement(prodCat).perform();
					WebElement iMacs = driver.findElement(By.xpath("//*[@id='menu-item-35']/a"));
					iMacs.click();
					Assert.assertEquals("iMacs | ONLINE STORE",  driver.getTitle());
					
					driver.close();
					
					}
					
					@Test
					public void testProductcategori3() throws Exception {
						
					Actions select3 = new Actions(driver);
					WebElement prodCat = driver.findElement(By.id("menu-item-33"));
					select3.moveToElement(prodCat).perform();
					WebElement iPads = driver.findElement(By.xpath("//*[@id='menu-item-36']/a"));
					iPads.click();
					Assert.assertEquals("iPads | ONLINE STORE",  driver.getTitle());
					
					driver.close();
					
					}
					
					@Test
					public void testProductcategori4() throws Exception {
						
					Actions select4 = new Actions(driver);
					WebElement prodCat = driver.findElement(By.id("menu-item-33"));
					select4.moveToElement(prodCat).perform();
					WebElement iPhones = driver.findElement(By.xpath("//*[@id='menu-item-37']/a"));
					iPhones.click();
					Assert.assertEquals("iPhones | ONLINE STORE",  driver.getTitle());
					
					driver.close();
					
					}
					
					@Test
					public void testProductcategori5() throws Exception {
						
					Actions select5 = new Actions(driver);
					WebElement prodCat = driver.findElement(By.id("menu-item-33"));
					select5.moveToElement(prodCat).perform();
					WebElement iPods = driver.findElement(By.xpath("//*[@id='menu-item-38']/a"));
					iPods.click();
					Assert.assertEquals("iPods | ONLINE STORE",  driver.getTitle());
					
					driver.close();
					
					}
					
					@Test
					public void testProductcategori6() throws Exception {
						
					Actions select6 = new Actions(driver);
					WebElement prodCat = driver.findElement(By.id("menu-item-33"));
					select6.moveToElement(prodCat).perform();
					WebElement MacBooks = driver.findElement(By.xpath("//*[@id='menu-item-39']/a"));
					MacBooks.click();
					Assert.assertEquals("MacBooks | ONLINE STORE",  driver.getTitle());
					
					driver.close();
					
					}

				}

