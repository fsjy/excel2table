package com.yanglu;

import com.yanglu.core.ex.Executor;
import com.yanglu.core.ex.impl.DefaultExecutorImpl;
import com.yanglu.core.preEx.PreExecutor;
import com.yanglu.core.preEx.impl.PreExecutorImpl;
import com.yanglu.core.writer.Writer;
import com.yanglu.core.writer.impl.ConsoleWriterImpl;
import com.yanglu.processor.Processor;
import com.yanglu.processor.impl.ProcessorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.yanglu.processor.*", "com.yanglu.core.*"})
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
