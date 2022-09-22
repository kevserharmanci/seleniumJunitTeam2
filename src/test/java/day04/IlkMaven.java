package day04;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;


public class IlkMaven {
        public static void main(String[] args) {
         /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //  1- https://www.amazon.com/ sayfasina gidelim
            driver.get("https://www.amazon.com");
            //2- arama kutusunu locate edelim
            WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
            // 3- “Samsung headphones” ile arama yapalim
            aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
           // 4- Bulunan sonuc sayisini yazdiralim
            WebElement result=driver.findElement(By.xpath("//*[class='a-section a-spacing-small a-spacing-medium']"));
            String resultYazisi=result.getText();
            System.out.println(resultYazisi);
            System.out.println(resultYazisi.split(" ")[2]);
            Arrays.stream(resultYazisi.split("")).limit(3).skip(2).forEach(System.out::println);//lambda

            //5- Ilk urunu tiklayalim
            driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
            //6- Sayfadaki tum basliklari yazdiralim
            driver.findElements(By.xpath("//h1")).stream().map(WebElement::getText).forEach(System.out::println);
            driver.findElements(By.xpath("//h1")).stream().forEach(t-> System.out.println(t.getText()));




        }
    }


