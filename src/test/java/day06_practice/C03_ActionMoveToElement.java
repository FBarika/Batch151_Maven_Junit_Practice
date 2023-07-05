package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement dilMenü = driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilMenü).perform();
        bekle(2);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]")).click();
        bekle(2);
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);
        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();
        /*
        dropdomn opsiyon listesi 'Go to Website' butonuna basmamiza engel oldugu icin
        herhangi bir yere click yapip dropdown option listesinin toparlanmasini sagladik.
         */
        // dropdown u geri toparlamak icin herhangi bir yere tiklamak icin herhangi bir yerin locate ni aldik.

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click(); // 'go to Website' butonuna tilayinca otomatik sekme acildi

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> tümHandle = driver.getWindowHandles();
        String ikinciSayfaHandle ="";
        for (String w:tümHandle) {
            if(!w.equals(ilkSayfaHandle)){
                ikinciSayfaHandle = w;
            }
        }
        System.out.println("ikinciSayfaHandle = " + ikinciSayfaHandle);
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);

        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));

    }
}
