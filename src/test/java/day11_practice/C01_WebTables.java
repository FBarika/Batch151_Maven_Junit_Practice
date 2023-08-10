package day11_practice;

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

        girisYap();
        //Email basligindaki tüm elementleri(sütun) yazdirin
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if(basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSütunListesi = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));

        for (WebElement w:emailSütunListesi) {
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
