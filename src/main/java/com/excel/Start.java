package com.excel;

import com.excel.entity.Rule;
import com.excel.processor.Processor;
import com.excel.processor.impl.ProcessorImpl;
import com.excel.tookit.C;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


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
