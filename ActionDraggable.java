package Week4.Day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDraggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame1);

		WebElement drag = driver.findElement(By.id("draggable"));
		Actions builder=new Actions(driver);
		Thread.sleep(3000);
		builder.dragAndDropBy(drag, 150, 150).perform();
		
		
		

	}

}
