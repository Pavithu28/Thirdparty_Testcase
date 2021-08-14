package trainingWeek1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bigbasket {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       WebElement mouseopr=driver.findElement(By.xpath("//a[@qa='categoryDD']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mouseopr).perform();
		
		WebElement mouseopr1=driver.findElement(By.linkText("Foodgrains, Oil & Masala"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(mouseopr1).perform();
		
		WebElement mouseopr2=driver.findElement(By.linkText("Rice & Rice Products"));
		Actions builder2=new Actions(driver);
		builder2.moveToElement(mouseopr2).perform();
		
		driver.findElement(By.linkText("Boiled & Steam Rice")).click();
		driver.findElement(By.xpath("//span[text()='BB Royal']")).click();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Ponni Boiled')]"))).click();
		WebElement ele = driver.findElement(By.xpath("//td[@data-qa='productPrice']"));
		String productprice = ele.getText();
		System.out.println("Price of the rice"+productprice);
		driver.findElement(By.xpath("//span[text()='ADD TO BASKET']")).click();
		Thread.sleep(3000);
		WebElement ele2 = driver.findElement(By.xpath("//div[text()='Successfully added Ponni Boiled Rice - Super Premium to the basket']"));
		String addtocard = ele2.getText();
		System.out.println(addtocard);
		driver.findElement(By.id("productSearch")).click();
		driver.findElement(By.id("productSearch")).sendKeys("Dal",Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'Toor/Arhar Dal')]")).click();
		driver.findElement(By.xpath("(//div[@class='_1DBJl'])[5]")).click();
		WebElement ele1 = driver.findElement(By.xpath("//td[@data-qa='productPrice']"));
		String productpricedal = ele1.getText();
		System.out.println("Price of the dal is"+productpricedal);
		driver.findElement(By.xpath("//span[text()='ADD TO BASKET']")).click();
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Successfully added Toor/Arhar Dal to the basket']"));
		String dal = ele3.getText();
		System.out.println(dal);
		
		WebElement mouseopr3=driver.findElement(By.xpath("//span[text()='My Basket']"));
		Actions builder3=new Actions(driver);
		builder3.moveToElement(mouseopr3).perform();
		WebElement ele4 = driver.findElement(By.xpath("//span[@qa='subTotalMB']"));
        String str=ele4.getText();
        int subtot=Integer.parseInt(str);
        System.out.println("The subtotal of 2 product is"+subtot);
        driver.findElement(By.xpath("//div[@class='item-remove']")).click();
        WebElement ele5 = driver.findElement(By.xpath("//span[@qa='subTotalMB']"));
        String str1=ele5.getText();
        int subtot1=Integer.parseInt(str1);
        System.out.println("The subtotal of 1 product is"+subtot1);
        //driver.close();
	}

}
