package techproed.Odev;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class odev04 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Yeni bir Class olusturalim.C07_ManageWindowSet
        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Amazon sayfasi konumu: " + driver.manage().window().getPosition());
        System.out.println("Amazon sayfasi boyutu: " + driver.manage().window().getSize());

        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(12,12));
        driver.manage().window().setSize(new Dimension(1000,500));
        Thread.sleep(3000);

        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Point actualPosition = driver.manage().window().getPosition();
        Point expectedPosition = new Point(12,12);
        if(actualPosition.equals(expectedPosition)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + actualPosition);
        Dimension actualDimention = driver.manage().window().getSize();
        Dimension expectedDimention = new Dimension(1000,500);
        if(Objects.equals(actualDimention, expectedDimention)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + actualDimention);

        //Sayfayi kapatin
        driver.close();

    }
}
