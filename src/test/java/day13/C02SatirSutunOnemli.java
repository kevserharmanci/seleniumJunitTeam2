package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;



public class C02SatirSutunOnemli extends TestBaseBeforeAfter {


    @Test
    public void test() {

        // ● Bir class oluşturun : D18_WebTables
//● login( ) metodun oluşturun ve oturum açın.
        login();
        table();
        printRows();
        printCelss();
        printColumns();
//● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
//○ Username : manager ○ Password : Manager2!

//● printCells( ) metodu oluşturun //td
//○ table body'sinde bulunan toplam hücre(cell) sayısını bulun.
//○ Table body'sinde bulunan hücreleri(cells) konsolda yazdırın.
//● printColumns( ) metodu oluşturun
//○ table body'sinde bulunan toplam sutun(column) sayısını bulun.
//○ Table body'sinde bulunan sutunlari(column) konsolda yazdırın.
//○ 5.column daki elementleri konsolda yazdırın.

    }

    private void printColumns() {
        //● printColumns( ) metodu oluşturun
//○ table body'sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> columnSayisi = driver.findElements(By.xpath("//tbody//tr[3]//td"));
        //1 yerine 9'a kadar yazabiliriz sonuc aynısını verir
        System.out.println("ColumnSayisi :" + columnSayisi.size());
        System.out.println("-----");
//○ Table body'sinde bulunan sutunlari(column) konsolda yazdırın.
        /* 2.cozum
          int count =1;
        while(count<10) {
            List<WebElement> column= driver.findElements(By.xpath("//tbody//tr[*]//td["+count+"]"));
            column.stream().map(WebElement::getText).forEach(System.out::println);
            count++;
        }

        //5.column daki elementleri konsolda yazdırın.
        List<WebElement> column5=driver.findElements(By.xpath("//tbody//tr[*]//td[5]"));
        column5.stream().map(WebElement::getText).forEach(System.out::println);
         */
        int count = 1;

        while (count < 10) {
            driver.findElements(By.xpath("//tbody//tr[*]//td[" + count + "]")).forEach((t -> System.out.println(t.getText())));
            count++;
            System.out.println();
            System.out.println();
        }
        System.out.println("------");
//○ 5.column daki elementleri konsolda yazdırın.
        driver.findElements(By.xpath("//tbody//tr[*]//td[5]")).stream().
                map(WebElement::getText).forEach(System.out::println);

    }

    private void printCelss() {
        //● printCells( ) metodu oluşturun //td
//○ table body'sinde bulunan toplam hücre(cell) sayısını bulun.


        List<WebElement> hucreSayisi = driver.findElements(By.xpath("//tbody//tr[*]//td[*]"));
        System.out.println("hucreSayisi: " + hucreSayisi.size());
//○ Table body'sinde bulunan hücreleri(cells) konsolda yazdırın.
        hucreSayisi.stream().map(WebElement::getText).forEach(System.out::println);

    }

    private void printRows() {
        //● printRows( ) metodu oluşturun //tr
//○ table body'sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satır sayısı :" + satirSayisi.size());
//○ Table body'sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.stream().map(WebElement::getText).forEach(System.out::println);
//○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    private void table() {
        //● table( ) metodu oluşturun
// Tüm table body'sinin boyutunu(sutun sayisi) bulun. /tbody
//○ Table'daki tum body'i ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("SutunSayisi :" + sutunSayisi.size());
        //sutunSayisi.stream().map(WebElement::getText).forEach(System.out::println);//tum body baslıgını yazdırır lambda ile
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println(basliklar.getText());

        System.out.println(driver.findElement(By.xpath("//tbody")).getText());//tum body ıcındekı hucrelerı yazdırır


    }

    private void login() {
        //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.navigate().to("https://concorthotel.com/admin/HotelRoomAdmin");
//○ Username : manager ○ Password : Manager2!
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Manager1!", Keys.ENTER).perform();
        /*
        //thead(Baslik)         //tr(Satir)     //th(Sutun)                   Baslik icin
//tbody(Vucut- Ana)     //tr(Satir)      //td (Vucut - Ana Sutunu)     Body icin
         */

    }

}
