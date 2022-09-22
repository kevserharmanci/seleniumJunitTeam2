package day09;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
public class C03_IframeHomework {
    /*
   1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
   2) sayfadaki iframe sayısını bulunuz.
   3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
   4) ilk iframe'den çıkıp ana sayfaya dönünüz
   5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
      tıklayınız
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
        //    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //    2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=driver.findElements(By.xpath("//iframe"));
        System.out.println("Iframe sayisi = "+iframeList.size());
        //    3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0);//sifir yerine driver.findelement(By.xpath("(//iframe)[1]) yada iframelist.get(0) da olur
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        //    4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //    5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        driver.switchTo().frame(1);
        //       tıklayınız
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }
}
