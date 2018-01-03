package com.excel.processor.impl;

import com.excel.core.ex.Executor;
import com.excel.core.preEx.PreExecutor;
import com.excel.entity.RawTable;
import com.excel.entity.Result;
import com.excel.processor.Processor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ProcessorImpl implements Processor {

    @Autowired
    PreExecutor preExecutor;

    @Autowired
    Executor defaultExecutorImpl;


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

        Result result = defaultExecutorImpl.execute(rawTable);

    }
}
