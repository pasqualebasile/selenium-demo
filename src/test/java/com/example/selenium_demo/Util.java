package com.example.selenium_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Util {
  public static String getXpath(WebElement element){
    int n = element.findElements(By.xpath("./ancestor::*")).size();
    String path = "";
    WebElement current = element;
    for(int i = n; i > 0; i--){
      String tag = current.getTagName();
      int lvl = current.findElements(By.xpath("./preceding-sibling::" + tag)).size() + 1;
      path = String.format("/%s[%d]%s", tag, lvl, path);
      current = current.findElement(By.xpath("./parent::*"));
    }
    return "/" + current.getTagName() + path;
  }

  public static String getXpath(WebElement self, WebElement ancestor){
    int a = ancestor.findElements(By.xpath("./ancestor::*")).size();
    int s = self.findElements(By.xpath("./ancestor::*")).size();
    String path = "";
    WebElement current = self;
    for(int i = s - a; i > 0; i--){
      String tag = current.getTagName();
      int lvl = current.findElements(By.xpath("./preceding-sibling::" + tag)).size() + 1;
      path = String.format("/%s[%d]%s", tag, lvl, path);
      current = current.findElement(By.xpath("./parent::*"));
    }
    return path;
  }
}
