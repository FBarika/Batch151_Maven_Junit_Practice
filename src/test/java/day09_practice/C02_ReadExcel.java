package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {


    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.
        String dosyaYolu ="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        //Son satir numarasini getLastRowNum() methodu ile buluruz.Int döndürür.Excel de normalde 191 satir ve ama getLastRowNum() son satir numarasini index olarak verir.
        int sonSatirIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("sonSatirIdx = " + sonSatirIdx);//sonSatirIdx = 190
        for (int i = 0; i <=sonSatirIdx ; i++) {
            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);
            //banaDataGetir() methodu static olmasaydi biz obje olusturup kullanacaktik.obje ismi ile methodu cagirabilirdik.
            System.out.println(satirdakiData);
        }

        /*
        Baska bir cözüm;
        FileInputStream fis=new FileInputStream("src/resources/ulkeler.xlsx");
       Workbook workbook= WorkbookFactory.create(fis);
       for (int i = 0; i <workbook.getSheet("Sayfa1").getPhysicalNumberOfRows() ; i++) {
           String ulkelerIng=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
           System.out.println("ulkelerIng = " + ulkelerIng);

                       }
                 System.out.println();
       */

        /*
        Baska cözüm
        for (int i = 0; i <=sonSatirIdx ; i++) {

           String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            System.out.println(satirdakiData);


        }
         */




    }
}
