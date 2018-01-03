package com.excel.validate;

import com.excel.entity.Rule;

import java.util.List;

public interface Validator {

    List<String> validate();

    boolean support(Rule rule);
}
