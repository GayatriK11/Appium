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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Web1 extends capability{
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException  {
		//driver=capabil(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(5000);
	}
	@Test(enabled=false)
	public void testcase1() {
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Pillu");
		
		//fetch name
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getText();
		System.out.println(name);
		//drop down
		driver.findElement(By.id("android:id/text1")).click();
		//scroll country
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		assertEquals(name,"Pillu");

	}
	//error handling 
	@Test(enabled=false)
	public void testcase2() throws IOException, InterruptedException {
		System.out.println("Inside test 2");
		service=startServer();
		driver=capabil(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		/*driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Pillu");
		
		//fetch name
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getText();
		System.out.println(name);*/
		//drop down
		//driver.findElement(By.id("android:id/text1")).click();
		//scroll country
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//System.out.println(driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"));
		//System.out.println(driver.findElement(By.xpath("//*[@text='Please enter your name']")).getAttribute("name"));
		//assertEquals(driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"),"Please enter your name");

	}
	
	@Test(enabled=false)
	public void testcase3() {
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Pillu");
		
		//fetch name
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getText();
		System.out.println(name);
		//drop down
		driver.findElement(By.id("android:id/text1")).click();
		//scroll country
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		assertEquals(name,"Pillu");
		int l1=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(l1);
		/*List<AndroidElement> e1=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		for (int i=0;i<l1;i++) {
			if(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText()=="") {
				driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
			}
		}*/
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\"))");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		int l2=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		String Productname="";
		for (int i=0;i<l2;i++) {
			 Productname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			 System.out.println(Productname);
			if(Productname.equalsIgnoreCase("Air Jordan 9 Retro")){
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		//click on cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String prodCartName=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println(prodCartName);
		assertEquals(prodCartName,"Air Jordan 9 Retro");
	}
	@Test(enabled=true)
	public void testcase4() throws InterruptedException, IOException {
		service=startServer();
		driver=capabil(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Pillu");
		
		//fetch name
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getText();
		System.out.println(name);
		//drop down
		driver.findElement(By.id("android:id/text1")).click();
		//scroll country
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		assertEquals(name,"Pillu");
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//driver.findElements(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).get(1).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//click on cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(1000);
		String amt1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		System.out.println(amt1);
		amt1=amt1.substring(1);
		Double amt1Val=Double.parseDouble(amt1);
		String amt2=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		System.out.println(amt2);
		amt2=amt2.substring(1);
		Double amt2Val=Double.parseDouble(amt2);
		Double amtVal=amt1Val+amt2Val;
		
		String TotalValue=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		TotalValue=TotalValue.substring(1);
		Double TotalValueVal=Double.parseDouble(TotalValue);
		
		//assertEquals(TotalValueVal,amtVal);
		
		//tap on check box of terms
				
		WebElement tap = driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']"));
	    TouchAction t = new TouchAction(driver);
	    t.tap(tapOptions().withElement(element(tap))).perform();
		//long press on please read text
		
	    WebElement lp=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	    t.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
	    //Click on close
	    driver.findElement(By.id("android:id/button1")).click();
		//click on visit to web site
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	   Thread.sleep(1000);
	   Set<String>cont_Handles=driver.getContextHandles();
	   for (String contName:cont_Handles) {
		   System.out.println(contName);
	   }
	   Thread.sleep(3000);
	   driver.context("WEBVIEW_com.androidsample.generalstore");
	   Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		Thread.sleep(3000);
		//click on the box
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
		

	}
}