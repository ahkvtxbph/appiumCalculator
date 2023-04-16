package appiumObject;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.event.KeyEvent;

public class calcAppium extends baseAppium{

    public  calcAppium (WebDriver driver)
    {
        super(driver);
    }

    By plus = By.id("com.miui.calculator:id/btn_plus_s");
    By minus = By.id("com.miui.calculator:id/btn_minus_s");
    By div=By.id("com.miui.calculator:id/btn_div_s");
    By mul=By.id("com.miui.calculator:id/btn_mul_s");
    By one = By.id("com.miui.calculator:id/btn_1_s");
    By two = By.id("com.miui.calculator:id/btn_2_s");
    By three = By.id("com.miui.calculator:id/btn_3_s");
    By four = By.id("com.miui.calculator:id/btn_4_s");
    By five = By.id("com.miui.calculator:id/btn_5_s");
    By six = By.id("com.miui.calculator:id/btn_6_s");
    By seven = By.id("com.miui.calculator:id/btn_7_s");
    By eight = By.id("com.miui.calculator:id/btn_8_s");
    By nine = By.id("com.miui.calculator:id/btn_9_s");
    By zero = By.id("com.miui.calculator:id/btn_0_s");
    By result=By.id("com.miui.calculator:id/btn_equal_s");
    By calcResult=By.id("com.miui.calculator:id/result");



    public void action(String ac) throws InterruptedException {
        switch (ac)
        {
            case "+":
                clickItem(plus);
                break;
            case "-":

                clickItem(minus);
                break;
            case "/":

                clickItem(div);
                break;
            case "*":

                clickItem(mul);
                break;
        }

    }

    public void validateResult(String trueResult, String expected)
    {
        try{
            Assert.assertEquals(trueResult, expected);
            System.out.println("equal");
            valResultB="true";
        }catch(AssertionError e){
            System.out.println("not equal");
            valResultB="error";
            valResult = e.getMessage();

        }

    }



     public String resultAnswer() throws InterruptedException {
         String ans="+";
         Thread.sleep(1000);
         clickItem(calcResult);
         WebElement res=driver.findElement(calcResult);
         res.click();
         System.out.println(res.getSize()+" "+ans);
         ans=res.getText();
         System.out.println(res.getSize()+" "+ans);
         Thread.sleep(1000);
         System.out.println(ans+" Shilo2");
         //ans=ans.substring(2);
         return ans;
     }
    public void resultClick() throws InterruptedException {
        clickItem(result);
    }

    public void numOption(String num) throws InterruptedException {
        switch (num) {
            case "1":{
                clickItem(one);
                break;}
            case "2":{

                clickItem(two);
                break;}
            case "3":{

                clickItem(three);
                break;}
            case "4":{

                clickItem(four);
                break;}
            case "5":{

                clickItem(five);
                break;}
            case "6":
            {
                clickItem(six);
                break;}
            case "7":{

                clickItem(seven);
                break;}
            case "8":
            {
                clickItem(eight);
                break;}
            case "9":{

                clickItem(nine);
                break;}
            case "0":{

                clickItem(zero);
                break;}
            default:{ break;}

        }
    }

    public void numValidateLength(String num) throws InterruptedException {
        String tempNUm;
        for (int i=0;i<num.length();i++) {
            tempNUm=String.valueOf(num.charAt(i));
            numOption(tempNUm);
        }
    }
}
