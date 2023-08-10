package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_WebTables extends TestBase {


    @Test
    public void test01() {
        girisYap();
        //Input olarak verilen satir sayisi ve sütun saysina sahip cell'deki text'i dinamik olarak yazdiriniz.
        int satir =3;
        int sütun=3;
        WebElement arananCell= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sütun+"]"));
        System.out.println(arananCell.getText());


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
