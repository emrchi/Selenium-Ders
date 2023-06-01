package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {

    public static void main(String[] args) {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
           implicitlyWait(Duration.ofSeconds(20)) Sayfadaki webElementleri görünür olana kadar(sayfada oluşana kadar)
         maximum 20 saniye bekler. Eğer webelementler 2 saniyede oluşursa 2 saniye bekler ve alt satıra geçer. Fakat
         belirttiğimiz max. süre boyunca internetten yada sayfadan kaynaklı olarak webelementler oluşmazsa testtimiz
         fail verir.
           Thread.sleep() java kodlarını bizim belirttiğimiz süre kadar bekler. 30 saniye beklemesini belirtirsem
         30 saniye bekler ve alt satıra geçer.
         */

        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Techproeducation sayfasina geri donelim
        driver.navigate().back();

        //Sayfa basliginin techpro icerdigini test edelim
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("techpro")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed --> " + actualTitle);
        }

        //Tekrar amazon sayfasina gidelim
        driver.navigate().forward();

        //Sayfa basliginin Amazon icerdigini test edelim
        String actualTitle2 = driver.getTitle();
        if (actualTitle2.contains("Amazon")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed --> " + actualTitle2);

        //Sayfayi kapatiniz
        driver.close();




    }
}
