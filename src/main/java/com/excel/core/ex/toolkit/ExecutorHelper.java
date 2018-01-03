package com.excel.core.ex.toolkit;

import com.excel.entity.Bulk;
import com.excel.entity.CaEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.List;

public class ExecutorHelper {


    public static void refreshBulk(Bulk bulk, int row, int column, Cell cell) {
        bulk.setCell(cell);
        bulk.setRow(row);
        bulk.setColumn(column);
    }


    /**
     * @param bulk
     */
    public static void formatNumber(Bulk bulk) {

    }

    /**
     * 向Bulk中写入合并单元格的信息
     *
     * @param bulk  bulk数据
     * @param sheet excel的sheet信息
     */
    public static void makeMergedRegionToBulk(Bulk bulk, Sheet sheet) {

        int sheetMergeCount = sheet.getNumMergedRegions();

        if (sheetMergeCount > 0) {
            List<CellRangeAddress> cellRangeAddressList = new ArrayList<>();
            for (int i = 0; i < sheetMergeCount; i++) {
                cellRangeAddressList.add(sheet.getMergedRegion(i));
            }
            bulk.setCellRangeAddressList(cellRangeAddressList);
        }
    }

    /**
     * 判断当前cell是否为合并单元格区域
     *
     * @param sheet  当前sheet
     * @param row    当前行
     * @param column 当前列
     * @return 返回CaEntity
     * @see CaEntity
     */
    public static CaEntity isMergedRegion(XSSFSheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        CaEntity caEntity;
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {

                    caEntity = new CaEntity();

                    caEntity.setFirstRow(firstRow);
                    caEntity.setLastRow(lastRow);
                    caEntity.setFirstColumn(firstColumn);
                    caEntity.setLastColumn(lastColumn);

                    if (lastRow != firstRow) {
                        caEntity.setRowSpan(true);
                    }

                    if (row == firstRow) {
                        caEntity.setFirstRowSpan(true);
                    }

                    return caEntity;

                }
            }
        }
        return new CaEntity();
    }

    /**
     * 判断当前cell是否为合并单元格区域(简化版)
     *
     * @param bulk
     * @return
     */
    public static CaEntity isMergedRegion(Bulk bulk) {

        CaEntity caEntity = null;
        int row = bulk.getRow();
        int column = bulk.getColumn();


        for (int i = 0; i < bulk.getCellRangeAddressList().size(); i++) {
            CellRangeAddress ca = bulk.getCellRangeAddressList().get(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {


                    caEntity = new CaEntity();
                    caEntity.setFirstRow(firstRow);
                    caEntity.setLastRow(lastRow);
                    caEntity.setFirstColumn(firstColumn);
                    caEntity.setLastColumn(lastColumn);

                    if (lastRow != firstRow) {
                        caEntity.setRowSpan(true);
                    }
                    if (row == firstRow) {
                        caEntity.setFirstRowSpan(true);
                    }

                    if (firstColumn != lastColumn) {
                        caEntity.setColSpan(true);
                    }

                    if (column == firstColumn) {
                        caEntity.setFirstColSpan(true);
                    }
                    return caEntity;
                }
            }
        }
        return caEntity;

    }
}
