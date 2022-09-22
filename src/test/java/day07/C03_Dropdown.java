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
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class C03_Dropdown {
    /*
  1. http://zero.webappsecurity.com/ Adresine gidin
  2. Sign in butonuna basin
  3. Login kutusuna “username” yazin
  4. Password kutusuna “password.” yazin
  5. Sign in tusuna basin
  6. Pay Bills sayfasina gidin
  7. “Purchase Foreign Currency” tusuna basin
  8. “Currency” drop down menusunden Eurozone’u secin
  9. “amount” kutusuna bir sayi girin
  10. “US Dollars” in secilmedigini test edin
  11. “Selected currency” butonunu secin
  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
  13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
   */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        //    2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //    3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("username");
        //    4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("password");
        //    5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();//site guvenli degil cıktıgı ıcın back yapıp devam ettik
        //Online Banking'e tikla
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        //    6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //    7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //    8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        //    9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("50");
        //    10. “US Dollars” in secilmedigini test edin
        WebElement usDolar=driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        Assert.assertFalse(usDolar.isSelected());
        //    11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();
        //    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        //    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id='alert_content']")).isDisplayed());
    }
}
