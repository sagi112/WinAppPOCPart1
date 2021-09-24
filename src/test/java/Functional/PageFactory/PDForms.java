package Functional.PageFactory;

import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PDForms {

    WindowsDriver windowsDriver;

    @FindBy(xpath = "//Pane[starts-with(@AutomationId,'linFinishedLength_')]//Edit[starts-with(@AutomationId,'TextBox')]")
    WebElement equalsButton;

    public PDForms(WindowsDriver windowsDriver) {
        this.windowsDriver = windowsDriver;
        PageFactory.initElements(windowsDriver, this);
    }

    public void clickEquals() {
        equalsButton.click();
    }


}
