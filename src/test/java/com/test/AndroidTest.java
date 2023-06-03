package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

class AndroidTest {

  @Test
  void androidLaunchTest() throws MalformedURLException, InterruptedException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android"); //optional
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
    options.setDeviceName("amuthan-test-device");
    options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    driver.findElement(AppiumBy.accessibilityId("open menu")).click();
    /*new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(e->e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));
 */
    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"))
        .click();
    // Thread.sleep(5000);
    driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("wfwdfg");
    driver.quit();
    //Assertion
  }

  @Test
  void tap() throws MalformedURLException, InterruptedException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android"); //optional
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
    options.setDeviceName("amuthan-test-device");
    options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
    tap(driver, openMenu);
    //Assertion
  }

  @Test
  void doubleTap() throws MalformedURLException, InterruptedException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android"); //optional
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
    options.setDeviceName("amuthan-test-device");
    options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
    doubleTap(driver, openMenu);
    //Assertion
  }

  @Test
  void zoom() throws MalformedURLException, InterruptedException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android"); //optional
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
    options.setDeviceName("amuthan-test-device");
    options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    driver.findElement(AppiumBy.accessibilityId("open menu")).click();
    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"))
        .click();
    WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]"));
    Point centerOfElement = getCenterOfElement(element.getLocation(), element.getSize());

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
    Sequence sequence = new Sequence(finger1, 1)
        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofMillis(200)))
        .addAction(finger1.createPointerMove(Duration.ofMillis(200),
                                             PointerInput.Origin.viewport(), centerOfElement.getX() + 100,
                                             centerOfElement.getY() - 100))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    Sequence sequence2 = new Sequence(finger2, 1)
        .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
        .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger2, Duration.ofMillis(200)))
        .addAction(finger2.createPointerMove(Duration.ofMillis(200),
                                             PointerInput.Origin.viewport(), centerOfElement.getX() - 100,
                                             centerOfElement.getY() + 100))
        .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Arrays.asList(sequence, sequence2));

    //Assertion
  }

  @Test
  void longPress() throws MalformedURLException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android"); //optional
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
    options.setDeviceName("amuthan-test-device");
    options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
    driver.findElement(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
    driver.findElement(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
    WebElement element = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
    new Actions(driver).clickAndHold(element).perform();
    //Assertion
  }

  @Test
  void swipeOrScroll() throws MalformedURLException {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android"); //optional
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
    options.setDeviceName("amuthan-test-device");
    options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();

    Dimension size = driver.manage().window().getSize();
    int startX = size.getWidth() / 2;
    int startY = size.getHeight() / 2;
    int endX = startX;
    int endY = (int) (size.getHeight() * 0.25);
    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofMillis(200)))
        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
    //Assertion
  }

  private void longPress(AndroidDriver driver, WebElement element) {
    Point location = element.getLocation();
    Dimension size = element.getSize();

    Point centerOfElement = getCenterOfElement(location, size);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofSeconds(2)))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }

  private void doubleTap(AndroidDriver driver, WebElement element) {
    Point location = element.getLocation();
    Dimension size = element.getSize();

    Point centerOfElement = getCenterOfElement(location, size);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofMillis(100)))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofMillis(100)))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofMillis(100)))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }


  private void tap(AndroidDriver driver, WebElement element) {
    Point location = element.getLocation();
    Dimension size = element.getSize();

    Point centerOfElement = getCenterOfElement(location, size);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(new Pause(finger1, Duration.ofMillis(200)))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }

  private Point getCenterOfElement(Point location, Dimension size) {
    return new Point(location.getX() + size.getWidth() / 2,
                     location.getY() + size.getHeight() / 2);
  }

  @Test
  void iosLaunchTest() throws MalformedURLException, InterruptedException {
    XCUITestOptions options = new XCUITestOptions();
    options.setDeviceName("iPhone 13");
    options.setApp(System.getProperty("user.dir") + "/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

    IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
    Thread.sleep(4000);
    driver.findElements(By.name("store item text")).get(0).click();
  }
}