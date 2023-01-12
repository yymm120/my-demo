package com.jsr303validator;

import com.jsr303validator.validation.mylistvalidate.ValidDuplicate;
import com.jsr303validator.vo.DuplicateRequest;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import javax.validation.*;
import java.lang.reflect.Method;
import java.util.Set;

@SpringBootTest
public class DemoValidate {

    @Test
    void test1() throws NoSuchMethodException {
        DuplicateRequest duplicateRequest = new DuplicateRequest("");
        // ValidatorFactory validatorFactory = Validation.byDefaultProvider()
        //         .configure()
        //         .messageInterpolator((MessageInterpolator) new ParameterMessageInterpolator())
        //         .buildValidatorFactory();
        // Validator validator = validatorFactory.getValidator();
        // Set<ConstraintViolation<DuplicateRequest>> validate = validator.validate(duplicateRequest);
        // Method testValidate = DemoValidate.class.getMethod("testValidate", DuplicateRequest.class);
        // Class<?>[] parameterTypes = testValidate.getParameterTypes();
        // testValidate
        // System.out.println(validate);
        testValidate(new DuplicateRequest(null));
    }

    void testValidate(@Validated DuplicateRequest duplicateRequest) {
        ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator((MessageInterpolator) new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DuplicateRequest>> validate = validator.validate(duplicateRequest);
        System.out.println(validate);
    }
}
