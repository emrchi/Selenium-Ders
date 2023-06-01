package techproed.Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev03 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1.Yeni bir Class olusturalim.C06_ManageWindow
        //2.Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        //3.Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Amazon sayfasi konumu: " + driver.manage().window().getPosition());
        System.out.println("Amazon sayfasi boyutlari: " + driver.manage().window().getSize());

        //4.Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5.simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6.Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Amazon sayfasi konumu: " + driver.manage().window().getPosition());
        System.out.println("Amazon sayfasi boyutlari: " + driver.manage().window().getSize());

        //7.Sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        //8.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Amazon sayfasi konumu: " + driver.manage().window().getPosition());
        System.out.println("Amazon sayfasi boyutlari: " + driver.manage().window().getSize());

        //9.Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
