package techproed.Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev02 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Yeni bir Class olusturalim.C05_NavigationMethods
        //Youtube ana sayfasina gidelim .https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        Thread.sleep(5000);

        //Amazon soyfasina gidelim.https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);

        //Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        Thread.sleep(5000);

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(5000);

        //Sayfayi Refresh (yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(5000);

        //Sayfayi kapatalim /Tum sayfalari kapatalim
        driver.close();
        driver.quit();
    }
}
