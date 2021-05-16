package com.example.selenium_demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GooglePageTest {

  MainPage mainPage = new MainPage();
  static WebDriver webDriver= null;

  @BeforeAll
  public static void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--no-sandbox");
    webDriver = new ChromeDriver(chromeOptions);

  }

  @BeforeEach
  public void setUp() {
    webDriver.get("https://www.google.com");
  }

  @Test
  public void isLoaded() {
    if (webDriver.getPageSource().contains("fortunato"))
      Assertions.assertTrue(true);
    else
      Assertions.fail("Non Trovato");
  }

/*
  @Test
  public void toolsMenu() {
    mainPage.toolsMenu.hover();

    $(".menu-main__popup-wrapper").shouldBe(visible);
  }

  @Test
  public void navigationToAllTools() {
    mainPage.seeAllToolsButton.click();

    $(".products-list").shouldBe(visible);

    assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
  }
*/
}
