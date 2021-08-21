package assignment4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEditActivity {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys("ggayathri091@gmail.com");
		WebElement appendtextbox = driver.findElementByXPath("//input[@value='Append ']");
		appendtextbox.sendKeys("new text");
		appendtextbox.sendKeys(Keys.TAB);

		String defaulttext = driver.findElementByName("username").getText();
		System.out.println("The text oresent is " + defaulttext);

		driver.findElementByXPath("//input[@value='Clear me!!']").clear();

		Boolean textboxdisabled = driver.findElementByXPath("//input[@disabled='true']").isEnabled();
		System.out.println("True or False= " + textboxdisabled);

	}

}
