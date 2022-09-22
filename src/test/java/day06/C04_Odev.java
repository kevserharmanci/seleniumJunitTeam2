package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Odev {
    /*
Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter'a
bastigimizda "Invalid email address" uyarisi ciktigini test edelim

 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
}
@Test
    public void test1(){
    //Sign in butonuna basalim
    driver.findElement(By.xpath("//*[@class='login']")).click();

}
@Test
    public void test2(){
    driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("sdfghjklş"+ Keys.ENTER);
}
}
