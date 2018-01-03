package com.excel.core.tag.tagEntity;

import com.excel.Const;
import com.excel.core.tag.AbstractTag;

public class TD extends AbstractTag {

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return Const.HTML_TAG_TD;
    }

    public static TD get() {
        return new TD();
    }
}
