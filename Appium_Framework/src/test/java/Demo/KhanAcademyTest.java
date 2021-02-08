package Demo;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class KhanAcademyTest extends capability{
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException  {
		//driver=capabil(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(5000);
	}
	@Test(enabled=false)
	public void CloseDismiss() throws IOException, InterruptedException {
		driver = capabil(appPackage, appActivity, deviceName, platformName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.Button")).click();
	}
	//error handling 
	@Test(enabled=false)
	public void CloseCovidDismiss() throws IOException, InterruptedException {
		service = startServer();
		driver = capabil(appPackage, appActivity, deviceName, platformName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.findElement(By.className("android.widget.Button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Dismiss").click();
		service.stop();
	}
	
	@Test(enabled=false)
	public void TC3_Support() throws IOException, InterruptedException {
		service = startServer();
		driver = capabil(appPackage, appActivity, deviceName, platformName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.findElement(By.className("android.widget.Button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Dismiss").click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Settings\"]")).click();
		driver.findElement(By.xpath("//*[@text='Help & feedback']")).click();
		Thread.sleep(30000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_org.khanacademy.android");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name=\"query\"]")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@name=\"query\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		service.stop();
	}


	@Test(enabled = false)

	public void TC4_SignUp() throws InterruptedException, IOException {
		service = startServer();
		driver = capabil(appPackage, appActivity, deviceName, platformName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("Dismiss").click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Settings\"]")).click();
		driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign up with email\"]")).click();
		driver.findElementByAccessibilityId("First name").sendKeys("Gayatri");
		driver.findElementByAccessibilityId("Last name").sendKeys("K");
		driver.findElementByAccessibilityId("Birthday").click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElementByAccessibilityId("Email address").sendKeys("test@test.com");
		driver.findElementByAccessibilityId("Password").sendKeys("Test123456");
		driver.findElementByAndroidUIAutomator("text(\"CREATE\")").click();
		service.stop();

	}

	

	@Test(enabled = true)

	public void Testcase5SignInOut() throws InterruptedException, IOException {
		service = startServer();
		driver = capabil(appPackage, appActivity, deviceName, platformName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(30000);
		driver.findElementByAccessibilityId("Dismiss").click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Settings\"]")).click();
		driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		Thread.sleep(3000);
		System.out.print(driver.findElementsByClassName("android.widget.Button").size());
		driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
		driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("test@test.com");
		driver.findElementByAccessibilityId("Password").sendKeys("Test123456");
		driver.findElementByAccessibilityId("Sign in").click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@content-desc=\"Settings\"]")).click();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("text(\"Sign out\")").click();
		driver.findElement(By.id("android:id/button1")).click();
		service.stop();

	}
	}