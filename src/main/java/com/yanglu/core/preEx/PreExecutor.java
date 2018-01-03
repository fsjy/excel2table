package com.yanglu.core.preEx;

import com.yanglu.entity.RawTable;
import org.apache.poi.ss.usermodel.Workbook;

public interface PreExecutor {

    RawTable execute(Workbook workbook);
}
