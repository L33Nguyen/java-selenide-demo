package utils.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	 public static List<Map<String, String>> readExcel(String path, String sheetName) {
	        List<Map<String, String>> dataList = new ArrayList<>();
	        try (Workbook workbook = new XSSFWorkbook(new File(path))) {
	            Sheet sheet = workbook.getSheet(sheetName);
	            System.out.println("Sheet name:"+sheet.getSheetName());
	            
	            Row headerRow = sheet.getRow(0);
	            DataFormatter formatter = new DataFormatter();
	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Map<String, String> dataMap = new HashMap<>();
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
	                    String key = formatter.formatCellValue(headerRow.getCell(j)).trim();
	                    String value = formatter.formatCellValue(row.getCell(j)).trim();
	                    dataMap.put(key, value);
	                }
	                dataList.add(dataMap);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dataList;
	    }
	
}
