package com.excel;

import com.excel.core.ex.Executor;
import com.excel.core.ex.impl.DefaultExecutorImpl;
import com.excel.core.preEx.PreExecutor;
import com.excel.core.preEx.impl.PreExecutorImpl;
import com.excel.core.writer.Writer;
import com.excel.core.writer.impl.ConsoleWriterImpl;
import com.excel.processor.Processor;
import com.excel.processor.impl.ProcessorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.excel.processor.*", "com.excel.core.*"})
public class SpringConfig {

    /**
     * 执行excel解析过程的Processor的实例
     *
     * @return Processor的实例
     */
    @Bean
    public Processor processor() {
        return new ProcessorImpl();
    }


    /**
     * 前处理executor
     *
     * @return PreExecutorImpl
     */
    @Bean
    public PreExecutor preExecutor() {
        return new PreExecutorImpl();
    }


    /**
     * 核心处理executor
     *
     * @return
     */
    @Bean
    public Executor executor() {
        return new DefaultExecutorImpl();
    }


    /**
     * 输出writer
     *
     * @return
     */
    @Bean
    public Writer writer() {
        return new ConsoleWriterImpl();
    }


}
