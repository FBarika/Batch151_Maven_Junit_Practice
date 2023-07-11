package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files  {
    @Test
    public void test01() {
        // masaustunde bir text dosyası olusturunuz

        // masaustunde text dosyasının olup olmadıgını test ediniz

        //"C:\Users\Barika\Desktop\Batch151.txt"

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Barika\\Desktop\\Batch151.txt")));//--< bu dinamik degil.

        //Dinamik hale getirelim.
        //"C:\Users\Barika           \Desktop\Batch151.txt"
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\Batch151.txt";
        String dosyaYolu = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        //Bilgisayarimizda masaüstünde dosyanin olup olmadigini test edebilmek icin Selenium la bir isimiz yok Sadece Java ile bunu test ediyoruz.
        //Bu yüzden extends etmedik.
    }
}
