import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.sleep;

public class LogIn {

    @Test
    public void LogInInvalid(){
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://dev.app.suada.com/");
        sleep(1000);

        $(byAttribute("type", "text")).setValue("nini+17@suada.com");
        $(byAttribute("type", "password")).setValue("Qwertyuiop1$");
        $(byText("Sign in")).click();

        Assert.assertEquals("Invalid credentials", $(byXpath("/html/body/div/section/div[2]/div/form/div[1]/p")).getText());
    }
}
