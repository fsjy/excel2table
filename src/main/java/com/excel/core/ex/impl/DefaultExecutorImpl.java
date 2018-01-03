package com.excel.core.ex.impl;


import com.excel.Const;
import com.excel.core.ex.AbstractExecutor;
import com.excel.core.ex.Executor;
import com.excel.core.ex.toolkit.ExecutorHelper;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.writer.Writer;
import com.excel.core.writer.tookit.WriterHelper;
import com.excel.entity.Bulk;
import com.excel.entity.CaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultExecutorImpl extends AbstractExecutor implements Executor {


    Logger logger = LoggerFactory.getLogger(DefaultExecutorImpl.class);

    @Autowired
    Writer consoleWriterImpl;

    public boolean begin(Bulk b) {

        // 输出<table>
        writeLn(b, " ".concat(Const.HTML_TABLE_START));
        return true;
    }

    /**
     * 一行开始时的处理
     *
     * @param b
     * @return
     */
    @Override
    protected boolean beforeOneLine(Bulk b) {

        // 输出<tr>
        writeLn(b, WriterHelper.addTab(Const.HTML_TR_START, 1));
        return true;
    }

    /**
     * 一个cell开始时的处理
     *
     * @param b
     * @return
     */
    @Override
    protected boolean beforeLineStep(Bulk b) {

        // 输出<th> or <td>
        if (b.getRow() == 0) {
            write(b, WriterHelper.addTab(Const.HTML_TH_START, 2));
            return true;
        } else {

            // 取得合并区域内容
            CaEntity caEntity = ExecutorHelper.isMergedRegion(b);

            // 没有合并
            if (caEntity == null || caEntity.isNormal()) {

                logger.debug("No mergedRegion. Using default write method");
                write(b, WriterHelper.addTab(TD.get().drawHtml(), 2));
                return true;
            } else {




                // 如果是rowspan的第一个
                if (caEntity.isFirstRowSpan()) {

                    logger.debug("CaEntity is mergedRegion. Will write <td rowspan= ... ");
                    // 拼接<td rowpspan="999">

//
//                    String writeOut = Const.HTML_TD_ROWSPAN_START
//                            .concat(String.valueOf(caEntity.getLastRow() - caEntity.getFirstRow() + 1))
//                            .concat("\"")
//                            .concat(Const.HTML_RIGHT_BRACKET);
                    String writeOut = TD.get()
                            .setRowspan(caEntity.getRowSpan())
                            .drawHtml();
                    logger.debug("First Rowspan is : {}", writeOut);

                    write(b, WriterHelper.addTab(writeOut, 2));

                    return true;
                } else {
                    // 遇到非第一个的rowspan则跳过 不打出<td>标签
                    if (caEntity.isRowSpan()) {

                        logger.debug("CaEntity is in rowspan, and will skip writing tags.");
                        return false;
                    }


                    logger.debug("CaEntity is in rowspan, and will skip writing tags.");
                    return false;
                }
            }
        }
    }

    /**
     * 处理cell过程中
     *
     * @param b
     * @return
     */
    @Override
    protected boolean lineStepping(Bulk b) {

        String cellString = b.getCell().toString();

        // 输出内容

        if (cellString.startsWith(Const.CONTENT_TASK_LISTS)) {
            System.out.println();
        }

        write(b, cellString.replace(".0", ""));

        if (cellString.startsWith(Const.CONTENT_TASK_LISTS)) {
            System.out.println();
            System.out.println();
        }
        return true;
    }

    /**
     * 一个cell处理完毕
     *
     * @param b
     * @return
     */
    @Override
    protected boolean afterLineStep(Bulk b) {

        // 输出<th> or <td>
        if (b.getRow() == 0) {
            writeLn(b, Const.HTML_TH_END);
        } else {
            writeLn(b, Const.HTML_TD_END);
        }
        return true;
    }


    /**
     * 一行处理完毕
     *
     * @param b
     * @return
     */
    @Override
    protected boolean afterOneLine(Bulk b) {

        // 输出</tr>
        writeLn(b, WriterHelper.addTab(Const.HTML_TR_END, 1));
        return true;
    }


    /**
     * 整个处理完毕
     *
     * @param b
     * @return
     */
    @Override
    protected boolean end(Bulk b) {

        // 输出</table>
        writeLn(b, Const.HTML_TABLE_END);
        return true;
    }

    @Override
    protected Writer getWriter() {
        return this.consoleWriterImpl;
    }


}
