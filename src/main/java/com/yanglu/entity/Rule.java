package com.yanglu.entity;

import com.yanglu.validate.Validator;

import java.util.ArrayList;
import java.util.List;


public class Rule {

    // check规则一览
    List<Validator> validatorList = new ArrayList<>();

    public Rule add(Validator validator) {
        this.validatorList.add(validator);
        return this;
    }

    public List<Validator> getValidatorList() {
        return validatorList;
    }

    public void setValidatorList(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

}
