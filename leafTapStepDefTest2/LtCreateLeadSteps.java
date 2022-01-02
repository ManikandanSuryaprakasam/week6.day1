package leafTapStepDefTest2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LtCreateLeadSteps  {
	public ChromeDriver driver;
	public String leadID;
	
	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();


	}
	@Given("load the application url")
	public void load_the_application_url() {

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Given("Enter Login details and Click login")
	public void enter_login_details_and_click_login() {

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@Given("Click on the Leads link")
	public void click_on_the_leads_link() {

		driver.findElement(By.linkText("Leads")).click();
		
	}

	
	//Create Leads functionality 
	
	@Given("click on the Create Leads link")
	public void click_on_Create_Lead_Link() {
		driver.findElement(By.linkText("Create Lead")).click();
		
	}
		
	
	@Given("Enter Mandatory fields companyName,firstName,lastName,primaryPhoneCountryCode,primaryPhoneNumber")
	public void enter_mandatory_fields_company_name_first_name_last_name_primary_phone_country_code_primary_phone_number() {

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NewCompany");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Manikandan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9500077509");
	}
	
	@When("Click on submit button")
	public void click_on_submit_button() {

		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("View Lead page should be displayed")
	public void view_lead_page_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		String text = driver.getTitle();
		if(text.contains("View Lead"))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title Not matched");
		}
	}
	
	@Then("Company Name should be displayed")
	public void company_name_should_be_displayed() {

		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(text.contains("Manikandan"))
		{
			System.out.println("record Created successfully");
		}
		else
		{
			System.out.println("record not Created successfully");
		}
	}
	
	
	//Delete Lead
	@Given("Find leads by Phone number")
	 public void find_leads_by_phone_number() {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("95");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Click on Delete button")
	public void Click_on_Delete_button() {

		driver.findElement(By.linkText("Delete")).click();
	}

	@Then("View the deleted record")
	public void view_the_deleted_record() {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@Then("Search by deleted Lead No records to display message should be displayed")
	public void search_by_deleted_lead_no_records_to_display_message_should_be_displayed() {

		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
	
	
	@When("Click on Duplicate button")
	public void click_on_duplicate_button() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View the Duplicate record")
	public void view_the_duplicate_record() {
		
		System.out.println("Duplicate lead verified");
		
	}
	
		
	
	@Then("driver should be closed")
	public void driver_should_be_closed() {

		driver.close();
	}




}
