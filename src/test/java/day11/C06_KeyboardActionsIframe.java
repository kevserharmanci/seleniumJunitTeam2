package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C06_KeyboardActionsIframe extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

     //Bir Class olusturalim KeyboardActions2
 //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video'yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

 //videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(0);
        actions.click(driver.findElement(By.xpath("//*[@aria-label='Oynat']"))).perform();
 //videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@title='Ayarlar']")).isDisplayed());

    }
}
