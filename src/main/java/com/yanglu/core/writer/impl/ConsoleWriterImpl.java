package com.yanglu.core.writer.impl;

import com.yanglu.core.writer.Writer;
import com.yanglu.entity.Bulk;

public class ConsoleWriterImpl implements Writer {

    @Override
    public void write(Bulk bulk) {

        System.out.print(bulk.getOutput());

    }

    @Override
    public void writeLn(Bulk bulk) {

        System.out.println(bulk.getOutput());

    }
}
