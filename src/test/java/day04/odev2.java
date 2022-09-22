package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        // 4-)Sayfayi “refresh” yapin
        driver.navigate().refresh();
        // 5-)Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="Spend less";
        System.out.println(actualTitle.contains(expectedTitle) ? "Title Test PASSED" : "Title Test FAILED");
        // 6-)Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@data-csa-c-content-id='nav_cs_gc']")).click();
        // 7-)Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();
        // 8-)Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();
        // 9-) Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();
        // 10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretWE= driver.findElement(By.xpath("//*[@id='gc-live-preview-amount']"));
        String actualPrice=ucretWE.getText();
        String expectedPrice="$25.00";
        System.out.println(actualPrice.equals(expectedPrice) ? "PASSED" : "FAILED");
        // 11-Sayfayi kapatin
        driver.quit();
    }
}
