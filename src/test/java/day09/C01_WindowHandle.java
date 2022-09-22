package day09;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
public class C01_WindowHandle {
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in BestBuy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1(){
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        //2- Url'nin amazon içerdiğini test edelim
        Assert.assertTrue( driver.getCurrentUrl().contains("amazon"));
        String amazonHandle=driver.getWindowHandle();
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        //4- title'in BestBuy içerdiğini test edelim
        String actualBestBuyTitle=driver.getTitle();
        String exceptedBestBuy="BestBuy";
        Assert.assertFalse(actualBestBuyTitle.contains(exceptedBestBuy));
        String bestBuyHandle=driver.getWindowHandle();
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement arama=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaJava=arama.getText();
        Assert.assertTrue(aramaJava.contains("java"));
     /* Bununla birlikte cıkan sonuclarda java varmı dıye bakabılırız ve sonucları saydırabiliriz
     List<WebElement> aramaSonuclariList=driver.findElements(By.xpath("//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        int count=0;
        for (WebElement w:aramaSonuclariList) {
            if (!w.getText().contains("Java")){
                count++;
            }
        }
        System.out.println(count+" = java iceren urun yoktur");
        System.out.println((aramaSonuclariList.size()-count) +" = java iceren urun vardir");
        */
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyHandle);
        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }
}