package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {


    @Test
    public void test01() {
        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();

        // sutun sayısını yazdırın
        List<WebElement> sütunbasliklarininListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sütun Sayisi: " + sütunbasliklarininListesi.size());

        System.out.println("************************************************************");

        // tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));//tüm body tek bir element olarak aldigi icin tek bir webelemente assaign ettik.
        System.out.println(tumBody.getText());

        // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi: " + satirlarListesi.size());

        System.out.println("***************************************************************");
        // body'de bulunan satırları yazdırın
        for (WebElement w:satirlarListesi) {
            System.out.println(w.getText());
        }

        System.out.println("***************************************************************");

        // 4.satırdaki elementleri yazdırın
        List<WebElement> dorduncuSatirElementleri = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        System.out.println(dorduncuSatirElementleri.size());
        for (WebElement w:dorduncuSatirElementleri) {
            System.out.println(w.getText());
        }

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();//advanced yazan yere tikliyoruz.
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();//güvenli degil yazan yere tikladik.
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();//login kismina click yaptik

        Actions actions =new Actions(driver);
       WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
       actions.
               click(userName).
               sendKeys("manager").
               sendKeys(Keys.TAB).
               sendKeys("Manager1!").
               sendKeys(Keys.ENTER).perform();



    }
}
