package techproed.day05_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_xpath {

        /*
        //ARAMA KUTUSUNUN HTML KODLARI
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
         placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
         tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */

    //Relative Xpath syntax -->                 //tagname[@attributeName='attributeValue']

                                                //input[@type='text']
    // unique elde edemediysek index kullan    (//input[@type='text'])[1]
    // * kullanarakta yapabiliriz               //*[@type='text']

        /*
        Aldigimiz xpath unique olmadigi zaman xpath' imizi parantez icine alarak index belirtebiliriz.
        Boylelikle webelementi List' e atip istedigimiz elementi almakla ugrasmayiz
         */

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","src/resources/drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com/");

        // arama kutusuna "city bike"  yazıp aratın

        /*
             Arama kutusu HTML codes
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
        tabindex="0" aria-label="Search Amazon" spellcheck="false">

        1) WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        2) WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        3) WebElement aramaKutusu = driver.findElement(By.xpath("//input[@autocomplete='off']"));
        4) WebElement aramaKutusu = driver.findElement(By.xpath("(//input[@class = 'nav-input nav-progressive-attribute'])[1]"));
        */
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();  //*[.='Hybrid Bikes'] da kullanilabilir

        // sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[0]);

        // ilk ürününe tıklayın
        driver.findElement(By.xpath("(//h2)[1]")).click();

        // Sayfayı kapatınız
        driver.close();

    }




}
