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
public class C02_DropDown {
    /*
              Bir class oluşturun: DropDown
          https://the-internet.herokuapp.com/dropdown adresine gidin.
          Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
          Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
          Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
          Tüm dropdown değerleri(value) yazdırın
          Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
          False yazdırın.
    */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //          Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //          Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //          Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //          Tüm dropdown değerleri(value) yazdırın
        select.getOptions().stream().forEach(t-> System.out.println(t.getText()));
        //          Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //          False yazdırın.
        System.out.println(select.getOptions().size());
        System.out.println(select.getOptions().size() == 4 ? true : false);
    }
}