package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromExcel {

    String homeDir = System.getProperty("user.dir");
    String testDataDir = homeDir+"/src/test/TestData/Testdata.xlsx";
    FileInputStream fis = new FileInputStream(testDataDir);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    public ReadFromExcel() throws IOException {
    }

    XSSFSheet sheet = workbook.getSheetAt(0);
    public String username = sheet.getRow(1).getCell(0).getStringCellValue();
    public String password = sheet.getRow(1).getCell(1).getStringCellValue();

    XSSFSheet userInfo = workbook.getSheetAt(1);
    public String firstName = userInfo.getRow(1).getCell(0).getStringCellValue();
    public String lastName = userInfo.getRow(1).getCell(1).getStringCellValue();
    public String idNumber = userInfo.getRow(1).getCell(2).getStringCellValue();

}
