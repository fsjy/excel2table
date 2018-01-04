package com.excel.core.tagwrapper.impl;

import com.excel.core.tag.Tag;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.tag.tagEntity.TH;
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
@Service
public class THWrapperImpl implements TagWrapper<Object> {

    Logger log = LoggerFactory.getLogger(THWrapperImpl.class);

    @Override
    public Tag wrap(Object object, Tag tag) {

        TH th = (TH) tag;
        return th;

    }
}
