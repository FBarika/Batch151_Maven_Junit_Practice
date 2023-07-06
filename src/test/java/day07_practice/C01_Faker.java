package day07_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test01() {

        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//button)[13]")).click();

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


        // isim kutusunu locate ediniz
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));








        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun


        Faker faker = new Faker();

        String email = faker.internet().emailAddress();// faker email i ikinci kez farkli bir email sececeginden burada assaign ettik asagida iki kez ayni girebilmek icin.

        Actions actions = new Actions(driver);

        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("Apr").sendKeys(Keys.TAB).
                sendKeys("15").sendKeys(Keys.TAB).
                sendKeys("2020").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


    }
}
