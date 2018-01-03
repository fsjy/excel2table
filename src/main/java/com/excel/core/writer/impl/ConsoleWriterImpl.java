package com.excel.core.writer.impl;

import com.excel.core.writer.Writer;
import com.excel.entity.Bulk;
import org.springframework.stereotype.Service;

@Service
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
