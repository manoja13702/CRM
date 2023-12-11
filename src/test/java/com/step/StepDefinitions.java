package com.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	WebDriver driver;
	@Given("User must be in a login page and use the demo username & demo password to login")
	public void user_must_be_in_a_login_page_and_use_the_demo_username_demo_password_to_login() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://demo.1crmcloud.com/login.php");
	    driver.manage().window().maximize();
	    // Use Demo Username ="admin" & demo Password ="admin"
	    driver.findElement(By.xpath("//input[@id=\"login_user\"]")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@id=\"login_pass\"]")).sendKeys("admin");
	    driver.findElement(By.xpath("//span[@class=\"uii uii-arrow-right\"]")).click();
	}

	@When("Click on Sales and Marketting and also Click Create contact")
	public void click_on_Sales_and_Marketting_and_also_Click_Create_contact() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//div[@class=\"menu-tab-label\"])[2]")).click();
	    driver.findElement(By.xpath("(//a[@class=\"sidebar-item-link-basic\"])[1]")).click();
	}
	
	@When("Needs to enter our deatils like Firstname, Lastname, address etc,.")
	public void needs_to_enter_our_deatils_like_Firstname_Lastname_address_etc() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//div[@class=\"input-label single text-placeholder\"])[1]")).click();
		driver.findElement(By.xpath("//div[text()='Mr.']")).click();
		driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("Raj");
		driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id=\"DetailFormemail1-input\"]")).sendKeys("rajk@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"DetailFormphone_work-input\"]")).sendKeys("9876543210");
		driver.findElement(By.xpath("(//div[@title='(none)'])[2]")).click();
		driver.findElement(By.xpath("//div[text()='Public Relations']")).click();
		driver.findElement(By.xpath("(//div[@title='(none)'])[2]")).click();
		driver.findElement(By.xpath("//div[text()='Sales']")).click();
		driver.findElement(By.xpath("//textarea[@id='DetailFormprimary_address_street-input']")).sendKeys("Plot No 55, Sakthi nagar 7th Street, Thoraipakkam");
		driver.findElement(By.xpath("//input[@name='primary_address_city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@name='primary_address_state']")).sendKeys("Tamilnadu");
		driver.findElement(By.xpath("//input[@name='primary_address_country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@name='primary_address_postalcode']")).sendKeys("600096");
		driver.findElement(By.xpath("//span[@id='DetailForm_save2-label']")).click();
	}

	@When("If the Contact already exists create new contact")
	public void if_the_Contact_already_exists_create_new_contact() throws InterruptedException {
		// Duplicate contact if its already existing else create as new contact
		Thread.sleep(4000);
		if ((driver.findElement(By.xpath("(//div[@class='input-icon left icon-accept'])[2]")).isDisplayed() == true)) {
		    driver.findElement(By.xpath("(//div[@class='input-icon left icon-accept'])[4]")).click();
		System.out.println("Duplicate existing contact");
		Thread.sleep(3000);
		
		} else {
		System.out.println("new Contact created");
		Thread.sleep(3000);
				}
	}
	
	@When("Click Schedule meeting in Activities")
	public void click_Schedule_meeting_in_Activities() throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("(//div[@class='inline-elt'])[23]")).click();
	    Thread.sleep(3000);
	    
	}

	@When("Schedule the day and timing for the meeting")
	public void schedule_the_day_and_timing_for_the_meeting() {
		driver.findElement(By.xpath("//div[@class=\"input-label datetime-label text-number\"]")).click();
	    driver.findElement(By.xpath("//div[text()=\"18\"]")).click();
	    driver.findElement(By.xpath("(//input[@class=\"input-text\"])[16]")).sendKeys("10.00");
	    driver.findElement(By.xpath("//div[@class=\"active-icon uii-accept uii-lg uii\"]")).click();
	    driver.findElement(By.xpath("//input[@name=\"is_private\"][2]")).click();
	    driver.findElement(By.xpath("//button[@id=\"QuickCreateForm_0_save\"]")).click();
	}

	@When("After that click contacts in Sales and Marketing")
	public void after_that_click_contacts_in_Sales_and_Marketing() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("(//div[@class=\"sidebar-item\"])[2]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@class='input-text input-entry ']")).sendKeys("Raj Kumar");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[text()='Mr. Raj Kumar']")).click();
	}

	@Then("Verify that the Meeting is assigned to the contact under Activities Section")
	public void verify_that_the_Meeting_is_assigned_to_the_contact_under_Activities_Section() throws InterruptedException {
        Thread.sleep(3000);
		String name = driver.findElement(By.xpath("//div[@id='_form_header']/h3")).getText();
		System.out.println("Contact name is:" + name);
		if (name.contains("Mr. Raj Kumar")) {
			System.out.println("Meeting was assigned");
		} else {
			System.out.println("Meeting not assigned");
		}
	}
}
