package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	@FindBy(xpath="//*[@name='username']")
	WebElement Username;

	@FindBy(xpath="//*[@name='password']")
	WebElement Password;
	@FindBy(css ="//button[@type='submit']")
	WebElement Loginbtn;
	
	/*WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
	WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
	WebElement Loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
	// driver.findElement(By.xpath("//*[@name='username']")).sendKeys("ARUN");
	// Will send values to First Name tab*/

	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickbtn() {
		Loginbtn.click();
	}
	public String verify() {
		return driver.getTitle();
	}
}

