package com.example.GoogleSearch;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchStep {

  private static final String GOOGLEWEB = "https://www.google.com";
  private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
  private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";
  protected WebDriver driver;
  protected WebElement searchBox;

  @Given("Open the Google Search Engine")
  public void openTheGoogleSearchEngine() {
    driver.get(GOOGLEWEB);
  }

  @When("I search for {string}")
  public void iSearchFor(String string) {
    driver.findElement(By.id("L2AGLb")).click();            // Attenzione!!!
    driver.findElement(By.name("q")).sendKeys(string);
    driver.findElement(By.name("btnK")).submit();
  }

  @Then("I should see {string}")
  public void iShouldSee(String string) {
    Assertions.assertTrue(driver.getPageSource().contains(string));
  }

  @Before
  public void beforeScenario() {
    System.out.println("This will run before the Scenario");
    System.setProperty(WEBDRIVER_CHROME_NAME, WEBDRIVER_CHROME_PATH);

    final ChromeOptions chromeOptions = new ChromeOptions();
    // chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.setCapability("setJavascriptEnabled", "true");

    driver = new ChromeDriver(chromeOptions);
  }

  @After
  public void afterScenario() {
    System.out.println("After The Scenario");
    driver.quit();
  }

}
