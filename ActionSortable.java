package Week4.Day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSortable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);

			Actions builder=new Actions(driver);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		Point location = item6.getLocation();
		int x=location.getX();
		int y=location.getY();
		Thread.sleep(3000);
		//builder.dragAndDropBy(item1, x, y).perform();
		builder.clickAndHold(item1).moveByOffset(x, y).release().perform();
	}
}
