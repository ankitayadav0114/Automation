package stepdefinitions;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import driverUtilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
    private DriverManager driverManager;
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.driver = driverManager.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    
       
    @Given("user is on login page")
    public void user_is_on_login_page() {
    	loginPage.validateLoginPage();
    }
    
    @When("user hover to signin button")
    public void user_hover_to_signin_button() {    	
    	loginPage.hoverToSignInButton();
    }
    
    @And("user enters username")
    public void user_enters_username() {
        loginPage.enterUsername();
       
    }
    
    @And("user enters password")
    public void user_enters_password () {
    	loginPage.enterPassword();
    }
    

    @And("user clicks on login")
    public void user_Clicks_Login() {
        loginPage.clickLogin();
    }
    
    @Then("user is redirected to dashbord")
    public void user_is_redirected_to_dashbord() {
    	loginPage.validateUserIsOnDashboard();
    }
    
    
   
    
}
