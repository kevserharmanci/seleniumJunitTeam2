package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
        //    driver.close();

    }

    @Test
    public void test1() throws InterruptedException {
        //https://html.com/tags/iframe/ adresine gidinz
        //youtube videosunu calistiriniz
        //aaria-label="Oynt"

        driver.get("https://html.com/tags/iframe/");
//   driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']")).click();
        WebElement framevideo= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(framevideo);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
    }
}
