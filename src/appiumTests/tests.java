package appiumTests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class tests extends baseTest {
   String num1,num2;


   @Test
    public void test01_press() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");
        Thread.sleep(500);
        num1=readFrom("num1",path,file);
        calcAppium.numOption(num1);
        Thread.sleep(500);
        calcAppium.action("+");
        Thread.sleep(500);
        num2= readFrom("num2",path,file);
        calcAppium.numOption(num2);
        calcAppium.resultClick();
    }



    @After
    public void after()
    {

        extent.endTest(myTests);
    }

    @AfterClass
    public static void end() throws InterruptedException {
        Thread.sleep(2000);
//         driver.close();
        //     driver.quit();
        extent.flush();
    }
}
