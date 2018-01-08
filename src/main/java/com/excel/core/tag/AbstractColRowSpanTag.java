package com.excel.core.tag;

import com.excel.Const;

public abstract class AbstractColRowSpanTag extends AbstractTag {

    private int rowspan;
    private int colspan;


    public int getRowspan() {
        return rowspan;
    }

    public AbstractColRowSpanTag setRowspan(int rowspan) {
        this.rowspan = rowspan;
        getAttributes().put(Const.HTML_TD_ROWSPAN, String.valueOf(rowspan));
        return this;
    }

    public int getColspan() {
        return colspan;
    }

    public AbstractColRowSpanTag setColspan(int colspan) {
        this.colspan = colspan;
        getAttributes().put(Const.HTML_TD_COLSPAN, String.valueOf(colspan));
        return this;
    }
}
