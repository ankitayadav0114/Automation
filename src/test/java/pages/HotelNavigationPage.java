package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverUtilities.BaseUtilities;

public class HotelNavigationPage {

	private  WebDriver driver;
  //  private BaseUtilities utils;

    public HotelNavigationPage(WebDriver driver) {
        this.driver = driver;
       // this.utils = new BaseUtilities(driver);
    }

    private static By BookTab = By.xpath("//button[@aria-label='Book']");
    private static By hotels = By.xpath("//div[@aria-label='SEARCH']/div[2]/a");
    private static By hotelsPage = By.xpath("//div[@id='nav']/ul/li[1]");
    

    
    public  void clickOnBookTab() {
    driver.findElement(BookTab).click();
    }
    
    public  void clickOnHotel() {
    WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));
    wt.until(ExpectedConditions.visibilityOfElementLocated(hotels));
    driver.findElement(hotels).click();
    }
    
    public  void validateHotelPage() {
    	Assert.assertTrue(driver.findElement(hotelsPage).isDisplayed());
    }

	
	
	
}
