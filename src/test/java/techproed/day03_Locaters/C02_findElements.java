package techproed.day03_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {

    public static void main(String[] args) {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Sayfadaki linklerin sayisini ve linkleri yazdiralim

        /*
        findelement ile bir webelemente ulaşabilirken, birden fazla webelement için findelements() methodunu kullanırız.
        Bu webelementlerin sayısına ulaşmak için ya da bu web elementlerin yazısını konsola yazdırabilmek için
        List<Webelement> linklerLlistesi=driver.findelements(By.locator("locator değeri")) olarak kullanırız.
        Oluşturmuş olduğumuz List'i loop ile konsola yazdırabiliriz
        Webelement'in üzerindeki yazıyı almak istiyorsak getText() methodunu kullanırız.
         */

        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = " + linklerListesi.size());

        /*
        for (WebElement w : linklerListesi) {
            if (!w.getText().isEmpty()) {                     //Burada isempty ile uzerinde yazi olmayan linkleri listelemedik.
                System.out.println(w.getText());
            }
        }
        */

        //Lambda ile yapalim
        linklerListesi.forEach(w -> {if (!w.getText().isEmpty()) System.out.println(w.getText());});

        //Shop deals in Electronics WebElementinin uzerindeki yazisini alip yazdiralim. getTExt() methodu
        System.out.println("*****************************************************");
        System.out.println(driver.findElement(By.linkText("Shop deals in Electronics")).getText());


        driver.close();
    }
}
