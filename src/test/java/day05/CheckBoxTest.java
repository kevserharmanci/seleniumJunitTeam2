package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CheckBoxTest {
    //1. Bir class oluşturun : CheckBoxTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın

   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
      // driver.close();
    }
    @Test
    public  void method1(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin

        WebElement checkbox1= driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayınca
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }


    }
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //  - https://www.facebook.com adresine gidin
    //  - Cookies’i kabul edin
    //  - “Create an Account” button’una basin
    //  - “radio buttons” elementlerini locate edin
    //  - Secili degilse cinsiyet butonundan size uygun olani secin
    @Test
    public void method2(){
        //  - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //  - “Create an Account” button’una basin
        driver.findElement
                (By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //  - “radio buttons” elementlerini locate edin
        //  - Secili degilse cinsiyet butonundan size uygun olani secin
        WebElement kadin = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
kadin.click();
    }

    }

