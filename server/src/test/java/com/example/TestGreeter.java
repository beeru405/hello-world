package com.example;

import org.junit.Before;
import org.junit.Test;

//import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
//import static org.junit.Assert.assertThat;
//import static org.junit.matchers.JUnitMatchers.containsString;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGreeter {

  private Greeter greeter;
  private WebDriver driver;

  @Before
  public void setup() {
    greeter = new Greeter();

    // Set the path to your ChromeDriver executable
    System.setProperty("webdriver.chrome.driver", "/home/devops/usr/bin/chromedriver");
    
    // Create a new instance of the Chrome driver
    driver = new ChromeDriver();
  }

  @Test
  public void greetShouldIncludeTheOneBeingGreeted() {
    String someone = "World";

    assertThat(greeter.greet(someone), containsString(someone));
  }

  @Test
  public void greetShouldIncludeGreetingPhrase() {
    String someone = "World";

    assertThat(greeter.greet(someone).length(), is(greaterThan(someone.length())));
  }

  @Test
  public void testRegistrationForm() {
    // Navigate to the website with the form
    driver.get("http://192.168.138.130:8090/webapp/");

    // Locate the form elements by their IDs
    WebElement nameInput = driver.findElement(By.id("Name"));
    WebElement mobileInput = driver.findElement(By.id("mobile"));
    WebElement emailInput = driver.findElement(By.id("email"));
    WebElement passwordInput = driver.findElement(By.id("psw"));
    WebElement repeatPasswordInput = driver.findElement(By.id("psw-repeat"));
    WebElement registerButton = driver.findElement(By.className("registerbtn"));

    // Fill in the form
    nameInput.sendKeys("Your Name");
    mobileInput.sendKeys("Your Mobile Number");
    emailInput.sendKeys("YourEmail@example.com");
    passwordInput.sendKeys("YourPassword");
    repeatPasswordInput.sendKeys("YourPassword");

    // Click the Register button
    registerButton.click();

    // Wait for the "Thankyou, Happy Learning" message to be visible
    WebElement thankYouMessage = driver.findElement(By.xpath("//h1[text()='Thankyou, Happy Learning']"));
    assertTrue("Registration was unsuccessful", thankYouMessage.isDisplayed());
  }

  // Add a teardown method to close the browser window
  // (You might want to use @After annotation if using JUnit 4)
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
