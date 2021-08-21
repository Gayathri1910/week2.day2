package assignment4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Select the languages that you know?
		driver.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).click();
		
		//Confirm Selenium is checked
		WebElement confirm = driver.findElement(By.xpath("(//div[@class='example'])[2]//input"));
		boolean check = confirm.isSelected();
		System.out.println(" The value is Checked" + check);
	
		
		//DeSelect only checked
		
		
		driver.findElement(By.xpath("((//div[@class='example'])[3]//input)[2]")).click();
		
		
		
		//Select all below checkboxes
		driver.findElement(By.xpath("((//div[@class='example'])[4]//input)[1]")).click();
		driver.findElement(By.xpath("((//div[@class='example'])[4]//input)[2]")).click();
		driver.findElement(By.xpath("((//div[@class='example'])[4]//input)[3]")).click();
		driver.findElement(By.xpath("((//div[@class='example'])[4]//input)[4]")).click();
		driver.findElement(By.xpath("((//div[@class='example'])[4]//input)[5]")).click();
	}

}
