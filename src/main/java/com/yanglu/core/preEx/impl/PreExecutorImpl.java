package com.yanglu.core.preEx.impl;

import com.yanglu.core.preEx.PreExecutor;
import com.yanglu.entity.RawTable;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PreExecutorImpl implements PreExecutor {

    @Override
    public RawTable execute(Workbook workbook) {


        Sheet sheet = workbook.getSheetAt(0);

        RawTable rawTable = new RawTable();

        rawTable.setRowStart(sheet.getFirstRowNum());
        rawTable.setRowEnd(sheet.getLastRowNum());

        Row firstRow = sheet.getRow(sheet.getFirstRowNum());

        rawTable.setColumnStart(firstRow.getFirstCellNum());
        rawTable.setColumnEnd(firstRow.getLastCellNum());

        rawTable.setSheet(sheet);

        return rawTable;
    }
}
