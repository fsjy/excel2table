package com.excel.core.tag;

import java.util.Map;

public interface Tag {

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    String getTagName();

    /**
     * 获得Tag中所有的属性与内容
     *
     * @return 属性内容<k,v>
     */
    Map<String, String> getAttributes();


    /**
     * 向Tag中增加属性以及内容
     *
     * @param attr  属性名称
     * @param value 内容
     */
    Tag addAttribute(String attr, String value);

    /**
     * 获得tag的html的代码
     *
     * @return tag的html代码
     */
    String getHtmlTagBody();

}
