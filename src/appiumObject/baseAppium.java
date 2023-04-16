package appiumObject;



import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class baseAppium {

    public String title="";
    public static String valResult="";
    public static String valResultB="not";





    static WebDriver driver=null;


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




