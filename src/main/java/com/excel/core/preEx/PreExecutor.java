package com.excel.core.preEx;

import com.excel.entity.RawTable;
import org.apache.poi.ss.usermodel.Workbook;

public interface PreExecutor {

    RawTable execute(Workbook workbook);
}
