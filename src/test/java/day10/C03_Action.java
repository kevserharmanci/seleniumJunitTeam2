package day10;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;
public class C03_Action extends TestBaseBeforeClassAfterClass {
    /*
    Yeni bir class olusturalim: MouseActions2
    1 https://demoqa.com/droppable adresine gidelim
    2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */
    @Test
    public void test(){
        // 1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // 2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        actions.dragAndDrop(driver.findElement(By.xpath("//*[@id='draggable']")),
                driver.findElement(By.xpath("(//*[@id='droppable'])[1]"))).perform();
        // 3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}
