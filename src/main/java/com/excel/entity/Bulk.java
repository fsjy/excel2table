package com.excel.entity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class Bulk {

    private Sheet sheet;
    private List<CellRangeAddress> cellRangeAddressList;

    private int row;
    private int column;
    private Cell cell;
    private String output;

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public List<CellRangeAddress> getCellRangeAddressList() {
        return cellRangeAddressList;
    }

    public void setCellRangeAddressList(List<CellRangeAddress> cellRangeAddressList) {
        this.cellRangeAddressList = cellRangeAddressList;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return this.cell.toString();
    }
}
