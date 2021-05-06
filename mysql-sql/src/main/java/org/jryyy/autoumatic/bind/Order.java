package org.jryyy.autoumatic.bind;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Order {
    String[] value() default {};

    boolean isDesc() default false;
}
