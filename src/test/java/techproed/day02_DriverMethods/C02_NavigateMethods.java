package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Techproeducation sayfasina gidelim
        driver.navigate().to("https://techproeducation.com");   //get() methodu ile ayni mantikta calisir.
        Thread.sleep(3000);                                   //Java code'larini bekletmek icin.

        //Sonra Amozon sayfasina gidelim
        driver.get("https://amazon.com");
        Thread.sleep(3000);

        //Amazon sayfasinin basligini yazdiralim
        System.out.println("Amazon sayfa basligi : " + driver.getTitle());

        //Techproeducation sayfasina geri donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa basligini yazdiralim
        System.out.println("Techproedu sayfa basligi: " + driver.getTitle());

        //Amazon sayfasina tekrar gidip Url'i yazdiralim
        driver.navigate().forward();
        System.out.println("Amazon sayfasi Url'i: " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amazon sayfasindayken sayfayi yenileyelim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim
        driver.close();

    }
}
