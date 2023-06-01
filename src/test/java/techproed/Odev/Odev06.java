package techproed.Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev06 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    //Yeni bir class olusturun (TekrarTesti)
    //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        if(driver.getTitle().equals("youtube")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed Actual Title is " + driver.getTitle());

    //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        if(driver.getCurrentUrl().contains("youtube")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed Actual Url is  " + driver.getCurrentUrl());
        Thread.sleep(2000);

    //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

    //Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);

    //Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);

    //Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);

    //Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

    //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        if(driver.getTitle().contains("Amazon")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed Actual Title is " + driver.getTitle());
        Thread.sleep(2000);

    //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        if(driver.getCurrentUrl().equals("https://www.amazon.com/")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed Actual Url is  " + driver.getCurrentUrl());
        Thread.sleep(2000);

    //Sayfayi kapatin
        driver.close();

    }
}
