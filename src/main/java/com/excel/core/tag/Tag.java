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
     * 获得tag的html的代码(Start)
     *
     * @return tag的html代码 <xx>
     */
    String drawStartHtml();

    /**
     * 获得tag的html的代码(End)
     *
     * @return tag的html代码 </xx>
     */
    String drawEndHtml();


    /**
     * 隐藏tag，不输出
     */
    Tag hide();

    /**
     * 显示tag，可输出
     */
    Tag display();

    /**
     * 是否隐藏tag
     *
     * @return 是 or 否
     */
    boolean isHidden();


}
