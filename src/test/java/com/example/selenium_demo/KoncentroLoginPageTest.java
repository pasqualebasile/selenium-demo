package com.example.selenium_demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class KoncentroLoginPageTest {

  MainPage mainPage = new MainPage();
  static WebDriver webDriver= null;

  @BeforeAll
  public static void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    ChromeOptions chromeOptions = new ChromeOptions();
    // chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--no-sandbox");
    webDriver = new ChromeDriver(chromeOptions);

  }

  @AfterAll
  public static void cleanUpAll() {
    webDriver.close();
  }

  @BeforeEach
  public void setUp() {
    // webDriver.get("http://koncentro.service.konvergence.it:8080/");
    webDriver.get("http://10.99.88.21:9090/");
  }

  @Test
  void isLoaded() {
    Assertions.assertTrue(webDriver.getPageSource().contains("The Retail"));
  }

  @Test
  void Login() {
    webDriver.findElement(By.name("userField")).sendKeys("XXXX");
    webDriver.findElement(By.name("passwordField")).sendKeys("XXXX!");
    WebElement xButton = webDriver.findElement(By.xpath("//button[contains(.,'Login')]"));
    WebElement button = webDriver.findElement(By.tagName("button"));
    xButton.click();    // Wait
    WebDriverWait wait = new WebDriverWait(webDriver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("companyDropDown")));
    String pageSource = webDriver.getPageSource();
    System.out.println(pageSource);
    Assertions.assertTrue(pageSource.contains("Select a company"));
  }

}
