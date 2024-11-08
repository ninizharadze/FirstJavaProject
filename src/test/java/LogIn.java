import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertEquals;

public class LogIn {

    @Test
    public void LogInInvalid(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Selenide.open("https://dev.admin.suada.com/login");
        sleep(1000);

        $(byAttribute("type", "text" )).setValue("super+1@gmail.com");
        $(byAttribute("type", "password")).setValue("Qwerty1$");
        $(byAttribute("type", "submit")).click();
        sleep(2000);

//        String expectedUrl = "data:,";
//        assertEquals(expectedUrl, driver.getCurrentUrl());

        $(byText("Users")).click();
        $(byText("Super Admins")).click();
        $(byXpath("//button[contains(text(), 'Add Super Admin')]")).click();
        $(byAttribute("name", "firstName")).setValue("New");
        $(byAttribute("name", "lastName")).setValue("Super Admin");
        $(byAttribute("name", "email")).setValue("new+superadmin@suada.com");
        $(byXpath("//button[contains(text(), 'Save')]")).click();
//         Check if an element with the exact text "New Super Admin has been added" is visible
        $("#notistack-snackbar").shouldHave(text("New Super Admin has been added"));

        $(".sc-bgykYu.iFQYHR.user_delete_icon").click();
        $(byXpath("//button[contains(text(), 'Yes, Delete!')]")).click();
        $("#notistack-snackbar").shouldHave(text("Super Admin has been deleted"));

    }
}
