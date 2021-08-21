package assignment4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Type Chennai in From textBox and ENTER
		WebElement src = driver.findElement(By.id("src"));
		src.sendKeys("Chennai");
		driver.findElement(By.xpath("//section[@id='search']/div/div[1]/div/ul/li[1]")).click();

		// Type Bengaluru in Destination textBox and ENTER
		WebElement dest = driver.findElement(By.id("dest"));
		dest.sendKeys("Bangalore");
		driver.findElement(By.xpath("//section[@id='search']/div/div[2]/div/ul/li[1]")).click();

		// Choose any date in JULY
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']//tr[6]/td[5]")).click();

		// Click Search Buses
		driver.findElement(By.id("search_btn")).click();

		// Close the popup using the X button at the right corner
		// Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='close']//i")).click();
		// Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='close-primo']/i")).click();

		// Print the number of search results
		WebElement si = driver.findElement(By.xpath("//div[@class='search']/div[2]/div[2]/div[2]/div/span[1]/span"));
		System.out.println("Number of results found are : " + si.getText());

		// Choose only Sleeper Bus
		driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]")).click();

		// Print the number of search results
		WebElement si1 = driver.findElement(By.xpath("//div[@class='search']/div[2]/div[2]/div[3]/div/span[1]/span"));
		System.out.println("Number of search result for Sleeper is : " + si1.getText());

		// Deselect the sleeper Bus and select the AC bus alone
		driver.findElement(By.xpath("//div[@id='filter-block']/div/div[2]/ul[3]/li[2]/label[1]")).click();
		driver.findElement(By.xpath("//input[@id='bt_AC']/../label")).click();

		// Print the number of search results
		WebElement si2 = driver
				.findElement(By.xpath("//div[@id='filter-block']/following-sibling::div/div[3]/div/span[1]/span"));
		System.out.println("Number of Search result for AC is : " + si2.getText());

		// Choose also Non AC buses
		WebElement si3 = driver.findElement(By.xpath("//input[@id='bt_NONAC']/../label[1]"));
		// Thread.sleep(40000);
		si3.click();

		// Print the number of search results
		WebElement si4 = driver
				.findElement(By.xpath("//div[@id='filter-block']/following-sibling::div/div[3]/div/span[1]/span"));
		System.out.println("Number search results for Ac and NON-AC is : " + si4.getText());

	}

}
