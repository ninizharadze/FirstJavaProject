import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class login {

    @Test
    public void LogInAndCreateSuperAdmin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.admin.suada.com/login");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("super+1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwerty1$");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Users']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Super Admins']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Add Super Admin')]")).click();
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("New");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Super Admin");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("new+superadmin@suada.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();

        Thread.sleep(2000);
        WebElement assertionForCreate = driver.findElement(By.id("notistack-snackbar"));
        Assert.assertTrue(assertionForCreate.getText().contains("new Super Admin has been added"));
    }
@Test
public void LogInAndDeleteSuperAdmin() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://dev.admin.suada.com/login");

    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("super+1@gmail.com");
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwerty1$");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[text()='Users']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[text()='Super Admins']")).click();

    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".sc-bgykYu.iFQYHR.user_delete_icon")).click();
    driver.findElement(By.xpath("//button[contains(text(), 'Yes, Delete')]")).click();
    Thread.sleep(2000);
    WebElement assertionForDelete = driver.findElement(By.id("notistack-snackbar"));
    Assert.assertTrue(assertionForDelete.getText().contains("Super Admin has been deleted"));


}

}
