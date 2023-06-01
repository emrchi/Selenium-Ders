package techproed.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev08 {

    /*
    //Techproeducation sayfasına gidelim
    //Çıkan reklamı locate edip kapatalım
    //Arama bölümünde qa aratalım
    //Sayfa başlığının qa içerdiğini doğrulayalım
    //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
    //Carrer Opportunities In QA linkine tıklayalım
    //Başlığın Opportunities içerdiğini test edelim
    //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı locate edip kapatalım
        WebElement reklamKapama = driver.findElement(By.xpath("(//*[@class='eicon-close'])"));
        Thread.sleep(2000);
        reklamKapama.click();

        //Arama bölümünde qa aratalım
        WebElement aramacubugu = driver.findElement(By.xpath("//*[@id ='elementor-search-form-9f26725']"));
        aramacubugu.sendKeys("qa",  Keys.ENTER);
        Thread.sleep(2000);

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String sayfabasligi = driver.getTitle();
        if (sayfabasligi.contains("qa")) {
            System.out.println("Sayfa başlığı qa içermektedir");
        }else System.out.println("Sayfa başlığı qa içermemektedir --> " + sayfabasligi);

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement carreerLink = driver.findElement(By.xpath("(//h3//a)[1]"));
        if(carreerLink.isDisplayed()){
            System.out.println("Link is displayed");
        }else System.out.println("Link is not displayed");

        if(carreerLink.isEnabled()) {
            System.out.println("Link is enabled");
        }else System.out.println("Link is not enabled");

        //Carrer Opportunities In QA linkine tıklayalım
        carreerLink.click();
        Thread.sleep(2000);

        //Başlığın Opportunities içerdiğini test edelim
        if(driver.getTitle().contains("Opportunities")){
            System.out.println("Başlık Opportunities içeriyor");
        }else System.out.println("Baslik Opportunities içermiyor --> " + driver.getTitle());

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.get("https://techproeducation.com");
        if(driver.getCurrentUrl().equals("https://techproeducation.com/")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.close();

    }


}
