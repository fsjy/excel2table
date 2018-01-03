package com.yanglu.core.writer;

import com.yanglu.entity.Bulk;

public interface Writer {

    void write(Bulk bulk);

    void writeLn(Bulk bulk);
}
