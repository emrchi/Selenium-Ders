package techproed.day01_ilkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {

    public static void main(String[] args) {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("google.com sayfa basligi: " + driver.getTitle());
        driver.get("https://www.amazon.com");
        System.out.println("Amazon.com sayfa basligi : " + driver.getTitle());
        //getTitle() methodu son getirilen sayfanin basligini verir.
        System.out.println("amazon Url : " + driver.getCurrentUrl());
        //getCurrentUrl() methodu son gidilen sayfanin Url'sini verir.
        //driver.getPageSource();
        //getPageSource() methodu icinde olunan sayfanin kaynak code'larini String olarak getirir.
        System.out.println("WindowHandle degeri: " + driver.getWindowHandle());
        //getWindowHandle() methodu icinde olunan sayfanin ve/veya tab'larin handel degerlerini getirir.
        //Bu handel degerini sayfalar arasi gecis icin kullaniriz.
    }
}
