package com.gct.wms.service;

import com.gct.wms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidateService extends BaseService {

    @Autowired
    Validator validator;

    public <T> String validate(T p, Class... cls) {
        Set<ConstraintViolation<T>> validate = validator.validate(p, cls);
        for (ConstraintViolation<T> item : validate) {
            return item.getMessage();
        }
        return null;
    }
}
