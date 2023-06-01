package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getTagName_getAttributeName {

    public static void main(String[] args) {

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- amazon.com'a gidip arama kutusunu locate edin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // 2- arama kutusunun tagName'inin input oldugunu test edin
        String actualTagName = aramaKutusu.getTagName();
        System.out.println(actualTagName);
        String expectedTagName = "input";
        if(actualTagName.equals(expectedTagName)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed -->" + actualTagName);

        // 3- arama kutusunun name attribute'nun degerinin field-keywords oldugunu test edin
        String actualName = aramaKutusu.getAttribute("name");
        System.out.println(actualName);
        String expectedName = "field-keywords";
        if(actualName.equals(expectedName)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed -->" + actualName);

        // 4- sayfayı kapatınız
        driver.close();
    }


}
