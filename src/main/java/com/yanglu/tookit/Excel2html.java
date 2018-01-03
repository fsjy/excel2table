package com.yanglu.tookit;

import com.yanglu.core.ex.toolkit.ExecutorHelper;
import com.yanglu.entity.CaEntity;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Excel2html {

    public static void main(String[] args) throws IOException, InvalidFormatException {


        File file = new File("/Users/yl/Downloads/schedule_image.xlsx");

        Workbook book = new XSSFWorkbook(file);

        Sheet sheet = book.getSheetAt(0);

        int rowStart = sheet.getFirstRowNum();  // 首行下标
        int rowEnd = sheet.getLastRowNum(); // 尾行下标

        Row firstRow = sheet.getRow(rowStart);
        int cellStart = firstRow.getFirstCellNum();
        int cellEnd = firstRow.getLastCellNum();

        String ROW_SIMBOL_START = "<tr>";
        String ROW_SIMBOL_END = "</tr>";
        String COL_SIMBOL_START = "<td>";
        String COL_SIMBOL_END = "</td>";

        System.out.println("<table border=\"1\">");
        for (int i = rowStart; i < rowEnd; i++) {

            if (i == 0) {
                COL_SIMBOL_START = "<th>";
                COL_SIMBOL_END = "</th>";
            } else {
                COL_SIMBOL_START = "<td>";
                COL_SIMBOL_END = "</td>";
            }

            System.out.println(addTab(ROW_SIMBOL_START, 1));

            for (int j = cellStart; j < cellEnd; j++) {

                Cell cell = sheet.getRow(i).getCell(j);

                CaEntity caEntity = ExecutorHelper.isMergedRegion((XSSFSheet) sheet, i, j);

                if (!caEntity.isNormal()) {

                    if (caEntity.isFirstRowSpan()) {
                        COL_SIMBOL_START = "<td rowspan=\"" + String.valueOf(caEntity.getLastRow() - caEntity.getFirstRow() + 1) + "\">";
                    } else {

                        if (caEntity.isRowSpan()) {
                            continue;
                        }

                    }

                }


                System.out.print(addTab(COL_SIMBOL_START, 2));
                String line = cell.toString();

                if (null != line) {
                    if (line.endsWith(".0")) {
                        line = line.replaceAll(".0", "");
                    }
                }

                System.out.print(line);
                System.out.println(COL_SIMBOL_END);

                if (!COL_SIMBOL_START.equals("<th>")) {
                    COL_SIMBOL_START = "<td>";
                }

            }

            System.out.println(addTab(ROW_SIMBOL_END, 1));
        }

        System.out.println("</table>");

    }

    /**
     * 获取每个单元格的数据
     *
     * @param cell   单元格对象
     * @param rowNum 第几行
     * @param index  该行第几个
     * @param book   主要用于关闭流
     * @param isKey  是否为键：true-是，false-不是。 如果解析Json键，值为空时报错；如果不是Json键，值为空不报错
     * @return
     * @throws IOException
     */
    public static String getValue(Cell cell, int rowNum, int index, Workbook book, boolean isKey) throws IOException {

        // 空白或空
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            if (isKey) {
                book.close();
                throw new NullPointerException(String.format("the key on row %s index %s is null ", ++rowNum, ++index));
            } else {
                return "";
            }
        }

        // 0. 数字 类型
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.format(date);
            }
            String val = cell.getNumericCellValue() + "";
            val = val.toUpperCase();
            if (val.contains("E")) {
                val = val.split("E")[0].replace(".", "");
            }
            return val;
        }

        // 1. String类型
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            String val = cell.getStringCellValue();
            if (val == null || val.trim().length() == 0) {
                if (book != null) {
                    book.close();
                }
                return "";
            }
            return val.trim();
        }

        // 2. 公式 CELL_TYPE_FORMULA
        if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getStringCellValue();
        }

        // 4. 布尔值 CELL_TYPE_BOOLEAN
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return cell.getBooleanCellValue() + "";
        }

        // 5.   错误 CELL_TYPE_ERROR
        return "";
    }

    public static String addTab(String s, int num) {

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < num; i++) {
            stringBuffer.append("\t");
        }

        return stringBuffer.append(s).toString();
    }



}
