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

public class SnapDealAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Load the URL (https://www.snapdeal.com/)
		driver.get("https://www.snapdeal.com/");
        //2. Go to "Men's Fashion"
        WebElement MensFashion=driver.findElement(By.xpath("(//span[normalize-space()=\"Men's Fashion\"])[1]"));
        Actions builder=new Actions(driver);
        builder.moveToElement(MensFashion).perform();
        //Go to "Sports Shoes".
        driver.findElement(By.xpath("(//span[contains(@class,'linkTest')][normalize-space()='Sports Shoes'])[1]")).click();
       //Get the count of sports shoes
        String Shoeitems= driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
        System.out.println("Total Count Of the Sports Shoe :"+Shoeitems);
        //Click on "Training Shoes"
        driver.findElement(By.xpath("//div[normalize-space()='Training Shoes']")).click();
        //Sort
        driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
        //. Sort the products by "Low to High".

       driver.findElement(By.xpath("//li[normalize-space()='Price Low To High']")).click();
      // Check if the displayed items are sorted correctly
       //Select any price range ex:(500-700).
       //500
       
       driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
       driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");
       //700
       driver.findElement(By.xpath("//input[@name='toVal']")).clear();
       driver.findElement(By.xpath(" //input[@name='toVal']")).sendKeys("700");
       //go
       driver.findElement(By.cssSelector(".price-go-arrow.btn.btn-line.btn-theme-secondary")).click();
       //Filter by any colour
      // driver.findElement(By.xpath("//div[@data-filtername='Color_s']//div[@class='filter-type-name lfloat']")).click();
       //black color
       Thread.sleep(3000);
       driver.findElement(By.xpath("//label[@for='Color_s-Black']")).click();
      Boolean checkBox= driver.findElement(By.xpath("//label[@for='Color_s-Black']")).isSelected();
       System.out.println("Black color filter checkbox is selected or not: ="+checkBox);
       
       //Mouse hover on the first resulting "Training Shoes"
       Thread.sleep(3000);
    driver.findElement(By.xpath("//img[@title='ASIAN Black Training Shoes']")).click();
    
     
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
    File target= new File("./snaps/snapdeal.png");
    FileUtils.copyFile(source, target);
    
    //gettext of amount and discound after toook a screen shot
   WebElement amountAndDiscount= driver.findElement(By.xpath("//div[@class='pdp-e-i-PAY-r disp-table-cell lfloat']"));   
   String amount=amountAndDiscount.getText();
   System.out.println(amount);
   
        
	}

}
