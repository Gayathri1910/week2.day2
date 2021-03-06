package assignment4.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithButtons {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		driver.findElement(By.linkText("Button")).click();
		
		WebElement button1 = driver.findElement(By.xpath("//button[@id='position']"));
		System.out.println("Location of button is :"+button1.getLocation());	
		
		
		String color = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("color");
		System.out.println("Colour of the button is "+color);
		
		WebElement size = driver.findElement(By.xpath("//button[@id='size']"));
		System.out.println("Size of the button is "+size.getSize());

	}
}
