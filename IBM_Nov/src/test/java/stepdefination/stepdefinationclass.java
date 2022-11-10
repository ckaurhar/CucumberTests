package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import junit.framework.Assert;

public class stepdefinationclass {
	
	WebDriver driver = hooksclass.driver;
	String firstname = "testP72123";
	String lastname = "Ptest72123";
	String username = "TestP72123";
	String email = "Ptest12@testp.com";
	String password = "12345testp";	
	
	
	@Given("User navigates to elearning application")
	public void user_navigates_to_elearning_application() {
		System.out.println("user is navigating to the facebook application");
		   
		driver.get("http://elearningm1.upskills.in/index.php/");
	}

	@When("user enters clicks on sign up button")
	public void user_enters_clicks_on_sign_up_button() {
	    driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
	    
	    
	}

	@When("fill the user details")
	public void fill_the_user_details() {
	    driver.findElement(By.name("firstname")).sendKeys(firstname);
	    driver.findElement(By.name("lastname")).sendKeys(lastname);
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("email")).sendKeys(email);
	    driver.findElement(By.name("pass1")).sendKeys(password);
	    driver.findElement(By.name("pass2")).sendKeys(password);
	    
	}

	@When("click the register button")
	public void click_the_register_button() {
		driver.findElement(By.name("submit")).click();
	}
	
	@Then("user is signed up successfully")
	public void user_signed_in_successfully() {
	   String user = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
	   Assert.assertTrue("User account is not created", user.contains(firstname + " " + lastname));
			   
	}
	
	@Then("user is able to log out")
	public void user_is_able_to_log_out() {
		driver.findElement(By.id("logout_button")).click();
	}

	@Then("user is able to login with created user account")
	public void user_is_able_to_login_with_created_user_account() {
	    driver.findElement(By.name("login")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.name("submitAuth")).click();
	    String user = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
		   Assert.assertTrue("User account is not logged in.", user.contains(firstname + " " + lastname));
	}

	@Then("user is able to send the email")
	public void user_is_able_to_send_the_email() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@title='Inbox']")).click();
	  driver.findElement(By.xpath("//img[@title='Compose message']")).click();
	  driver.findElement(By.className("select2-search__field")).sendKeys("Test");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//li[text()='Test User1']")).click();
	  driver.findElement(By.name("title")).sendKeys("test message");
	  driver.findElement(By.xpath("//button[@name='compose']")).click();
	  String message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	  Assert.assertTrue("Message is not sent",message.contains("The message has been sent"));
	}



	

}
