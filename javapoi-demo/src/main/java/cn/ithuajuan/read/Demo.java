package cn.ithuajuan.read;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * @author : Hiccup
 * create at : 2020/1/13 10:33 下午
 * description :
 * remark :
 **/
public class Demo {
    public static void main(String[] args) throws IOException {
        // 获取工作簿
        XSSFWorkbook workBook = new XSSFWorkbook("/Users/huajuan/desktop/huajuan.xls");
        // 获取工作表
        XSSFSheet sheet = workBook.getSheetAt(0);
        // 获取行
        for (Row row : sheet) {
            // 获取单元格
            for (Cell cell : row) {
                // 获取单元格中的内容
                String values = cell.getStringCellValue();
                System.out.println(values);
            }
        }
        workBook.close();

        // 普通for循环 开始索引 0 结束索引
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null){
                short cellNum = row.getLastCellNum();
                for (int j = 0; j <= cellNum; j++) {
                    XSSFCell cell = row.getCell(0);
                    if (cell != null){
                        String values2 = cell.getStringCellValue();
                        System.out.println(values2);
                    }
                }


            }
        }
    }
}
