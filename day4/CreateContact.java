package assignment4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		
		driver.findElement(By.id("firstNameField")).sendKeys("Rachel");
		driver.findElement(By.id("lastNameField")).sendKeys("Green");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("localfirst");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("locallast");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Sales");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Trying to enter decription in contact-create contact field");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ggayathri091@gmail.com");
		
		
		WebElement stateprovince = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateprovincedropdown = new Select(stateprovince);
		stateprovincedropdown.selectByVisibleText("New York");
		
		
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Note text field,giving text of my choice");
		driver.findElement(By.className("smallSubmit")).click();
		
		
		String viewupdatetitle = driver.getTitle();
		System.out.println("The title of the page is " +viewupdatetitle);
		
		
	}

}
