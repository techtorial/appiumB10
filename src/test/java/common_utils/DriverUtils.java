package common_utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverUtils {


    public static AndroidDriver<AndroidElement> getAndroidDriver() {

        File apkFile = new File("src/test/resources/apks/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        URL serverUrl;
        try {
            serverUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;


    }


}
