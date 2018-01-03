package com.excel.processor;

/**
 * Excel解析引擎
 *
 * @author darcula
 */
public interface Processor {

    /**
     * 利用Excel文件路径开始解析
     *
     * @param path Excel的路径
     */
    void startProcessByPath(String path, String converFormat) throws Exception;


}
