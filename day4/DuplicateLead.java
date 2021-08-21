package assignment4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title=driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("sachinsreyung10@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		WebElement fname = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a");
		String text1 = fname.getText();
		System.out.println("Name of the 1st result is "+text1);
		fname.click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String duplicatelead = driver.getTitle();
		System.out.println("The title is " +duplicatelead);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String text2 = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		driver.findElementByClassName("smallSubmit").click();
		if (duplicatelead.equals(text2)) {
			System.out.println("The lead is duplicate");
		}
		driver.close();
	}

}
