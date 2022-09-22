package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Homework {
        /*
                 Test Case 1: Register User
         1. Launch browser(Test Durumu 1: Kullanıcıyı Kaydet
         1. Tarayıcıyı başlatın)
         2. Navigate to url 'http://automationexercise.com'
         3. Verify that home page is visible successfully
         4. Click on 'Signup / Login' button
         5. Verify 'New User Signup!' is visible
         6. Enter name and email address
         7. Click 'Signup' button
         8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
         9. Fill details: Title, Name, Email, Password, Date of birth
         10. Select checkbox 'Sign up for our newsletter!'
         11. Select checkbox 'Receive special offers from our partners!'
         12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
         13. Click 'Create Account button'
         14. Verify that 'ACCOUNT CREATED!' is visible
         15. Click 'Continue' button
         16. Verify that 'Logged in as username' is visible
         17. Click 'Delete Account' button
         18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
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
        //    driver.close();
    }

    @Test
    public void test(){
        //         1. Tarayıcıyı başlatın
        //         2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //         3. Verify that home page is visible successfully
        System.out.println(driver.findElement(By.xpath("//*")).isDisplayed()+" = home page is visible successfully");
        //         4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //         5. Verify 'New User Signup!' is visible
        System.out.println(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed()+" = New User Signup is visible successfully");
        //         6. Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("ylz");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("jhjhsgsg1@gmail.com");

        //         7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        //         8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        System.out.println(driver.findElement(By.xpath("(//b)[1]")).isDisplayed());

        //         9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("15");
        driver.findElement(By.xpath("//*[@name='months']")).sendKeys("APRİL");
        driver.findElement(By.xpath("//*[@name='years']")).sendKeys("2021");
        //         10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();

        //         11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
        //         12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys("kevser");
        driver.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys("harmncı");
        driver.findElement(By.xpath("(//*[@type='text'])[5]")).sendKeys("asdf");
        driver.findElement(By.xpath("(//*[@type='text'])[6]")).sendKeys("cvbn");
        driver.findElement(By.xpath("//*[@value='Canada']")).click();
        driver.findElement(By.xpath("(//*[@type='text'])[8]")).sendKeys("tosya");
        driver.findElement(By.xpath("(//*[@type='text'])[9]")).sendKeys("asdfgh");
        driver.findElement(By.xpath("(//*[@type='text'])[10]")).sendKeys("kevser");
        driver.findElement(By.xpath("(//*[@type='text'])[11]")).sendKeys("789456");

        //         13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();


        //         14. Verify that 'ACCOUNT CREATED!' is visible
        driver.findElement(By.xpath("//b")).isDisplayed();

        //         15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //         16. Verify that 'Logged in as username' is visible

        //         17. Click 'Delete Account' button

        //         18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }


}