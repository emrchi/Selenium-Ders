package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_WebElement_Locator {

    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com/");

        // arama kutusuna "city bike" yazıp aratın
       WebElement aramaMotoru = driver.findElement(By.id("twotabsearchtextbox"));
       aramaMotoru.sendKeys("city bike" , Keys.ENTER);

        // sonuc yazısını yazdırın
        List <WebElement> sonucYazilari = driver.findElements(By.className("sg-col-inner"));
        WebElement sonucYazisi =  sonucYazilari.get(0);
        System.out.println("sonucYazisi = " + sonucYazisi.getText());

        //Xpath ile list kullanmadan tek seferde locate aldık
        WebElement sonucYazisiXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        // sonuc sayısını yazdırın
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);

        //Sayfadaki 12. elementi list kullanmadan xpath'in index özelliğini kullanarak locate aldık
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());

        // ilk ürünün locatini alın
        List<WebElement> urunler = driver.findElements(By.className("s-image"));
        WebElement ilkUrun = urunler.get(0);

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        if(ilkUrun.isDisplayed()){
            System.out.println("ilk Urun Gorunur.");
        }else System.out.println("ilk Urun Gorunmez.");

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        if(ilkUrun.isEnabled()){
            System.out.println("ilk Urun Erisilebilir.");
        }else System.out.println("ilk Urun Erisilemez.");

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        if(ilkUrun.isSelected()){
            System.out.println("ilk Urun Secilebilir.");
        }else System.out.println("ilk Urun Secilemez.");

        // ilk urune tıklayın
        ilkUrun.click();

        // sayfayı kapatın
        driver.quit();
    }
}
