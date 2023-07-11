package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        } //cookies cikarsa handle et cikmazsa yoluna devam etmesi icin try catch icine aldik.

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//*[@id='search-input']")).sendKeys("oppo", Keys.ENTER);

        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi =driver.findElement(By.xpath("//*[@class='plp-panel-block1']"));
        System.out.println(sonucYazisi.getText());

        // ilk urunun fotografını cekin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class=' prd-link '])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE) , new File("target/ekranGoruntusu/urun.Jpeg" + tarih + ".png"));
    }
}
