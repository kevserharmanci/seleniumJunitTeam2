package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C07_Homework extends TestBaseBeforeClassAfterClass {


    @Test
    public void test1() {
        //            -  amazon gidin
        driver.get("https://www.amazon.com");
        //        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropMenu);
        List<WebElement> listDDM = select.getOptions();
        listDDM.stream().forEach(t -> System.out.println(t.getText()));
        //ikinci yol
        //listDDM.stream().map(WebElement::getText).forEach(System.out::println);

        //        dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertFalse(listDDM.size() == 40);


        //        Test02
        //        dropdown menuden elektronik bölümü seçin

        select.selectByVisibleText("Electronics");
        //        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        String sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("sonucsayisi = "+sonucYazisi.split(" ")[2]);
        //        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText().contains("iphone"));

        //        ikinci ürüne relative locater kullanarak tıklayin
        WebElement image1=driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement image3=driver.findElement(By.xpath("(//*[@class='s-image'])[7]"));
        WebElement image2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(image1).toLeftOf(image3));
image2.click();
        //        ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
String urunTitle=driver.findElement(By.xpath("(//h1[1])")).getText();
    }
    @Test
    public void test3() {
        //        Test03
        //        yeni bir sekme açarak amazon anasayfaya gidin
        //        dropdown'dan bebek bölümüne secin
        //        bebek puset aratıp bulundan sonuç sayısını yazdırın
        //        sonuç yazsının puset içerdiğini test edin
        //        5-üçüncü ürüne relative locater kullanarak tıklayin
        //        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        //        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}