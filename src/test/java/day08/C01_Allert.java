package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allert {
   // Bir class olusturun: Alerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
 //   Bir metod olusturun: dismissAlert
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//"successfuly" icermedigini test edin.
 //   Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
  //  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test1(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        System.out.println("1. buton" + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
       WebElement sonucYazisi= driver.findElement(By.xpath("//*[@id='result']"));
       String expectedYazi = "You successfully clicked an alert";
       String actualYazi=sonucYazisi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println("2. buton" + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement sonucYazisi2=driver.findElement(By.xpath("//*[id@='result']"));
        String expectedYazi2=sonucYazisi2.getText();
        String actualYazi2=sonucYazisi2.getText();
        Assert.assertFalse(actualYazi2.contains(expectedYazi2));
    }
    @Test
    public void test3(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println("3. buton" + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement sonucYazisi3=driver.findElement(By.xpath("//*[id@='result']"));
        String expectedYazi3=sonucYazisi3.getText();
        String actualYazi3=sonucYazisi3.getText();
        Assert.assertFalse(actualYazi3.contains(expectedYazi3));
    }
}
