package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_NUTELLA {
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
     WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




    }
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        String expectedTitle=driver.getTitle();
       // 4 Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitile="Google";
        Assert.assertTrue(actualTitile.contains(expectedTitle));

        driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("Nutella", Keys.ENTER);
        String resultYazisi=driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String resultSayisi=resultYazisi.split(" ")[1].replace(".","");
        System.out.println("Result Sayisi: " + resultSayisi);
        int resultInt=Integer.parseInt(resultSayisi);
        Assert.assertTrue(resultInt>10000000);

    }
    @After
    public void tearDown(){
        //driver.close();
    }
}
