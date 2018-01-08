package com.excel.core.tag.tagEntity;

import com.excel.Const;
import com.excel.core.tag.AbstractColRowSpanTag;
import com.excel.core.tag.AbstractTag;
import com.excel.core.tag.Tag;
import com.excel.core.tagwrapper.AbstractColRowSpanWrapper;

public class TD extends AbstractColRowSpanTag {

    private String name = Const.HTML_TAG_TD;

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




}
