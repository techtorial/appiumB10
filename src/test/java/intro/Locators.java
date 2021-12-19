package intro;

import common_utils.DriverUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static common_utils.DriverUtils.getAndroidDriver;


public class Locators {

    @Test
    public void accessibilityIdTest() {

        File apkFile = new File("src/test/resources/apks/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "techtorial");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        URL serverUrl;

        try {
            serverUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        AndroidElement appButton = driver.findElementByAccessibilityId("App");

        appButton.click();

        AndroidElement alarmButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']"));
        alarmButton.click();

        AndroidElement alarmControlerButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm Controller']"));
        alarmControlerButton.click();

        AndroidElement oneShotButton = driver.findElement(By.id("io.appium.android.apis:id/one_shot"));
        oneShotButton.click();

        String oneShotButtonText = oneShotButton.getText();
        Assert.assertEquals("ONE SHOT ALARM", oneShotButtonText);


    }

    @Test
    public void multipleElementsTest() {
        AndroidDriver<AndroidElement> driver = getAndroidDriver();
        List<AndroidElement> list = driver.findElements(By.className("android.widget.TextView"));

        for (AndroidElement element : list) {
            System.out.println(element.getText());
        }


    }

    @Test
    public void uiautomatorTest(){
        AndroidDriver<AndroidElement> driver = getAndroidDriver();
       AndroidElement accessibility =
               driver.findElementByAndroidUIAutomator("text(\"Accessibility\")");

       accessibility.click();






    }


}
