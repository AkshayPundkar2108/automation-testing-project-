package Swag_Lab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_componant.abstract_componant;

public class add_to_Cart extends abstract_componant {
	
	WebDriver driver;
	public  add_to_Cart(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	//List<WebElement> prod = driver.findElements(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory ']"));
		
		@FindBy(xpath="//*[@class='btn btn_primary btn_small btn_inventory ']")
		List<WebElement> product;
		By productby =By.xpath("//*[@class='btn btn_primary btn_small btn_inventory ']");
			
		public List<WebElement> getProductList () {
				waitForElementtoAppear(productby); 	
				return product;
				
			}







}
