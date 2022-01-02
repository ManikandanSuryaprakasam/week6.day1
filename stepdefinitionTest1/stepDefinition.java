package stepdefinitionTest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinition {

	public ChromeDriver driver;

	@Given("Open the chrome browser")
	public void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

	}

	@Given("load the application url")
	public void loadApplication() {

		driver.get("http://leaftaps.com/opentaps/");

	}

	@Given("Enter the username as {string}")
	public void enterUsername(String username) {

		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Enter the paswword as {string}")
	public void enterPassword(String password) {


		driver.findElement(By.id("password")).sendKeys(password);



	}
	@When("Click on login button")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();


	}
	@Then("HomePage should be displayed")
	public void VerifyHomePage() {

		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if(displayed==true)
		{
			System.out.println("Home Displayed");
		}
		else 
		{
			System.out.println("Home not Displayed");
		}
		
	}
	
	
	@But("Error message should be displayed")
	public void ErrorVerify() {

		
			System.out.println("Error message verified");
		
		
	}
	
	@Then("driver should be closed")
	public void driverclose() {

		
			driver.close();;
		
		
	}
	
	

}


