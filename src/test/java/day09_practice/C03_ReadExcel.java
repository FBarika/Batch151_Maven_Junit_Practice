package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C03_ReadExcel {

    //Ulkeler dosyasindaki tum datalari Map'e aliniz ve yazdiriniz

    // Ulkeler dosyasindaki tüm verileri koyabilecegim en uzun Java objesi Map tir.

    @Test
    public void test01() throws IOException {
        Map<String,String> ulkeler = new HashMap<>();
        String dosyaYolu ="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum(); son satir numarasini index olarak verir.

        for (int i = 0; i <= sonSatirIndex; i++) {
           String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
           String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() +","
                   +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","
                   +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
           ulkeler.put(key,value);
        }
        System.out.println(ulkeler);

        /*
        Baska Cözüm;

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent = new LinkedHashMap<>();
        int row = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        for (int i = 1; i < row ; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = "";
            for (int j = 1; j < 4 ; j++) {
                value = value + workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString() + "|";
            }
            ulkeBaskent.put(key,value);
        }
        System.out.println(ulkeBaskent);
         */

    }



}
