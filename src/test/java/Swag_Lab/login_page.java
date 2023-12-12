package Swag_Lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_componant.abstract_componant;

public class login_page extends abstract_componant {
	WebDriver driver;
	public login_page(WebDriver driver)
	{ super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement Username = driver.findElement(By.id("user-name"));
		//Using page factory
	
		@FindBy(id="user-name")
		WebElement username;
	
	//driver.findElement(By.id("password")).sendKeys("secret_sauce");
	
		@FindBy(id="password")
		WebElement pass;
	
		//driver.findElement(By.id("login-button")).click();
	
		@FindBy(id="login-button")
		WebElement submit;
	public void goToUrl() {
		
		driver.get("https://www.saucedemo.com/");
	}
		
		
	public void action_method(String email, String password) {
		username.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
	}
	
	
	
	
	
	
	
	
}
