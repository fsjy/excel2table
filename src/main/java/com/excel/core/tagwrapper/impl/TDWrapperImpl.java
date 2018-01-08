package com.excel.core.tagwrapper.impl;

import com.excel.core.tag.Tag;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.tagwrapper.AbstractColRowSpanWrapper;
import com.excel.core.tagwrapper.TagWrapper;
import com.excel.entity.CaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * TD标签的包装类
 *
 * @author darcula
 */
@Service("tDWrapperImpl")
public class TDWrapperImpl extends AbstractColRowSpanWrapper{

    Logger log = LoggerFactory.getLogger(TDWrapperImpl.class);

}
