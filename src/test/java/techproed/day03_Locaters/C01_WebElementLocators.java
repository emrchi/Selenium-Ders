package techproed.day03_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElementLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //Arama kutusunu Locate edelim
        WebElement aramakutusu = driver.findElement(By.name("field-keywords"));

        /*
        Bir webelementin locate'ini birden fazla kullanacaksanız bir Webelement'e değişken olarak atayabilirsiniz.
        Webelement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        Locate işlemi bittikten sonra
        1-Webelemente bir metin göndereceksek sendKeys() methodu kullanırız.
        2-Webelement'e tıklayacaksak click() methodu kullanırız
        3-Webelement'in üzerindeki yazıyı almak istiyorsak getText()methodunu kullanırız.
        4-sendKeys() methodundan sonra(yani webElemente metin gönderdikten sonra) Keys.ENTER ile yada
        submit() methodu ile manuel olarak enter yaptığımız gibi otomasyonda da yapabiliriz.
        */

        //Arama kutusuna iphone yazdiralim ve aratalim
        //1. yol
        //aramakutusu.sendKeys("iphone", Keys.ENTER);

        //2.yol
        //WebElement buyutec = driver.findElement(By.id("nav-search-submit-button"));
        //aramakutusu.sendKeys("iphone");
        //buyutec.click();

        //3.yol
        aramakutusu.sendKeys("iphone");
        Thread.sleep(1000);
        aramakutusu.submit();

        //Sayfayi kapatalim
        driver.close();
    }
}
