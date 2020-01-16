package cn.ithuajuan.write;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : Hiccup
 * create at : 2020/1/15 10:40 下午
 * description :
 * remark :
 **/
public class DemoPicture {
    public static void main(String[] args) throws Exception{
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("test");
        // 读取图片流
        FileInputStream stream = new FileInputStream("/Users/huajuan/Pictures/9.jpg");
        // 转化成二进制数组
        byte[] bytes = IOUtils.toByteArray(stream);
        stream.read(bytes);
        // 向内存中添加一张图片,返回图片在图片集合中的索引
        int index = wb.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG);
        // 绘制图片工具类
        XSSFCreationHelper helper = wb.getCreationHelper();
        // 创建一个绘图对象
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        // 创建锚点,设置图片坐标
        XSSFClientAnchor anchor = helper.createClientAnchor();
        anchor.setRow1(0);
        anchor.setCol1(0);
        // 绘制图片
        XSSFPicture picture = patriarch.createPicture(anchor, index);
        // 自适应渲染
        picture.resize();
        // 输出流
        FileOutputStream pis = new FileOutputStream("/Users/huajuan/desktop/huajuan2.xls");
        wb.write(pis);
        pis.close();
        System.out.println("写入图片成功");
    }


}
