package stepdefinitions;

import org.openqa.selenium.WebDriver;
import driverUtilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RciAffiliatePage;

public class RciAffiliateSteps {
	
	private DriverManager driverManager;
	private WebDriver driver;
	private RciAffiliatePage rciAffiliatePage;

	    public RciAffiliateSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
		this.driver = driverManager.getDriver();
		rciAffiliatePage = new RciAffiliatePage(driver);
	  }
	
	
	    @Given("user is on sign in page")
	    public void user_is_on_sign_in_page() {
	    	System.out.println("user is on sign in page");
	    }
	    
	    @When("user clicks on RCI Affiliate link")
        public void user_clicks_on_RCI_Affiliate_link() {
	    	rciAffiliatePage.clickOnLink();
 }
	    @Then("user should be navigated to affiliate page")
	    public void user_should_be_navigated_to_affiliate_page() {
	    	rciAffiliatePage.validateNavigation();
	    }

	    
	    
	
}
