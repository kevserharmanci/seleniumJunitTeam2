package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_HomeWork {
    /*
   1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine "username" yazdirin
4. Password alanine "password" yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina "2020-09-10" yazdirin
9. Pay buttonuna tiklayin
10. "The payment was successfully submitted." mesajinin ciktigini control edin
    */
    /*
    1-C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4 Sayfa basliginin "Google" ifadesi icerdigini test edin
5 Arama cubuguna "Nutella" yazip aratin
6 Bulunan sonuc sayisini yazdirin
7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
8 Sayfayi kapatin
     */
    /*
    1. "https://www.saucedemo.com" Adresine gidin
2. Username kutusuna "standard_user" yazdirin
3. Password kutusuna "secret_sauce" yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='button']")).click();

    }

    @Test
    public void test2() {
        //3. Login alanine "username" yazdirin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("username");
        //4. Password alanine "password" yazdirin
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("password");
    }

    @Test
    public void test3() {
        //sign in butonuna tıklayın
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();
    }

    @Test
    public void test4() {
        //online banking sayfasına gıdın
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
    }

    @Test
    public void test5() {
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
    }

    @Test
    public void test6() {
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("input[id='sp_amount']")).sendKeys("150");
        //8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("input[id='sp_date']")).sendKeys("2020-09-10");
    }

    @Test
    public void test7() {
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("(//*[@id='pay_saved_payees'])[1]")).click();
    }

    @Test
    public void test8() {
        //10. "The payment was successfully submitted." mesajinin ciktigini control edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='alert_content']")).isDisplayed());
    }
}


