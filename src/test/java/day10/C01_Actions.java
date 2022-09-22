package day10;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;
public class C01_Actions extends TestBaseBeforeClassAfterClass {
    /*
      Yeni bir class olusturalim: MouseActions3
      1 https://www.amazon.com/ adresine gidelim
      2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
      mouse’u bu menunun ustune getirelim
      3 “Create a list” butonuna basalim
      4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
       */
    @Test
    public void test(){
        // 1 https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        // 2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        WebElement account=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        // mouse’u bu menunun ustune getirelim
        actions.moveToElement(account).perform();
        // 3 “Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        // 4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        Assert.assertEquals("Your Lists",driver.findElement(By.xpath("//*[@role='heading']")).getText());
    }
}
