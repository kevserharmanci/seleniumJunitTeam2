package day12;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;
import java.awt.*;
import java.util.ArrayList;
public class C04_Homework extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        // 2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("(//*[@class='thumbnail'])[3]")).click();
        // 4.Diger window'a gecin
        java.util.List<String> windowListe = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowListe.get(1));
        // 5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
        // 6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        System.out.println("popup mesaji = " + driver.switchTo().alert().getText());
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(windowListe.get(0));
        // 10.Ilk sayfaya donuldugunu test edin
        WebElement birinciSayfa=driver.findElement(By.xpath("//*[@id='nav-title']"));
        Assert.assertTrue(birinciSayfa.isDisplayed());
    }
}