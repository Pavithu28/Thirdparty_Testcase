package trainingWeek1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra_exe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		 
		ChromeDriver driver = new ChromeDriver();
		 
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement men=driver.findElement(By.xpath("//a[@data-group='men']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		String count=driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String countreplace=count.replaceAll("[^0-9]", "");
		int totalcount=Integer.parseInt(countreplace);
		System.out.println("Total count is"+totalcount);
		String countjac=driver.findElement(By.xpath("//input[@value='Jacket']/following::span")).getText();
		String countjacrep=countjac.replaceAll("[^0-9]", "");
		int totalcountjac=Integer.parseInt(countjacrep);
		System.out.println("Total count of Jacket is"+totalcountjac);
		
		
		

		
		
		
		
	}

}
