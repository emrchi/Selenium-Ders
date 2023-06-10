package techproed.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev09 {

    //https://id.heroku.com/login sayfasina gidin
    //Bir mail adersi giriniz
    //Bir password giriniz
    //Login butonuna tiklayiniz
    //"There was a problem with your login." texti gorunur ise
    //"kayit yapilamadi" yazdiriniz
    //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    //sayfayı kapatiniz


    public static void main(String[] args) {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        //Bir mail adresi giriniz
        WebElement adresBox = driver.findElement(By.xpath("//*[@class='form-control']"));
        adresBox.sendKeys("emre_ylmz@hotmail.com");

        //Bir password giriniz
        WebElement passwordBox = driver.findElement(By.xpath("//*[@name='password']"));
        passwordBox.sendKeys("Abcde@1234");

        //Login butonuna tiklayiniz
        WebElement loginBox = driver.findElement(By.name("commit"));
        loginBox.click();

        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        WebElement problemBox = driver.findElement(By.xpath("//div"));
        if(problemBox.isDisplayed()){
            System.out.println("kayit yapilamadi");
        }else System.out.println("kayit yapildi");

        //sayfayı kapatiniz
        driver.close();

    }

}
