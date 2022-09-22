package day08;

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

public class HOMEWORK {
    /*
     1. Launch browser
 2. Navigate to url 'http://automationexercise.com'
 3. Verify that home page is visible successfully
 4. Click on 'Signup / Login' button
 5. Verify 'Login to your account' is visible
 6. Enter correct email address and password
 7. Click 'login' button
 8. Verify that 'Logged in as username' is visible
 9. Click 'Delete Account' button
 10. Verify that 'ACCOUNT DELETED!' is visible
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @Test
    public void test(){
        //   1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        driver.navigate().to("http://automationexercise.com");
        WebElement anaSayfa=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(anaSayfa.isDisplayed());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        // 5. Verify 'Login to your account' is visible

        Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());
        // 6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("jhjhsgsg1@gmail.com");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("1234");
        // 7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        // 8. Verify that 'Logged in as username' is visible
       WebElement actuelLogged=driver.findElement(By.xpath("//*[@class='fa fa-user']"));
       Assert.assertTrue(actuelLogged.isDisplayed());
        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        // 10. Verify that 'ACCOUNT DELETED!' is visible

Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
      /* Click on 'Signup / Login' button
      5. Verify 'New User Signup!' is visible
       */






    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}

