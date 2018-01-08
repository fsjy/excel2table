package com.excel.core.tagwrapper;

import com.excel.core.tag.AbstractColRowSpanTag;
import com.excel.core.tag.Tag;
import com.excel.core.tag.tagEntity.TD;
import com.excel.core.tagwrapper.impl.TDWrapperImpl;
import com.excel.entity.CaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractColRowSpanWrapper implements TagWrapper<CaEntity> {


    Logger log = LoggerFactory.getLogger(AbstractColRowSpanWrapper.class);

    @Override
    public Tag wrap(CaEntity caEntity, Tag tag) {

        AbstractColRowSpanTag td = (AbstractColRowSpanTag) tag;
        if (td == null) {
            td = TD.get();
        }

        if (caEntity == null || caEntity.isNormal()) {
            log.debug("CaEntity is normal, will wrap td tag as <td>");
            return td;
        }

        if (caEntity.isRowSpan()) {
            log.debug("CaEntity is rowspan.");
            if (caEntity.isFirstRowSpan()) {
                log.debug("CaEntity is rowspan && CaEntity is first rowspan, will wrap td tag as <td rowspan= {} > ", caEntity.getRowSpan());
                td.setRowspan(caEntity.getRowSpan());
            } else {
                log.debug("CaEntity is rowspan && CaEntity is not first rowspan, will hide td tag.");
                td.hide();
            }
        }

        if (caEntity.isColSpan()) {
            log.debug("CaEntity is colspan.");
            if (caEntity.isFirstColSpan()) {
                log.debug("CaEntity is colspan && CaEntity is first colspan, will wrap td tag as <td colspan= {} > ", caEntity.getColSpan());
                td.setColspan(caEntity.getColSpan());
            } else {
                log.debug("CaEntity is colspan && CaEntity is not first colspan, will hide td tag.");
                td.hide();
            }
        }

        return td;

    }
}
