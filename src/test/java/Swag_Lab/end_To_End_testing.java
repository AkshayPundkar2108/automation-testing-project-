package Swag_Lab;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class end_To_End_testing {
	public static WebDriver driver;
	public WebElement element;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void t1url() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.getTitle();

	}

	@Test
	public void t2loginPage() {
		element = driver.findElement(By.id("user-name"));
		element.sendKeys("standard_user");
		element = driver.findElement(By.id("password"));
		element.sendKeys("secret_sauce");
		element = driver.findElement(By.id("login-button"));
		element.click();
	}

	@Test
	public void t3addAllItemInToCart() {
		List<WebElement> prod = driver.findElements(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory ']"));
		for (WebElement prodlist : prod) {
			prodlist.click();
		}
	}

	@Test
	public void t4opentheaddeditem() {
		element = driver.findElement(By.id("shopping_cart_container"));
		element.click();
	}

	@Test
	public void t5takeScreenShotAtaddedToCartPage() {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile,
					new File("C:/Users/admin/eclipse-workspace1(mobie_testing )/SWAG_LAB/ScreenShot/1.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}

	@Test
	public void t6chechout() {
		element = driver.findElement(By.id("checkout"));
		element.click();
	}
	
	@Test
	public void t7personalDataAdd() {
//		Actions actions = new Actions(driver);
//		Action noOfAction=actions.moveToElement
//		(driver.findElement(By.id("first-name"))).click()
//		.sendKeys("akshay", Keys.TAB).sendKeys("pundkar", Keys.TAB)
//		.sendKeys("411006", Keys.ENTER).build();
//
		driver.findElement(By.xpath("//input[@data-test='firstName']")).sendKeys("akshay");
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("pundkar");
		driver.findElement(By.xpath("//input[@data-test='postalCode']")).sendKeys("411006");
		driver.findElement(By.id("continue")).click();
		}
	
	@Test
	public void t8completeTheProcess() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='finish']")));
		driver.findElement(By.xpath("//button[@data-test='finish']")).click();
		
	}
	
	
		@AfterTest
	public void teardown() {
		driver.quit();
	}

}
