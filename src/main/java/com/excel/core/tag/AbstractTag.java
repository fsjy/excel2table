package com.excel.core.tag;

import com.excel.Const;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.tag.tookit.TagHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author darcula
 */
public abstract class AbstractTag implements Tag {

    private Map<String, String> attributes = new HashMap<>();
    private boolean isHidden = false;


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
    public String drawStartHtml() {

        return TagHelper.makeHtmlTag(getTagName(), this.attributes);

    }

    /**
     * 获得tag的html的代码(End)
     *
     * @return tag的html代码 </xx>
     */
    @Override
    public String drawEndHtml() {
        return Const.HTML_LEFT_BRACKET               // <
                .concat(Const.HTML_TAG_SLASH)        // /
                .concat(getTagName())                // xx
                .concat(Const.HTML_RIGHT_BRACKET);   // >
    }

    @Override
    public Tag hide() {
        this.isHidden = true;
        return this;
    }

    /**
     * 是否隐藏tag
     *
     * @return 是 or 否
     */
    @Override
    public boolean isHidden() {
        return this.isHidden;
    }

    /**
     * 显示tag，可输出
     */
    @Override
    public Tag display() {
        this.isHidden = false;
        return this;
    }
}
