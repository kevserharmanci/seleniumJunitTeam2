package day07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
public class C01_DropDown {
    //amazon
    //-Test1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
    //oldugunu testedin
    //-Test2
    //1.Kategori menusunden Books seceneginisecin
    //2.Arama kutusuna Java yazin vearatin
    //3.Bulunan sonuc sayisiniyazdirin
    //4.Sonucun Java kelimesini icerdigini testedin
    WebDriver driver;
    Select select;
    WebElement ddm;
    List<WebElement> ddmList;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com/");
    }
    @After
    public void tearDown(){
        driver.close();
        System.out.println("All Is Well :) ");
    }
    @Test
    public void test1(){
        //-Test1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin
        ddm= driver.findElement(By.xpath("//*[@title='Search in']"));
        select=new Select(ddm);
        ddmList=select.getOptions();
        int exceptedNumber=45;
        int actaulNumber=ddmList.size();
        Assert.assertNotEquals(exceptedNumber,actaulNumber);
    }
    @Test
    public void test2(){
        //-Test2
        //1.Kategori menusunden Books seceneginisecin
        ddm= driver.findElement(By.xpath("//*[@title='Search in']"));
        select=new Select(ddm);
        select.selectByVisibleText("Books");
        //2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisiniyazdirin
        System.out.println(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
        //4.Sonucun Java kelimesini icerdigini testedin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText().contains("Java"));
    }
}