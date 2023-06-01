package techproed.day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Browser'in konumunu yazdiralim
        System.out.println("Sayfanin Konumu : " + driver.manage().window().getPosition());

        //Browser'in boyutlarini yazdiralim yazdiralim
        System.out.println("Sayfanin Boyutu : " + driver.manage().window().getSize());

        //Browser'i maximize yapalim
        driver.manage().window().maximize();

         /*
        Bir web sitesine gittiginizde browser default olarak bir boyutta gelir. Ve acilan browser'daki
        webElementlere browser maximize olmadigi icin ulasamayabiliriz.Dolayisiyla browser'i actiktan sonra
        maximize yaparsak driver butun webElementleri gorur ve rahatlikla mudehale edebilir. Bu yuzden
        browser'i aciktan sonra ilk olarak  driver.manage().window().maximize(); yapmamiz bizim webelementlere
        ulasmada isimizi kolaylastirir. Boylelikle fail almamis oluruz.
         */

        //Techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");

        //Browser'in konumunu yazdiralim
        System.out.println("Sayfanin Konumu : " + driver.manage().window().getPosition());

        //Browser'in boyutlarini yazdiralim yazdiralim
        System.out.println("Sayfanin Boyutu : " + driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi minimize yapalim
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //Sayfayi fullscreen yapalim
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        driver.manage().window().setPosition(new Point(50,50)); // istedigimiz konuma getirir

        driver.manage().window().setSize(new Dimension(600,600)); // istedigimiz size

        Thread.sleep(3000);

        //Sayfayi kapatalim
        driver.close();

    }
}
