package com.excel.core.tag.tagEntity;

import com.excel.Const;
import com.excel.core.tag.AbstractTag;

public class TR extends AbstractTag {

    private String name = Const.HTML_TAG_TR;

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return name;
    }

    public static TR get() {
        return new TR();
    }
}
