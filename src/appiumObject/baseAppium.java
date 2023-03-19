package appiumObject;



import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class baseAppium {

    public String title="";





    static ExtentTest myTests;
    static String reportFilePath="C:\\selenium\\files\\reports\\testReports2.html";
    static WebDriver driver=null;
    static String path="C:\\Selenium\\files\\calcConfig.xml";
    static String file="calcConfig.xml";
    static String assertionError = null;
    static String imagePath="C:\\selenium\\files\\image";

    public baseAppium(WebDriver driver) {
        this.driver = driver;
    }






        public void writeText (By element, String toFill)
        {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(toFill);
        }

        public  void clickItem (By element)
        {
            driver.findElement(element).click();

        }

//       basePage.basePage1(driver);

    }




