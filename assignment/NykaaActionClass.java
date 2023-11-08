package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NykaaActionClass {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//.Load the URL (https://www.nykaa.com/)

		driver.get("https://www.nykaa.com/");
		Thread.sleep(3000);
		
	//Mouseover on "Brands" and search for "L'Oreal Paris"
	WebElement brandsTag=driver.findElement(By.xpath("//a[normalize-space()='brands']"));
	//instantiate Actions class
	
	Actions builder=new Actions(driver);
	//use the actions object and call the require method//movetoelement is to reach the element perform method so important in all kind of mouse actions
	
	builder.moveToElement(brandsTag).perform();
	Thread.sleep(3000);
	WebElement lorialParis=driver.findElement(By.xpath("//li[5]//a[1]//img[1]"));
	lorialParis.click();
	System.out.println("current Tiltle:"+driver.getTitle());
	//. Click on "Sort By" and select "Customer Top Rated".
	driver.findElement(By.xpath("//span[@class='sort-name']")).click();
	Thread.sleep(3000);
	 //"Click Customer Top Rated"
driver.findElement(By.xpath("//span[normalize-space()='customer top rated']")).click();
//click catagory
      driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
         //hair
	driver.findElement(By.xpath("//span[normalize-space()='Hair']")).click();
	//haircare
	driver.findElement(By.xpath("//span[normalize-space()='Hair Care']")).click();
	//shampoo
	driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']//div[contains(@class,'control-indicator checkbox')]")).click();
	Thread.sleep(3000);
	//concern
	driver.findElement(By.xpath("//span[normalize-space()='Concern']")).click();
	//coclor production
	driver.findElement(By.xpath("//span[normalize-space()='Colour Protection']")).click();
	//Check if the filter is applied with "Shampoo"
	String filterStatus=driver.findElement(By.xpath("//span[normalize-space()='Filters Applied']")).getText();
	System.out.println("Filter Status"+filterStatus);
	String shampooitem=driver.findElement(By.xpath("//span[normalize-space()='Shampoo']")).getText();
	System.out.println("Filter Item"+shampooitem);
	//Click on "L'Oreal Paris Colour Protect Shampoo".
	driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Colour Protect Shampoo With UVA & UVB For Colour-Treated Hair\"]")).click();
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
    //Go to the new window and select the size as "180 ml".
    driver.findElement(By.xpath("//span[text()='180ml']")).click();
    
    
   String amountOfShampoo= driver.findElement(By.xpath("//div[@class='css-f5j3vf']//span[@class='css-1jczs19'][contains(text(),'₹209')]")).getText();
	System.out.println("MRP Price of Shampoo:"+amountOfShampoo);
	driver.findElement(By.xpath("//div[@class='css-vp18r8']//button[@type='button']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='css-aesrxy']//*[name()='svg']")).click();
	WebElement iframeEle=driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
	driver.switchTo().frame(iframeEle);
	String grandTotal=driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
	System.out.println("Grand total Amount:"+grandTotal);
	}}
	
	
	
	

     


