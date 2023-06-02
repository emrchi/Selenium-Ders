package techproed.day05_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_relativeLocators {

    public static void main(String[] args) {
        /*
        Benzer ozelliklere sahip webelementler icin relative locator kullanabiliriz.
        SYNTAX:
        driver.findElement(with(By.tagName).below().above().to_left_of().to_right_of().near())

        gibi methodlar ile Benzer ozelliklere sahip webelementleri locate'ini almadan o webElement'e ulasabiliriz.
         */

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
        WebElement hybridBikes = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        WebElement electricBikes = driver.findElement(with(By.tagName("a")).below(hybridBikes));
        hybridBikes.click();

        //Bu Ayda Hanim Icin Yapila
    }

}
