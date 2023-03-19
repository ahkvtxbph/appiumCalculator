package appiumObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class calcAppium extends baseAppium{

    public  calcAppium (WebDriver driver)
    {
        super(driver);
    }

    By plus = By.id("com.miui.calculator:id/btn_plus_s");
    By minus = By.id("com.miui.calculator:id/btn_minus_s");
    By div=By.id("com.miui.calculator:id/btn_div_s");
    By result=By.id("com.miui.calculator:id/btn_equal_s");
    By mul=By.id("com.miui.calculator:id/btn_mul_s");
    By one = By.id("com.miui.calculator:id/btn_1_s");
    By two = By.id("com.miui.calculator:id/btn_2_s");
    By three = By.id("com.miui.calculator:id/btn_3_s");
    By four = By.id("com.miui.calculator:id/btn_4_s"); //partialLinkText("5");
    By five = By.id("com.miui.calculator:id/btn_5_s");
    By six = By.id("com.miui.calculator:id/btn_6_s");
    By seven = By.id("com.miui.calculator:id/btn_7_s");
    By eight = By.id("com.miui.calculator:id/btn_8_s");
    By nine = By.id("com.miui.calculator:id/btn_9_s");
    By zero = By.id("com.miui.calculator:id/btn_0_s");


    public void action(String ac)
    {
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

    public void resultClick()
    {
        clickItem(result);
    }
    public void numOption(String num) {
        switch (num) {
            case "1":
                clickItem(one);
                break;
            case "2":

                clickItem(two);
                break;
            case "3":

                clickItem(three);
                break;
            case "4":

                clickItem(four);
                break;
            case "5":

                clickItem(five);
                break;
            case "6":

                clickItem(six);
                break;
            case "7":

                clickItem(seven);
                break;
            case "8":

                clickItem(eight);
                break;
            case "9":

                clickItem(nine);
                break;
            case "0":

                clickItem(zero);
                break;
            default:

                clickItem(zero);

        }
    }
}
