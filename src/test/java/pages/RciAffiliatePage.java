package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RciAffiliatePage {

	private WebDriver driver;
	
	public RciAffiliatePage(WebDriver driver) {
		this.driver = driver;
	}

	
	
	private By affiliateLink = By.xpath("//div[@class=\"footer-list-group\"][5]/ul/li[6]");
	private By closeBtn = By.xpath("//button[@aria-label='Close']");
	private By cookiesPopUp = By.xpath("//div[@id='onetrust-banner-sdk']");
	
	public void clickOnLink() {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5)); 	    
	    	wt.until(ExpectedConditions.visibilityOfElementLocated(cookiesPopUp));
			driver.findElement(closeBtn).click();
		
		
		
		//wt.until(ExpectedConditions.presenceOfElementLocated(affiliateLink));
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true);",driver.findElement(affiliateLink));
		driver.findElement(affiliateLink).click();
	}
	
	public void validateNavigation() {
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10));
		wt.until(ExpectedConditions.numberOfWindowsToBe(2));
		String mainWindow = driver.getWindowHandle();
		Set <String> windowHandles = driver.getWindowHandles();
		ArrayList<String> windowId = new ArrayList<>(windowHandles);
		String last = windowId.get(windowHandles.size()-1);
		driver.switchTo().window(last);
		
		
		
		/*
		 * Iterator<String> it = windowHandles.iterator(); while(it.hasNext()) { String
		 * handle =it.next(); if(!mainWindow.equals(handle)){
		 * driver.switchTo().window(handle); } }
		 */
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.rciaffiliates.com/");
	
	}
	
	
}
