package appiumTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import appiumObject.baseAppium;
import appiumObject.calcAppium;




public class baseTest {

    static baseAppium baseAppium;
    static calcAppium calcAppium;
    static ExtentReports extent;
    static ExtentTest myTests;
    static String reportFilePath="C:\\selenium\\files\\reports\\testReports2.html";
    static WebDriver driver=null;
    static String path="C:\\Selenium\\files\\";
    static String file="calcConfig.xml";
    static String assertionError = null;
    static String imagePath="C:\\selenium\\files\\image";

    @BeforeClass
    public static void testSetup()throws Exception {
        extent = new ExtentReports(reportFilePath);
        myTests = extent.startTest("ExtentDemo");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android device");
        capabilities.setCapability("appPackage", "com.miui.calculator");
        capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
        capabilities.setCapability("newCommandTimeout", 120);
     /*  capabilities.setCapability("uniCodeKeyBoard", true);
        capabilities.setCapability("resetKeyBoard", true);*/
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        resetPage();
    }



    public static void resetPage()
    {
        baseAppium=new baseAppium(driver);
        calcAppium=new calcAppium(driver);
    }

    public  static String takeScreenShot(String IMagePath) throws IOException
    {
        TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(IMagePath+".png");
        try
        {
            FileUtils.copyFile(screenShotFile,destinationFile);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return IMagePath+".png";
    }

    public static String readFrom(String keyData, String path, String file) throws Exception
    {
        File xmlFile = new File(path+file);

        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document doc = dbBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }

}
