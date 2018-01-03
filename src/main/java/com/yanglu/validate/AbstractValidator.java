package com.yanglu.validate;

import com.yanglu.entity.Rule;
import java.util.List;

public class AbstractValidator implements Validator {

    public List<String> validate() {
        return null;
    }

    @Override
    public boolean support(Rule rule) {

        if (rule == null || rule.getValidatorList().size() == 0) {
            return false;
        }

        for (int i = 0; i < rule.getValidatorList().size(); i++) {
            Validator v = rule.getValidatorList().get(i);

            if (this.getClass() == v.getClass()) {
                return true;
            }

        }

        return false;
    }
}
