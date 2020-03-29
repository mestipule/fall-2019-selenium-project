package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    //we are writing a utility since if we are using it almost
    //constantly

    /*
        takes a list of web element
        return a list of string

    */

    public static List<String> getElementsText(List<WebElement> listE1) {
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listE1) {
            listSt.add(element.getText());
        }
        return listSt;
    }
}
