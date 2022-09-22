package day09;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class C02_WindowHandle {
    /*
   Tests package’inda yeni bir class olusturun: WindowHandle2
https://the-internet.herokuapp.com/windows adresine gidin.
Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
Click Here butonuna basın.
Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
Sayfadaki textin “New Window” olduğunu doğrulayın.
Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
    */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        //  Tests package’inda yeni bir class olusturun: WindowHandle2
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String amazonHandle=driver.getWindowHandle();
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        assert driver.findElement(By.xpath("//h3")).isDisplayed();
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın
        assert driver.getTitle().equals("The Internet");
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        List<String> handleDegerleri=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handleDegerleri.get(1));
        assert driver.getTitle().equals("New Window");
        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        assert driver.findElement(By.xpath("(//*[text()='New Window'])[2]")).isDisplayed();
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(handleDegerleri.get(0));
        assert driver.getTitle().equals("The Internet");
        // NOT:
        /*
        eger test ettigimiz sayfa bizi kendiliginden yeni bir sayfada(taga yonlendirirse) list kullanarak sisteme o sayfayı tanıtmamız gerekir
        ama biz kendimiz yeni sayfa acarsak dırek handle degerleri ile işlem yapabiliriz.
         */
        /*
         Click yaptiktan sonra acilan yeni sayfa ile baglanti kurmamiz gerekir. Eger yukaridaki islemleri yapmasak hata verir.
         Cunku click here elementine bastiktan sonra acilan yeni sayfanin yolunu programa tanitmamiz gerekir.
         Yani bu islemlerle acilan tum sayfalarin window Handle degerlerini index olarak bir list'e kaydedip,
         driver.switchTo().window(windowList.get(1)); Bu method ile de hangi sayfa uzerinde islem yapmak istiyorsak get(index) kullanarak devam ederiz
       */
    }
}
