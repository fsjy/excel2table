package com.excel.entity;

public class CaEntity {

    private int firstColumn;
    private int lastColumn;
    private int firstRow;
    private int lastRow;


    private boolean isFirstRowSpan = false;

    private boolean isFirstColSpan = false;

    private boolean isColSpan = false;

    private boolean isRowSpan = false;


    public boolean isNormal() {
        if (isFirstRowSpan || isFirstColSpan || isColSpan || isRowSpan) {
            return false;
        }

        return true;
    }

    public int getRowSpan() {
        return this.lastRow - this.firstRow + 1;
    }

    public int getColSpan() {
        return this.lastColumn - this.firstColumn + 1;
    }


    public boolean isFirstColSpan() {
        return isFirstColSpan;
    }

    public void setFirstColSpan(boolean firstColSpan) {
        isFirstColSpan = firstColSpan;
    }

    public boolean isFirstRowSpan() {
        return isFirstRowSpan;
    }

    public void setFirstRowSpan(boolean firstRowSpan) {
        isFirstRowSpan = firstRowSpan;
    }

    public boolean isColSpan() {
        return isColSpan;
    }

    public void setColSpan(boolean colSpan) {
        isColSpan = colSpan;
    }

    public boolean isRowSpan() {
        return isRowSpan;
    }

    public void setRowSpan(boolean rowSpan) {
        isRowSpan = rowSpan;
    }

    public int getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(int firstColumn) {
        this.firstColumn = firstColumn;
    }

    public int getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(int lastColumn) {
        this.lastColumn = lastColumn;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }
}
