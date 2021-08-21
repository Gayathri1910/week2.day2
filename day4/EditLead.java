package assignment4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	
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
		
		driver.findElement(By.name("firstName")).sendKeys("catt");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		driver.findElementByXPath("//a[text()='catt']").click();
		
		String title1 = "View Lead | opentaps CRM";
		String homeTitle = driver.getTitle();
		
		if(title1.equalsIgnoreCase(homeTitle)) {
			System.out.println("View lead page loaded");
		}
		
		driver.findElementByLinkText("Edit").click();
		driver.findElementsById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("new name");
		driver.findElementByXPath("//input[@value='Update']").click();
		
		
		String newname = driver.findElementById("updateLeadForm_companyName").getText();
		System.out.println("Updated name is "  +newname);
		
		driver.close();
		}
	}


