package Swag_Lab;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class end_to_end_by_simple2 {
	public static void main (String[]args) {
	
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.getTitle();
			login_page loginpage =new login_page(driver);
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			List<WebElement> prod = driver.findElements(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory ']"));
			for (WebElement prodlist : prod) {
				prodlist.click();}
			driver.findElement(By.id("shopping_cart_container")).click();
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotFile,
						new File("C:/Users/admin/eclipse-workspace1(mobie_testing )/SWAG_LAB/ScreenShot/1.bmp"));
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			driver.findElement(By.id("checkout")).click();
		
	
//			Actions actions = new Actions(driver);
//			Action noOfAction=actions.moveToWebElement
//			(driver.findElement(By.id("first-name"))).click()
//			.sendKeys("akshay", Keys.TAB).sendKeys("pundkar", Keys.TAB)
//			.sendKeys("411006", Keys.ENTER).build();
	//
			driver.findElement(By.xpath("//input[@data-test='firstName']")).sendKeys("akshay");
			driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("pundkar");
			driver.findElement(By.xpath("//input[@data-test='postalCode']")).sendKeys("411006");
			driver.findElement(By.id("continue")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='finish']")));
			driver.findElement(By.xpath("//button[@data-test='finish']")).click();
			driver.quit();
		

	}
}
