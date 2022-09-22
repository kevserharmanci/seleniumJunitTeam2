package day11;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;




import org.junit.Test;
import org.openqa.selenium.By;


    public class C04_ActionsHomework extends TestBaseBeforeClassAfterClass {
        @Test
        public void test1() {

            // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
            driver.get("http://webdriveruniversity.com/Actions");
            //  2- Hover over Me First" kutusunun ustune gelin
            WebElement kutu=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
            Actions actions=new Actions(driver);
            actions.moveToElement(kutu).perform();
            // Link 1" e tiklayin
            actions.click(driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"))).perform();
            // Popup mesajini yazdirin
            System.out.println("pop mesaji"+driver.switchTo().alert().getText());
            // Popup'i tamam diyerek kapatin
            driver.switchTo().alert().accept();
            // "Click and hold" kutusuna basili tutun
            actions.contextClick(driver.findElement(By.xpath("//*[@id='click-box']"))).perform();
            // 7-"Click and hold" kutusunda cikan yaziyi yazdirin
            System.out.println("clickandhold mesaji =  " + driver.findElement(By.xpath("//*[@id='click-box']")).getText());
            // 8- "Double click me" butonunu cift tiklayin
            actions.doubleClick(driver.findElement(By.xpath("//h2"))).perform();


        }
    }

