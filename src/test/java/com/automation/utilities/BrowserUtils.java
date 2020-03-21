package com.automation.utilities;

import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static void wait (int miliSeconds){

        try {
            Thread.sleep( miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<String> getTextFromWebElements(List<WebElement> elements){

      List<String> textValues = new ArrayList<>();
      for (WebElement each : elements) {
          textValues.add(each.getText());
      }
      return textValues;
    }
}
