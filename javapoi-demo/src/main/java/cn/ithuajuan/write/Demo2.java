package cn.ithuajuan.write;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : Hiccup
 * create at : 2020/1/13 10:57 下午
 * description :
 * remark :
 **/
public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 创建一个工作簿
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 创建工作表
        XSSFSheet sheet = workBook.createSheet("工作表1");
        // 创建行
        XSSFRow row = sheet.createRow(0);
        // 创建单元格
        row.createCell(0).setCellValue("你好");
        row.createCell(1).setCellValue("你好,世界");
        row.createCell(2).setCellValue("你好,中国");
        // 输出流
        FileOutputStream out = new FileOutputStream("/Users/huajuan/desktop/huajuan.xls");
        workBook.write(out);
        out.flush();
        // 释放资源
        out.close();
        workBook.close();
        System.out.println("写入成功");
    }
}
