package Functional;

import Functional.PageFactory.PDForms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Utilities.GenericFunctions;
import org.junit.jupiter.api.extension.ExtendWith;

import static Functional.TestEnvSetup.windowDriver;

@ExtendWith(TestEnvSetup.class)
public class XpathTests extends TestBase{

    private static PDForms pdForm;


//    @BeforeAll
//    public static void Setup() {
//        startProcess();
//        pdForm = new PDForms(windowDriver);
//    }

    @Test
    void ElementsTest() {
        windowDriver.findElementByAccessibilityId("").click();
        windowDriver.findElementByAccessibilityId("").click();
        windowDriver.findElementByAccessibilityId("").click();
        pdForm.clickEquals();

        String currentText = GenericFunctions.getCellValue(windowDriver, 1, 1);
        Assertions.assertTrue(currentText.contains("C4546"));

        // String cellValue = GenericFunctions.getCellValue(windowDriver, 2, 0);
    }
}
