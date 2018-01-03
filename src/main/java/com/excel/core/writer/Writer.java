package com.excel.core.writer;

import com.excel.entity.Bulk;

public interface Writer {

    void write(Bulk bulk);

    void writeLn(Bulk bulk);
}
