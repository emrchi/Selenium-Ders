package techproed.Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev05 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    //Yeni bir class olusturalim (Homework)
    //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        if (driver.getTitle().equals("facebook")){
            System.out.println("verify");
        }else System.out.println("Actual Title :  " + driver.getTitle());

    //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains("facebook")){
            System.out.println("Test Passed");
        }else System.out.println("Actual URL : " + actualUrl);
        Thread.sleep(3000);

    //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

    //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("verify");
        }else System.out.println("Actual Title :  " + driver.getTitle());
        Thread.sleep(2000);

    //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(2000);

    //Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);

    //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);

    // Browser’i kapatin
        driver.close();
    }
}
