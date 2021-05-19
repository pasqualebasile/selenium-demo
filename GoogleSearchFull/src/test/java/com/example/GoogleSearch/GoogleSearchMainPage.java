package com.example.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchMainPage {


  @FindBy(id = "L2AGLb")
  public WebElement privacyDisclaimer;

  @FindBy(name = "q")
  public WebElement queryInputBox;

  @FindBy(name = "btnK")
  public WebElement buttonSearch;

  public GoogleSearchMainPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

}
