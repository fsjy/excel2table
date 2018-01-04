package com.excel.core.tag.tagEntity;

import com.excel.Const;
import com.excel.core.tag.AbstractTag;

public class TABLE extends AbstractTag {

    private String name = Const.HTML_TAG_TABLE;

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return name;
    }

    public static TABLE get() {
        return new TABLE();
    }
}
