package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.ConfigReader;
import driverUtilities.BaseUtilities;

public class LoginPage {
    private  WebDriver driver;
    private BaseUtilities utils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new BaseUtilities(driver);
    }

    private By signInButton = By.xpath("//button[@class='btn prelogin-signin-btn aem-btn-primary btn-primary']");
    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginBtn = By.id("rciSignInBtn");
    private By cookiesPopUp = By.xpath("//div[@id='onetrust-banner-sdk']");
    private By myAccountBtn = By.xpath("//button[@aria-label='Profile icon']");
    private By closeBtn = By.xpath("//button[@aria-label='Close']");

    
    
   
    public void validateLoginPage() {
    	Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.get("expectedURL"));
    }
    
    public void hoverToSignInButton() {
    	 WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5)); 	    
    	wt.until(ExpectedConditions.visibilityOfElementLocated(cookiesPopUp));
		driver.findElement(closeBtn).click();
		
    	Actions act = new Actions(driver);
    	act.moveToElement(driver.findElement(signInButton)).build().perform();  	
    }
    
    public void enterUsername() {	
    		driver.findElement(usernameField).sendKeys(ConfigReader.get("username"));             	    	  
    }

    public void enterPassword() {
    	driver.findElement(passwordField).sendKeys(ConfigReader.get("password"));      
    }

    public void clickLogin() {   	
    	driver.findElement(loginBtn).click();       	   	
    }
    
    public void validateUserIsOnDashboard() {
    	 WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(20)); 	
    	wt.until(ExpectedConditions.visibilityOfElementLocated(myAccountBtn));
    	Assert.assertTrue(driver.findElement(myAccountBtn).isDisplayed());
    }
    // making changes to check 
    
}
