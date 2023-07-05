package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {


    @Test
    public void test01() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);


        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("Oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        bekle(2);
        //String ikiciSayfaHandle =driver.getWindowHandle();
        //System.out.println("ikiciSayfaHandle = " + ikiciSayfaHandle);
        //driver hala ilk sayfada bunu anliyorum

        Set<String> windowHandleSeti= driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String sayfa2Handle="";
        for (String w:windowHandleSeti) {
            if(!w.equals(ilkSayfaHandle)){
                sayfa2Handle=w;
            }
        }
        System.out.println("sayfa2Handle = " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);// elde ettigimiz ikinci sayfanin handle degeri ile driver i ikinci sayfaya gecirdik.

        /*
        lambda ile cözümü
        Set<String> handles=driver.getWindowHandles();
        handles.stream().filter(t-> !t.equals(sayfa1)).forEach(t->driver.switchTo().window(t));
         */

        // ikinci sayfa title nin "Türkiye" icerdigini test edin
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));
        bekle(2);

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaTitle = driver.getTitle();
        System.out.println("ilkSayfaTitle = " + ilkSayfaTitle);

    }
}
