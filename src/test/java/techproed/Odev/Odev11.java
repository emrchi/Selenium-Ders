package techproed.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev11 {

//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4.- Sayfayi “refresh” yapin
//5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
//6. Gift Cards sekmesine basin
//7. Birthday butonuna basin
//8. Best Seller bolumunden ilk urunu tiklayin
//9. Gift card details’den 25 $’i secin
//10-Urun ucretinin 25$ oldugunu test edin
//10-Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        driver.manage().window().fullscreen();

        driver.navigate().refresh();

       // driver.manage().window().maximize();

        if(driver.getTitle().contains("Spend less")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + driver.getTitle());

        driver.findElement(By.xpath("//*[@class='nav-a  '][4]")).click();
        Thread.sleep(2000);






    }

}
