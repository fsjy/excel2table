package com.excel.core.writer.tookit;

public class WriterHelper {

    /**
     * 对s字符串前加num数量个tab
     *
     * @param s   需要加tab的字符串
     * @param num 需要加价格tab
     * @return 增加tab后的结果
     */
    public static String addTab(String s, int num) {

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < num; i++) {
            stringBuffer.append("\t");
        }

        return stringBuffer.append(s).toString();
    }
}
