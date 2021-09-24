package Functional;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestEnvSetup implements BeforeAllCallback, AfterAllCallback, ExtensionContext.Store.CloseableResource {
    public static WindowsDriver windowDriver;
    public static ProcessBuilder builder;
    public static Process process;

    private static boolean winAppDriverStarted = false;
    private static boolean appStarted = false;


    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

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

        System.out.println("Both processes started successfully!!");


    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {

        windowDriver.quit();
        process.destroy();

        System.out.println("Both processes destroyed successfully!!");

    }

    @Override
    public void close() throws Throwable {
    }
}