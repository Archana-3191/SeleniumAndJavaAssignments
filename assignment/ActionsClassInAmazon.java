package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassInAmazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//. Load the URL (https://www.amazon.in/)
		driver.get("https://www.amazon.in/");
		 WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

	        // Create an Actions object
	        Actions actions = new Actions(driver);

	        // Click the search box, type "oneplus 9 pro," and submit
	        actions.click(searchBox)
	               .sendKeys("oneplus 9 pro")
	               .build()
	               .perform();

	      //submit
	        actions.click(driver.findElement(By.id("nav-search-submit-button")))
	        .build()
	        .perform();
	        
	       //  Get the price of the first product.
	        Thread.sleep(3000);
	        WebElement priceOfFirstProduct=driver.findElement(By.xpath("//span[normalize-space()='37,999']"));
	       String priceText = priceOfFirstProduct.getText();
	       System.out.println("Price of the first product: "+priceText);
	       //Print the number of customer ratings for the first displayed product.
	     WebElement  firstProductRating=driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base s-underline-text'][normalize-space()='6']"));
	     String ratingText =firstProductRating.getText();
	     System.out.println("Rating of the first product: " + ratingText);
	     //Click the first text link of the first image.
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//img[@alt='(Refurbished) OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
	     //to get all the window handles
	     Set<String> windowHandles=driver.getWindowHandles();
	     for(String eachWindow:windowHandles) {
	    	 System.out.println(eachWindow);
	     }
	     //convert Set to list 
	     //****** i want to switch my window using index base so i convert my set to list its mandatory in index base switch 
	     List<String> listofHandles=new ArrayList<String>(windowHandles);
	     //switch to particular window using get()
	     String childHandle= listofHandles.get(1);
	     //switch driver focus on the Childwindow
	     driver.switchTo().window(childHandle);
	    //get the title of child Window
	     String cTitle=driver.getTitle();
	     System.out.println("Child Window Title is "+cTitle);
	     
	   //to take Screen shot
	     File source=driver.getScreenshotAs(OutputType.FILE);
	     File target= new File("./snaps/amazon.png");
	     FileUtils.copyFile(source, target);
	        //add to cart
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	     String cartTotal= driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']")).getText();
	     System.out.println("cart Subtotal:"+cartTotal);
	     
	     
	     driver.quit();

	}

}
