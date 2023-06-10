package techproed.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev10 {

    // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
    // Add Element butonuna 100 defa basınız
    // 100 defa basıldığını test ediniz
    // 90 defa delete butonuna basınız
    // 90 defa basıldığını doğrulayınız
    // Sayfayı kapatınız

    public static void main(String[] args) {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButton = driver.findElement(By.xpath("//button"));
        for (int i = 0; i < 100; i++) {
            addButton.click();

        }

        // 100 defa basıldığını test ediniz
        List<WebElement> listOfdeleteButton = driver.findElements(By.xpath("//*[@class='added-manually']"));
        if(listOfdeleteButton.size()== 100){
            System.out.println("Add butonuna 100 kere basilmistir.");
        }else System.out.println("Test Failed.");

        // 90 defa delete butonuna basınız

        for (int i = 0; i < 90; i++) {
            WebElement deleteButton01 = driver.findElement(By.xpath("//*[@class='added-manually'][1]"));
            deleteButton01.click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> listOfdeleteButton2 = driver.findElements(By.xpath("//*[@class='added-manually']"));
        if(listOfdeleteButton2.size()==10){
            System.out.println("Delete butonuna 90 kere basilmistir.");
        }else System.out.println("Test Failed.");

        // Sayfayı kapatınız
        driver.close();

    }

}