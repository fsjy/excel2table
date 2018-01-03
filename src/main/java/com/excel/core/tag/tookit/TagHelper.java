package com.excel.core.tag.tookit;

import com.excel.Const;

import java.util.Map;

/**
 * @author darcula
 */
public class TagHelper {


    /**
     * 制作tag的html代码
     *
     * @param tag        tag名称
     * @param attributes 属性<k,v>
     * @return tag的html
     */
    public static String makeHtmlTag(String tag, Map<String, String> attributes) {

        StringBuffer stringBuffer = new StringBuffer();

        // <
        stringBuffer.append(Const.HTML_LEFT_BRACKET);
        // td
        stringBuffer.append(tag);

        // " "
        stringBuffer.append(Const.HTML_TAG_SPACE);

        attributes.forEach((k, v) -> {


            // rospan
            stringBuffer.append(k.toString());
            // =
            stringBuffer.append(Const.HTML_TAG_EQUALS);
            // "
            stringBuffer.append(Const.HTML_TAG_DOUBLE_QUOTATION);
            // 20
            stringBuffer.append(v);
            // "
            stringBuffer.append(Const.HTML_TAG_DOUBLE_QUOTATION);
            // " "
            stringBuffer.append(Const.HTML_TAG_SPACE);

        });

        stringBuffer.deleteCharAt(stringBuffer.toString().length() - 1);

        stringBuffer.append(Const.HTML_RIGHT_BRACKET);

        return stringBuffer.toString();

    }
}
