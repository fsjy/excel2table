package com.excel.core.tagwrapper.impl;

import com.excel.core.tag.Tag;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.tag.tagEntity.TH;
import com.excel.core.tagwrapper.AbstractColRowSpanWrapper;
import com.excel.core.tagwrapper.TagWrapper;
import com.excel.entity.CaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * TH标签的包装类
 *
 * @author darcula
 */
@Service("tHWrapperImpl")
public class THWrapperImpl extends AbstractColRowSpanWrapper {

    Logger log = LoggerFactory.getLogger(THWrapperImpl.class);


}
