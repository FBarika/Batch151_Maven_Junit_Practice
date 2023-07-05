package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        /*
        iframe gecmenin 3 yolu var biri html kodlarinda name veya id atribütü varsa, web elemnt locatini yazarak ve iframe in indexini yazarak gecebiliriz.
        //iframe yazdigimizda mesela 2 tane cikti --> driver.switchTo().frame(0); yazarak birinci olan iframe aliyoruz.
        */

        WebElement playTusu = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();
        bekle(3);
        /*
        play'i dogru locate edip click yapmamiza ragmen video 'yu ilk etapta calistirmadi.Bunun üzerine HTML kodlarini inceleyince play in aslinda bir
        iframe icinde oldugunu gördük.Bu durumda önce iframe locate edip sonra switchTo ile iframe gecmeliyiz.
        */

        // videoyu durdurunuz
        WebElement videoDurdur = driver.findElement(By.id("movie_player"));
        videoDurdur.click();
        bekle(3);

        // videoyu tam ekran yapınız
        WebElement videoTamEkran = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        videoTamEkran.click();
        bekle(2);

        // videoyu calıstırınız
        videoDurdur.click(); //video yu durdurdugumuz yerden calistirabiliyoruz da
        bekle(2);

        // videoyu kucultunuz
        videoTamEkran.click();
        bekle(2);

        // videoyu durdurunuz
        videoDurdur.click();
        bekle(2);

        // Videoyu calistirdiginizi test ediniz

        /*
        ne zaman videoyu calistirsak kösede youtube yazisi cikiyor bu yüzden o yazinin görünürlügünü test ediyoruz.
         */
        WebElement youtubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement yazi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yazi.isDisplayed());
    }


}
