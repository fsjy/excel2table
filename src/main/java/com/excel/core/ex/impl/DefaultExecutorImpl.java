package com.excel.core.ex.impl;


import com.excel.Const;
import com.excel.core.ex.AbstractExecutor;
import com.excel.core.ex.Executor;
import com.excel.core.ex.toolkit.ExecutorHelper;
import com.excel.core.tag.Tag;
import com.excel.core.tag.tagEntity.TABLE;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.tag.tagEntity.TH;
import com.excel.core.tag.tagEntity.TR;
import com.excel.core.tagwrapper.TagWrapper;
import com.excel.core.writer.Writer;
import com.excel.core.writer.tookit.WriterHelper;
import com.excel.entity.Bulk;
import com.excel.tookit.Excel2html;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultExecutorImpl extends AbstractExecutor implements Executor {


    Logger logger = LoggerFactory.getLogger(DefaultExecutorImpl.class);

    @Autowired
    Writer consoleWriterImpl;

    @Autowired
    TagWrapper tDWrapperImpl;

    public boolean begin(Bulk b) {

        // 输出<table>
        writeLn(b, " ".concat(TABLE.get().drawStartHtml()));
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
        writeLn(b, WriterHelper.addTab(TR.get().drawStartHtml(), 1));
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

            // 暂时可以不使用包装类来修饰TH标签
            // thWrapperImpl.wrap(null, TH.get());
            write(b, WriterHelper.addTab(TH.get().drawStartHtml(), 2));
            return true;
        } else {

            // 取得合并区域内容 使用wrapper进行包装
            Tag tag = tDWrapperImpl.wrap(ExecutorHelper.isMergedRegion(b), TD.get());

            if (tag.isHidden() == false) {
                write(b, WriterHelper.addTab(tag.drawStartHtml(), 2));
                return true;
            } else {
                return false;
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

        String cellString = Excel2html.getValue(b.getCell());

        // 输出内容

        if (cellString.startsWith(Const.CONTENT_TASK_LISTS)
                || cellString.startsWith(Const.CONTENT_TASK_LISTS_OVER)) {
            System.out.println();
        }

        write(b, cellString.replace(".0", ""));

        if (cellString.startsWith(Const.CONTENT_TASK_LISTS)
                || cellString.startsWith(Const.CONTENT_TASK_LISTS_OVER)) {
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
            writeLn(b, TH.get().drawEndHtml());
        } else {
            writeLn(b, TD.get().drawEndHtml());
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
        writeLn(b, WriterHelper.addTab(TR.get().drawEndHtml(), 1));
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
        writeLn(b, TABLE.get().drawEndHtml());
        return true;
    }

    @Override
    protected Writer getWriter() {
        return this.consoleWriterImpl;
    }


}
