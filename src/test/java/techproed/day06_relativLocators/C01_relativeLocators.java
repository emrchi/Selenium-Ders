package techproed.day06_relativLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_relativeLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //City bike aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altindaki elemente tiklayalim
        //WebElementlerin yazisini konsola yazdiralim
        WebElement hybridBikes = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBikes.getText());
        WebElement electricBikes = driver.findElement(with(By.tagName("a")).below(hybridBikes));
        System.out.println(electricBikes.getText());
        WebElement completeBikes = driver.findElement(with(By.tagName("a")).below(electricBikes));
        System.out.println(completeBikes.getText());

        System.out.println("*******************************************************");


        //Bikes altindaki tum linkleri(webelement) konsola yazdiralim
        List<WebElement> linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));

        /*
            XPATH kullanımında bir sayfadaki webelementlere müdehale etmek istediğimizde xpath ile locate aldığımızda birden fazla sonuc
        verebilir. [position()>=10 and position()<=16] bu kullanımla aralık belirterek isteğimiz WE leri seçip müdehale edebiliriz.
         */

        //lambda ile
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        //foreach ile
        for (WebElement w: linklerListesi) {
            System.out.println(w.getText());
        }

        //Bu linklerin hepsini tıklayalım ve sayfa başlıklarını alalım
        for (int i = 0; i < linklerListesi.size(); i++) {
            linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));
            System.out.println(linklerListesi.get(i).getText());
            linklerListesi.get(i).click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);

        }
        driver.close();

    }
}
