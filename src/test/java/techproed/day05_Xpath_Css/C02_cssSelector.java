package techproed.day05_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {

    public static void main(String[] args) throws InterruptedException {

        /*
    cssSelector ile xpath arasındaki farklar;
    1- cssSelector de @ işareti ve // işaretleri kullanılmaz
    2- xpath ile index alabiliriz ama cssSelector ile index alamayız
    3- xpath ile text olarak locate edebiliriz ama cssSelector ile bunu yapamayız
    4- cssSelector xpath'e göre daha hızlı çalışır
        */


        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        // Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick ='addElement()']")).click();
        Thread.sleep(2000);

        // Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete Button is Displayed");
        }else System.out.println("Delete Button is not Displayed");

        // Delete tusuna basin
        deleteButton.click();
        Thread.sleep(2000);

        // “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemove = driver.findElement(By.cssSelector("h3"));
        if(addRemove.isDisplayed()){
            System.out.println("Add/Remove Elements is Displayed");
        }else System.out.println("Add/Remove Elements is not Displayed");

        driver.close();


    }

}
