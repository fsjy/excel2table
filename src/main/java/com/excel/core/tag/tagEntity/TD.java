package com.excel.core.tag.tagEntity;

import com.excel.Const;
import com.excel.core.tag.AbstractTag;
import com.excel.core.tag.Tag;

public class TD extends AbstractTag {

    private String name = Const.HTML_TAG_TD;
    private int rowspan;
    private int colspan;


    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return name;
    }

    public static TD get() {
        return new TD();
    }

    public int getRowspan() {
        return rowspan;
    }

    public TD setRowspan(int rowspan) {
        this.rowspan = rowspan;
        getAttributes().put(Const.HTML_TD_ROWSPAN, String.valueOf(rowspan));
        return this;
    }

    public int getColspan() {
        return colspan;
    }

    public TD setColspan(int colspan) {
        this.colspan = colspan;
        getAttributes().put(Const.HTML_TD_COLSPAN, String.valueOf(colspan));
        return this;
    }
}
