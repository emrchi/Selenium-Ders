package techproed.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev07 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratınız
        WebElement aramakutusu = driver.findElement(By.name("field-keywords"));
        aramakutusu.sendKeys("iphone");
        Thread.sleep(1000);
        aramakutusu.submit();

        //çıkan sonuç yazısını konsola yazdırınız
        List<WebElement> results = driver.findElements(By.className("sg-col-inner"));
        WebElement result = results.get(0);
        System.out.println(result.getText());

        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız.
        //List<WebElement> products = driver.findElements(By.className("s-image"));

        for (int i = 0; i < 5; i++) {
            driver.findElements(By.className("s-image")).get(i).click();
            System.out.println("Product " + (i + 1) +  "Title: " + driver.getTitle());
            Thread.sleep(500);
            driver.navigate().back();

        }
        driver.close();

    }
}
