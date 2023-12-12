package abstract_componant;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstract_componant {
		
	public WebDriver driver;
	
	public abstract_componant(WebDriver driver) {  	//  creating constructer of the child class
		 this.driver= driver;
	}
	
	public void waitForElementtoAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

}
