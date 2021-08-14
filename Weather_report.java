package trainingWeek1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Weather_report {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com/weather");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.id("ls-c-search__input-label"));
		ele.click();
		ele.sendKeys("Chennai",Keys.ENTER);
		driver.findElement(By.xpath("//ul[@id='location-list']//a")).click();
		driver.findElement(By.className("wr-time-slot-primary__weather-curve")).click();
		driver.findElement(By.xpath("//span[text()='21']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//dd[text()='1008 mb']"));
		String pressuretoday=ele1.getText();
		System.out.println(pressuretoday);
		pressuretoday.replace("mb"," ");
		System.out.println(pressuretoday);
		pressuretoday.trim();
		System.out.println(pressuretoday);
		
		
		
		
		
		
		//System.out.println("Today temperature is"+today_pressure);
		//driver.findElement(By.xpath("//a[@id='daylink-']/div[2]/div/span[2]"));
		
		
	}

	private static Object replace(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}
