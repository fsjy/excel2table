package com.excel.core.tag;

import com.excel.core.tag.tookit.TagHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author darcula
 */
public abstract class AbstractTag implements Tag {

    private Map<String, String> attributes = new HashMap<>();

    /**
     * 获得Tag中所有的属性与内容
     *
     * @return 属性内容<k,v>
     */
    @Override
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * 向Tag中增加属性以及内容
     *
     * @param attr  属性名称
     * @param value 内容
     */
    @Override
    public Tag addAttribute(String attr, String value) {
        attributes.put(attr, value);
        return this;
    }

    /**
     * 获得tag的html的代码
     *
     * @return tag的html代码
     */
    @Override
    public String drawHtml() {

        return TagHelper.makeHtmlTag(getTagName(), this.attributes);

    }
}
