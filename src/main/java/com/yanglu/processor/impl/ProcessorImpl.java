package com.yanglu.processor.impl;

import com.yanglu.core.ex.Executor;
import com.yanglu.core.preEx.PreExecutor;
import com.yanglu.entity.RawTable;
import com.yanglu.entity.Result;
import com.yanglu.processor.Processor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ProcessorImpl implements Processor {

    @Autowired
    PreExecutor preExecutor;

    @Autowired
    Executor executor;


    /**
     * 利用Excel文件路径开始解析
     *
     * @param path Excel的路径
     */
    @Override
    public void startProcessByPath(String path, String covertFormat) throws Exception {

        File file = new File(path);

        Workbook book = new XSSFWorkbook(file);

        RawTable rawTable = preExecutor.execute(book);

        Result result = executor.execute(rawTable);

    }
}
