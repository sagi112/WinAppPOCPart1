package Functional;
//import org.openqa.selenium.remote;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static Functional.TestEnvSetup.windowDriver;

public class TestBase {
/*
    protected static WindowsDriver windowDriver;
    protected static ProcessBuilder builder;
    protected static Process process;

    private static boolean winAppDriverStarted = false;
    private static boolean appStarted = false;

    protected static DesiredCapabilities LaunchESP() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Kiwiplan\\EspServ\\KiwiXplor.exe");
        capabilities.setCapability("appWorkingDir", "C:\\Kiwiplan\\EspServ");
        capabilities.setCapability("ms:waitForAppLaunch", "15");


        windowDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);

        WebDriverWait windowDriverWait = new WebDriverWait(windowDriver, 10);
        windowDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return capabilities;


    }

    public static void startProcess() {
        builder = new ProcessBuilder("C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe").inheritIO();;
        try {
            if(!winAppDriverStarted)
            {
                process = builder.start();
                winAppDriverStarted = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Kiwiplan\\EspServ\\KiwiXplor.exe");
        capabilities.setCapability("appWorkingDir", "C:\\Kiwiplan\\EspServ");
        capabilities.setCapability("ms:waitForAppLaunch", "15");



        try {
            if(!appStarted)
            {
                windowDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
                appStarted = true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        windowDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void stopProcess() {
        windowDriver.quit();
        process.destroy();
        // Add logic to go to home page
        // windowDriver.findElementByAccessibilityId("//ToolBar[@AutomationId='tbToolBar']/Button[position()=8]").click();
    }
*/

    public static void gotoHomepage() {
        Set<String> windowHandles = windowDriver.getWindowHandles();

        windowDriver.switchTo().window(windowHandles.toArray()[0].toString());
        windowDriver.findElementByXPath("//ToolBar[@AutomationId='tbToolBar']/Button[position()=4]").click();
    }

}



