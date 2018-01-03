package com.yanglu;

import com.yanglu.entity.Rule;
import com.yanglu.processor.Processor;
import com.yanglu.tookit.C;


/**
 * excel2html的主执行class
 *
 * @author darcula
 */
public class Start {

    public static void main(String[] args) throws Exception {

        // File
        String filePath = "/Users/yl/Downloads/schedule_image_short.xlsx";

        // 获得Context
        C c = C.get();

        // 规则一览
        // TODO
        Rule rule = new Rule();

        // 流程执行器
        Processor processor = c.g(Processor.class);

        // 开始
        processor.startProcessByPath(filePath, "");

        c.d();

    }
}
