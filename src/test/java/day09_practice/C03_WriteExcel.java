package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki 0. satır index'in, 4.hücre index'ine yeni bir cell olusturalım.
        // olusturdugumuz hücreye "Nufus" yazdıralım.

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //ulkeler dosyasini bizim sistemimize getirdik.
        Workbook workbook = WorkbookFactory.create(fis);
        //dosyayi workbook a atadik.
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //1. satir index'in 4. hucre index'ine yeni bir cell olusturun, olusturdugunuz hucreye "15000" yazdirin
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("15000");
        //2. satir index'in 4. hucre index'ine yeni bir cell olusturun, olusturdugunuz hucreye "25000" yazdirin
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(25000); //int olarak da yazabiliriz
        //Exceldeki dataya String deger verirsek sola yasli olarak, int deger verirsek saga yasli olarak gorunuyor
        //workbook ta yaptigimiz bu degisikligi excel dosyasina atmamiz lazim.Bunun icin FileInputStream objesi olusturuyoruz.
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

    }


















}
