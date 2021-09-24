package Functional;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import Utilities.GenericFunctions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static Functional.TestEnvSetup.windowDriver;

@ExtendWith(TestEnvSetup.class)
public class EspControls extends TestBase {

//    @BeforeAll
//    public static void setup() {
//
//        startProcess();
//    }
//
//    @AfterAll
//    public static void tearDown() {
//        stopProcess();
//    }

    @BeforeEach
    public void setup() {
        gotoHomepage();
    }

    @Test
    public void findProductDesign() throws Exception {
        String expectedJobNumber = "7000";
        String expectedManufacturingCode = "C,42K,S19,42K";
//       DesiredCapabilities capabilities = TestBase.LaunchESP();
//       String windowHandle = windowDriver.getWindowHandle();
//       WebDriverWait windowDriverWait = new WebDriverWait(windowDriver, 10);
        Set<String> windowHandles = windowDriver.getWindowHandles();

        //Click on Find PD and enter PD no: 59881101
        windowDriver.findElementByAccessibilityId("Find Product Design").click();
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElementByAccessibilityId("TextBox1").sendKeys("59881101");
        windowDriver.findElementByAccessibilityId("btnSearch").click();
        //Click on Manufacturing tab and enter Length, Width and Coverage from dropdown
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElementByName("Manufacture").click();
        windowDriver.findElement(By.xpath("//Pane[starts-with(@AutomationId,'linFinishedLength_')]//Edit[starts-with(@AutomationId,'TextBox')]")).sendKeys("20.00");
        windowDriver.findElement(By.xpath("//Pane[starts-with(@AutomationId,'linFinishedWidth_')]//Edit[starts-with(@AutomationId,'TextBox')]")).sendKeys("10.00");
        windowDriver.findElement(By.xpath("//Pane[starts-with(@AutomationId,'cboCoverage')]//Edit[starts-with(@AutomationId,'TextBox')]")).sendKeys("150%" + Keys.TAB);
        windowDriver.findElementByAccessibilityId("btnCancel").click();

        // Read cell value from fxgrid table and put assertion. Eg: Job Number, Manufacturing Code
        windowDriver.findElementByName("Grids").click();
        windowDriver.findElementByName("Orders").click();
        String actualJobNumber = GenericFunctions.getCellValue(windowDriver, 1, 1);
        Assertions.assertTrue(actualJobNumber.equals(expectedJobNumber));

        String actualManufacturingCode = GenericFunctions.getCellValue(windowDriver, 1, 2);
        Assertions.assertTrue(actualManufacturingCode.equals(expectedManufacturingCode));

    }

    @Test
    public void copyProductDesign() throws Exception{

        Set<String> windowHandles = windowDriver.getWindowHandles();

        windowDriver.findElementByAccessibilityId("Find Product Design").click();
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElementByAccessibilityId("TextBox1").sendKeys("59881101");
        windowDriver.findElementByAccessibilityId("btnSearch").click();

        //Right click and Copy PD, select radio button and tick checkbox
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        Thread.sleep(4000);
        windowDriver.findElementByAccessibilityId("btnActions").click();
        windowDriver.findElementByName("Copy Product Design").click();
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElementByAccessibilityId("radDoNoCopyRoute").click();
        windowDriver.findElementByAccessibilityId("chkCopyAllComponents").click();
        windowDriver.findElementByAccessibilityId("chkCopyUnitizing").click();
        windowDriver.findElementByAccessibilityId("chkCopyPurchaseCosts").click();
        windowDriver.findElementByAccessibilityId("chkCopyDieKnife").click();
        windowDriver.findElementByAccessibilityId("btnCancel").click();
    }

    @Test
    public void createOrder() throws Exception{

        Set<String> windowHandles = windowDriver.getWindowHandles();

        windowDriver.findElementByAccessibilityId("Find Product Design").click();
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElementByAccessibilityId("TextBox1").sendKeys("59881101");
        windowDriver.findElementByAccessibilityId("btnSearch").click();
        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        Thread.sleep(4000);

        windowDriver.findElementByName("Grids").click();
        windowDriver.findElementByName("Orders").click();
        // Right click and create order, enter few values and cancel after ignoring popups
        windowDriver.findElementByAccessibilityId("btnActions").click();
        windowDriver.findElementByName("Create order").click();
        Thread.sleep(15000);
        // Switch to "Create Box Order" window
        windowHandles = windowDriver.getWindowHandles();

        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElement(By.xpath("//Pane[starts-with(@AutomationId,'txtCustomerPOrefLine')]//Edit[starts-with(@AutomationId,'TextBox')]")).sendKeys("test" + Keys.TAB);
        windowDriver.findElementByName("Sheet ordering").sendKeys(Keys.ENTER);
        windowDriver.findElement(By.xpath("//Pane[starts-with(@AutomationId,'numOrderQuantity')]//Edit[starts-with(@AutomationId,'TextBox')]")).sendKeys("1000" + Keys.TAB);

        WebDriverWait windowDriverWait = new WebDriverWait(windowDriver,10);
        windowDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Save"))).click();
        windowDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Finish"))).click();
        windowDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OK"))).click();
        windowDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OK"))).click();


    }
}