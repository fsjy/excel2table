package com.yanglu.validate;

import com.yanglu.entity.Rule;

import java.util.List;

public interface Validator {

    List<String> validate();

    boolean support(Rule rule);
}
