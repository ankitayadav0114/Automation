package stepdefinitions;

import org.openqa.selenium.WebDriver;

import driverUtilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HotelNavigationPage;

public class HotelNavigationSteps {

	private DriverManager driverManager;
	private WebDriver driver;
	private HotelNavigationPage hotelNavigationPage;
	
	
	
	public HotelNavigationSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
		this.driver = driverManager.getDriver();
		this.hotelNavigationPage = new HotelNavigationPage(driver);
	}
	
	
	@Given("user is on dashboard page")
	public void user_is_on_dashboard_page () {
		System.out.println("user is on dashboard");
	}
	
	@When("user click on book tab")
	public void user_click_on_book_tab() {
		hotelNavigationPage.clickOnBookTab();	
	}
	
	@And("user clicks on hotels")
	public void user_clicks_on_hotels() {
		hotelNavigationPage.clickOnHotel();
	}
	
	@Then("user is redirected to search hotel page")
	public void user_is_redirected_to_search_hotel_page() {
		hotelNavigationPage.validateHotelPage();
	}
	
}
