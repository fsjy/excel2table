package com.yanglu.core.ex.impl;


import com.yanglu.Const;
import com.yanglu.core.ex.Executor;
import com.yanglu.core.ex.toolkit.ExecutorHelper;
import com.yanglu.core.writer.Writer;
import com.yanglu.core.writer.tookit.WriterHelper;
import com.yanglu.entity.Bulk;
import com.yanglu.entity.CaEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultExecutorImpl extends AbstractExecutorImpl implements Executor {

    @Autowired
    Writer defaultWriter;

    @Override
    protected boolean begin(Bulk b) {

        // 输出<table>
        write(b, " ".concat(Const.HTML_TABLE_START));
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
        write(b, WriterHelper.addTab(Const.HTML_TR_START, 1));
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
            if (caEntity == null) {
                write(b, WriterHelper.addTab(Const.HTML_TD_START, 2));
                return true;
            } else {

                // 有合并的单元格的场合
                if (caEntity.isNormal()) {
                    return true;
                } else {
                    // 如果是rowspan的第一个
                    if (caEntity.isFirstRowSpan()) {
                        // 拼接<td rowpspan="999">
                        String writeOut = Const.HTML_TD_ROWSPAN_START
                                .concat(String.valueOf(caEntity.getLastRow() - caEntity.getFirstRow() + 1))
                                .concat("\"")
                                .concat(Const.HTML_RIGHT_BRACKET);

                        write(b, WriterHelper.addTab(writeOut, 2));

                        return true;
                    } else {
                        // 遇到非第一个的rowspan则跳过 不打出<td>标签
                        if (caEntity.isRowSpan()) {
                            return false;
                        }
                        return false;
                    }
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
            write(b, Const.HTML_TH_END);
        } else {
            write(b, Const.HTML_TD_END);
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
        write(b, WriterHelper.addTab(Const.HTML_TR_END, 1));
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
        write(b, Const.HTML_TABLE_END);
        return true;
    }

    @Override
    protected Writer getWriter() {
        return this.defaultWriter;
    }


}
