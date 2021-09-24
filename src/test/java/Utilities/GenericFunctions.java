package Utilities;

import io.appium.java_client.windows.WindowsDriver;

public class GenericFunctions {

//    public static String getCurrentResults(WindowsDriver windowsDriver) {
//        String currentResults = windowsDriver.findElementByAccessibilityId("GridResults").getText();
//        return currentResults;
//}
    public static String getCellValue(WindowsDriver windowsDriver, int rowNumber, int colNumber) {
        String dynamicXPath = "//Pane[@AutomationId='fxgrid']//DataItem[@Name='Row " + rowNumber + " Column " + colNumber + "']";
        String cellValue = windowsDriver.findElementByXPath(dynamicXPath).getText();
        return cellValue;
    }


}
