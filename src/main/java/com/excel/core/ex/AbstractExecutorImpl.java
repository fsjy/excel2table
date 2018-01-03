package com.excel.core.ex;

import com.excel.core.ex.Executor;
import com.excel.core.ex.toolkit.ExecutorHelper;
import com.excel.core.writer.Writer;
import com.excel.entity.Bulk;
import com.excel.entity.RawTable;
import com.excel.entity.Result;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class AbstractExecutorImpl implements Executor {


    /**
     * 向bulk的output中写入setString
     *
     * @param bulk      传输数据块
     * @param setString 要写入内容
     */
    protected void B(Bulk bulk, String setString) {
        bulk.setOutput(setString);
    }


    @Override
    public Result execute(RawTable rawTable) {

        int rowStart = rawTable.getRowStart();
        int rowEnd = rawTable.getRowEnd();

        int columnStart = rawTable.getColumnStart();
        int columnEnd = rawTable.getColumnEnd();

        Sheet sheet = rawTable.getSheet();


        int i = -1, j = -1;

        Bulk bulk = new Bulk();

        bulk.setSheet(sheet);

        // 向bulk写入合并单元格信息
        ExecutorHelper.makeMergedRegionToBulk(bulk, sheet);

        ExecutorHelper.refreshBulk(bulk, i, j, null);

        if (begin(bulk)) {

            for (i = rowStart; i < rowEnd + 1; i++) {

                ExecutorHelper.refreshBulk(bulk, i, j, null);

                if (beforeOneLine(bulk)) {
                    for (j = columnStart; j < columnEnd; j++) {

                        Cell cell = sheet.getRow(i).getCell(j);
                        ExecutorHelper.refreshBulk(bulk, i, j, cell);
                        if (!beforeLineStep(bulk)) {
                            continue;
                        }

                        ExecutorHelper.refreshBulk(bulk, i, j, cell);
                        if (!lineStepping(bulk)) {
                            continue;
                        }


                        ExecutorHelper.refreshBulk(bulk, i, j, cell);
                        if (!afterLineStep(bulk)) {
                            continue;
                        }
                    }
                }

                if (!afterOneLine(bulk)) {
                    break;
                }
            }
        }


        end(bulk);

        return getResult(bulk);
    }

    protected boolean begin(Bulk bulk) {
        return true;
    }

    ;

    protected boolean beforeLineStep(Bulk bulk) {
        return true;
    }

    ;


    protected boolean lineStepping(Bulk bulk) {
        return true;
    }

    ;


    protected boolean afterLineStep(Bulk bulk) {
        return true;
    }

    ;

    protected boolean afterOneLine(Bulk bulk) {
        return true;
    }

    ;

    protected boolean beforeOneLine(Bulk bulk) {
        return true;
    }

    ;

    protected boolean end(Bulk bulk) {
        return true;
    }

    ;

    protected Result getResult(Bulk bulk) {
        return null;
    }

    ;


    protected void write(Bulk b, String setString) {
        B(b, setString);
        getWriter().write(b);
    }

    protected void writeLn(Bulk b, String setString) {
        B(b, setString);
        getWriter().writeLn(b);
    }

    protected Writer getWriter() {
        return null;
    }
}
