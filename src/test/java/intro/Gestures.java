package intro;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;

import java.time.Duration;
import java.util.List;

import static common_utils.DriverUtils.getAndroidDriver;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures {

    @Test
    public void tapTest() {
        AndroidDriver<AndroidElement> driver = getAndroidDriver();
        AndroidElement viewsButton = driver.findElementByAccessibilityId("Views");

        //tap
        TouchAction touchAction = new TouchAction(driver);

        touchAction.tap(TapOptions.tapOptions().withElement(element(viewsButton))).perform();

        /**
         * TapOptions tapOptions = new TapOptions(); //TapOptions.tapOptions()
         * touchAction.tap(tapOptions.withElement(element(viewsButton))).perform();
         */

        AndroidElement expandableListsButton =
                driver.findElementByAccessibilityId("Expandable Lists");

        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(expandableListsButton))).perform();

        AndroidElement customAdapterButton =
                driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");

        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(customAdapterButton))).perform();

        AndroidElement peopleNamesButton =
                driver.findElementByAndroidUIAutomator("text(\"People Names\")");

        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(peopleNamesButton))
                .withDuration(Duration.ofSeconds(2))
        ).perform();

        List<AndroidElement> list = driver.findElementsById("android:id/title");
        for (AndroidElement element : list) {
            System.out.println(element.getText());
        }
    }


    @Test
    public void scrollTest() {

        AndroidDriver<AndroidElement> driver = getAndroidDriver();
        AndroidElement viewsButton = driver.findElementByAccessibilityId("Views");

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(viewsButton))).perform();


        AndroidElement listsButton = driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lists\"))");


    }

}
