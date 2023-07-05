package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test01() {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");


        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
        bekle(2);

        WebElement tasinacakElement = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedefElement = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,hedefElement).perform();
        // dragAndDrop() ==> sürükle bırak






        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actuelYazi = dropped.getText();

        String expectedYazi = "Dropped!";

        Assert.assertEquals(expectedYazi,actuelYazi);

    }



}
