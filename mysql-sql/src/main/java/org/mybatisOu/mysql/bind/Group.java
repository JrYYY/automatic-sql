package org.mybatisOu.mysql.bind;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Group {

    /**
     * 分组直段
     */
    String[] value() default {};
}
