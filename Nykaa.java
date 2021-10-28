package Week4.Day2.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	// Mousehover
	WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	Actions builder=new Actions(driver);
	builder.moveToElement(brands).perform();
	driver.findElement(By.xpath("(//div[@class='ss-wrapper']//a)[6]")).click();
	String title=driver.getTitle();
	if(title.contains("L'Oreal Paris")){
		System.out.println("Title is verified");
	}
	else {
		System.out.println("Title is not verified");
	}
	driver.findElement(By.xpath("//div[@id='filter-sort']//button")).click();
	driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@id='first-filter']/div")).click();
	driver.findElement(By.xpath("(//span[@class='filter-name ']/parent::div)[1]")).click();
	driver.findElement(By.xpath("(//span[@class='filter-name ']/parent::div)[1]")).click();
	driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
	driver.findElement(By.xpath("(//span[@class='title ']/parent::div)[5]")).click();
	driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[13]")).click();
	String text = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
	if(text.contains("Shampoo")) {
		System.out.println("Shampoo filter is applied");
	}
	else {
		System.out.println("Shampoo filter is not applied");
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@id='product-list-warp']//a)[1]")).click();
	Set<String> window1 = driver.getWindowHandles();
	List<String>setHandles=new ArrayList<String>(window1);
	driver.switchTo().window(setHandles.get(1));
	WebElement dropDown = driver.findElement(By.xpath("//select[@title='SIZE']"));
	Select dropDown1=new Select(dropDown);
	dropDown1.selectByIndex(1);
	String text2 = driver.findElement(By.xpath("//span[text()='MRP:']/following::span[1]")).getText();
	System.out.println("The MRP is:"+text2);
	driver.findElement(By.xpath("(//button[@type='button']/span)[4]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@id='header_id']//button)[3]")).click();
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	String text3 = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
	driver.findElement(By.xpath("(//button[@class='btn full fill no-radius proceed '])")).click();
	driver.findElement(By.xpath("//button[@class='btn full big']")).click();
	String text4 = driver.findElement(By.xpath("//span[text()='220']")).getText();
	if(text3.contains(text4)) {
		System.out.println("The Grand total is same");
	}
	else {
		System.out.println("The Grand total is different");
		driver.quit();
	}
	
	
}
}
