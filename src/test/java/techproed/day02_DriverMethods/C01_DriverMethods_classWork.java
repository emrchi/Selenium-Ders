package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods_classWork {

    public static void main(String[] args) {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Amozon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Sayfa basliginin Amazon icerdigini test edelim
        String acutalTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        if (acutalTitle.contains(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        //Url'in https://www.amazon.com oldugunu test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed" + " -> " + actualUrl);
        }
        //Sayfayi kapatalim
        driver.close();   //Browser'i kapatir.
        //driver.quit(); Birden fazla browser varsa hepsini kapatir.



    }
}
