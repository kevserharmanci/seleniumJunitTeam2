package day04;

public class notlar {

    /*
*find elements(By.....locator)-->istedigimiz web elementi bize dondurur.
Bizde o web elementi kullanmak icin bir objeye assign ederiz

*herhangi bir web elementine istedigimiz yaziyi gondermek icin sensKeys() methodu kullanilir
enter yapmak icin yazmak istedigimizden sonra + koyup Keys.ENTER yazariz

*Locator alırken gozumuzden kacan seyler olabilir
aldigimiz locater calısmaz ıse baska alternatifler denemeliyiz

*web elementin html kodunu kopyalamak ıcın webelement uzerıne gıdıp sag clıck yapip copy-->copy element secıp,
intellijde yorum olarak kopyalayarak icinde neler varmıs daha rahat bakabılırız

*bir webelementin uzerinde ne  yazdigini gormek  icin get.text() kullanırız dırek yazdırırsak referans verir

*bir web elementinin olup olmadıgını bulmak icin is.display() methodu kullanılır boolean dondurur(gorunurmu demek)

*webelementdeki link sayısını bulmak ıcın fındelements() kullanılıp lıste atanır ve listin size() i alınarak kac adet oldugu bulunur
bunları yazdırmak icin for each ile yadırırız ve gettext() kullanırız sout ıcınde each.gettext()

*webElementIsmi.getTagName()==>daha once locat ettıgımız tagname'ini dondurur
webElemenIsmi.getAttribute("attrıbute ısmı")==>daha once locat ettıgımız attribute ismi'ni dondurur


     */
    public static void main(String[] args) {

    }

    /*driver.get("https://www.youtube.com/"); // www yazmasak da olur
        System.out.println("Actual Title : "+driver.getTitle()); // gidilen sitenin basligini yazdirir
        System.out.println("Actual url : "+driver.getCurrentUrl()); // gidilen sayfanin url'sini getirir
        driver.manage().window().maximize(); // sayfayi tam ekran yapar
    //System.out.println(driver.getPageSource()); // Sayfadaki kaynak kodalarini verir
        driver.close(); // Acilan web sayfasini kapatir
    // driver.quit(); birden fazla acilan sekme varsa hepsini kapatir
    // Farkli pencereler arasinda gezinebilmek icin getWindowHandle () methodunu kullaniriz
    // driver.navigate().to() methodu sayfada ileri geri yapacaksak kullanilir
    // driver.get() methodu gibi bizi istedigimiz url'e goturur
        Thread.sleep(3000); // islemler arasi 3 saniye bekle dedik
    getPosition());// acilann browser'in konumunu verir
    getSize()); // acilan browser'in olculerini verir
    minimize();// pencereyi simge durumuna getirir
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// bununla sayfa acilmazsa 15 sn bekle hata rraporu ver demek
    // ve intellij hata verir. Acilirsa da beklemeden yoluna devam et
    //WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));// buraya yazacagimiz locat'in unique olmasi lazim.
    // bunu da html kodlari icerisinde id'yi secip ctrl+c sonra ctrl+f ile unique olup olmadigini anlayabiliriz
    //id'yi kullanmak ilk onceligimiz olmali
    //aramaKutusu.sendKeys("Nutella"+ Keys.ENTER); "Nutella"+ Keys.ENTER  ayrica -->  "Nutella", Keys.ENTER olarak da kullanilabilir
    //driver.findElement(By.linkText("Amazon'da Satış Yapın")).click(); // --> burda hata aldim cunku site tr siteyi usa olarak duzeltirsek problem kalkiyor
    //  driver.findElement(By.partialLinkText("mazon'da Satış Yapın")).click(); bu yontemle: aradigimiz metnin bir kismini yazmamiz yeterlidir
        .getText()); // bir web elementin uzerindeki yaziyi konsolda yazdirabilmek icin getText() methodu kullanilir
    // getText() olmazsa hash cod yazdirir
        (By.xpath("//*[@class='added-manually']"));
    // By.xpath("//h3") bu sekilde de yapabiliriz
    // NOT :
    //  eger attribute'u xpath haline getirdikten sonra da hala unique olmadiysa ("//*[@class='added-manually']")[1] bu sekilde 1. al diyebiliriz
    // Locate alirken sadece text kullanacaksak //*[text()='Add Element']" bu formattadir.
    // Attribute olani yapacaksak //*[@class='added-manually'] bu formati kullanabiliriz.
    // cssSelector'de id icin # isareti ; class icin ise . isareti kullanilir
    // NOT
    //Relative Locators'da :
    // with'den sonra tagname deme sebebimiz hepsinin tagname'i img olmasi.
    // ancak tagname ortak olmasa burada onemli husus, varis noktamizin tagname'i referans alinmali*/

}
