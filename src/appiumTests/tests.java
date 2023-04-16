package appiumTests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class tests extends baseTest {
    String num1,num2,act;
    String acctualResult,expectedResult;


 @Test
    public void test01_pressFirst() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");

       takeScreenShot(getiPath()+"\\"+System.currentTimeMillis());
       Thread.sleep(500);
        num1=readFrom("num1",getXmlPath(),getXmlFile());
        calcAppium.numValidateLength(num1);

       takeScreenShot(getiPath()+"\\"+System.currentTimeMillis());


    }

    @Test
    public void test02_pressAction() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");
        Thread.sleep(500);
        act = readFrom("action", getXmlPath(),getXmlFile());
        calcAppium.action(act);
        takeScreenShot(getiPath() + "\\" + System.currentTimeMillis());

    }
    @Test
    public void test03_pressSecond() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");
        Thread.sleep(500);
        num2 = readFrom("num2",getXmlPath(),getXmlFile());
        calcAppium.numValidateLength(num2);
        takeScreenShot(getiPath() + "\\" + System.currentTimeMillis());
    }

    @Test
    public void test04_pressResult() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");

        Thread.sleep(500);
        calcAppium.resultClick();
        takeScreenShot(getiPath()+"\\"+System.currentTimeMillis());
    }

    @Test
    public void test05_assert() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.PASS, "Test Start");
        acctualResult = calcAppium.resultAnswer();
        Thread.sleep(500);
        expectedResult= readFrom("excpected",getXmlPath(),getXmlFile());
        takeScreenShot(getiPath()+"\\"+System.currentTimeMillis());
        calcAppium.validateResult(acctualResult,expectedResult);

        if (baseAppium.valResultB.contains("error"))
        {
            myTests.log(LogStatus.FAIL, "Log from threadId: " + baseAppium.valResult);
        }
        else
        {
            myTests.log(LogStatus.PASS,"Log from threadId: Result equal"+  expectedResult);
        }
    }

    @After
    public void after(){

        extent.endTest(myTests);
    }

    @AfterClass
    public static void end() throws InterruptedException {

        //  driver.close();
         driver.quit();
        extent.flush();
    }
}
