package day12;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
public class C02_Homework extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //     1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //     2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverKutusu = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverKutusu).perform();
        //     3. "Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.click(link1).perform();
        //     4. Popup mesajini yazdirin
        System.out.println("Popup mesaji " + driver.switchTo().alert().getText());
        //     5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //     6. "Click and hold" kutusuna basili tutun
        WebElement clickandhold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickandhold);
        //     7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickandhold.getText());
        //     8. "Double click me" butonunu cift tiklayin
        WebElement dobleclick=driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(dobleclick).perform();
    }
}
