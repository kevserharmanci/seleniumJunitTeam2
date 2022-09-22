package day10;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;
import java.util.ArrayList;
import java.util.List;
public class C02_Actions extends TestBaseBeforeClassAfterClass {
    //Yeni bir class olusturalim: MouseActions1
    //https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // 3- Cizili alan uzerinde sag click yapalim
    //Alert’te cikan yazinin “You selected a context menu” oldugunu
    //Tamam diyerek alert’i kapatalim
    //Elemental Selenium linkine tiklayalim
    //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        actions.contextClick(driver.findElement(By.xpath("//*[@id='hot-spot']"))).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> yenisayfa=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(yenisayfa.get(1));
        assert driver.findElement(By.xpath("//h1")).getText().equals("Elemental Selenium");
    }
}
