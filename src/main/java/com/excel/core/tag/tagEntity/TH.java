package com.excel.core.tag.tagEntity;

import com.excel.Const;
import com.excel.core.tag.AbstractColRowSpanTag;
import com.excel.core.tag.AbstractTag;

public class TH extends AbstractColRowSpanTag {

    private String name = Const.HTML_TAG_TH;

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return this.name;
    }

    public static TH get() {
        return new TH();
    }
}
