package techproed.Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev01 {

    public static void main(String[] args) {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    //Amazon sayfasina gidelim. https://www.amazon.com/
    driver.get("https://www.amazon.com/");

    //Sayfa basligini(title) yazdirin
        System.out.println("Amazon sayfa basligi: " + driver.getTitle());

    //Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("Amazon")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + actualTitle);

    //Sayfa adresini(url) yazdirin
        System.out.println("Amazon sayfa url'si: " + driver.getCurrentUrl());

    //Sayfa adresinin “https://www.amazon.com/” icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + actualUrl);

    //Sayfa url’inin “amazon” icerdigini test edin.
        if(actualUrl.contains("amazon")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + actualUrl);

    //Sayfa handle degerini yazdirin
        System.out.println("Amazon sayfa handle degeri: " + driver.getWindowHandle());


    //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        if(driver.getPageSource().contains("Gateway")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

    //Sayfayi kapatin.
        driver.close();



    }
}
