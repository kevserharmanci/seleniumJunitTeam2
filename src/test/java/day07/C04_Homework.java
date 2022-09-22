package day07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C04_Homework {
    /*
  1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
   */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test(){
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunWe= driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]"));
        String ilkUrunName=ilkUrunWe.getText();
        ilkUrunWe.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String urunControl=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(urunControl,ilkUrunName);
    }
}