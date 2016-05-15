package webShop;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


	public class Search {

			 WebDriver driver = new FirefoxDriver();
			
				@Before
				public void Produkter(){				
				driver.get("http://store.demoqa.com/");
				}
				
//4.”Search Products” – Verifiera att det går att söka efter produkter
				@Test
				public void search() throws InterruptedException {
					
					 /*WebElement searchEl = driver.findElement(By.className("search"));
					 searchEl.sendKeys("mouse");
					 searchEl.submit();
					 
					TimeUnit.MILLISECONDS.sleep(2000);
					
					String searchRe = searchEl.getAttribute("alt").toString();
					System.out.println("s" + searchRe);
					
					assertEquals("The product is not found " +searchEl , true, searchRe.contains("mouse"));*/

					
					String proSrch = "mouse";
					driver.findElement(By.name("s")).clear();
					driver.findElement(By.name("s")).sendKeys(proSrch);
					driver.findElement(By.name("s")).sendKeys(Keys.RETURN);
					
					WebElement resultList = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div/div/div/a/img"));
					
					String resSrch = resultList.getAttribute("alt").toString();
					System.out.println(resSrch);

					assertEquals(proSrch + "is not in the list", true,resSrch.contains("Mouse"));
					
					driver.close();
					
				}
				
	}

