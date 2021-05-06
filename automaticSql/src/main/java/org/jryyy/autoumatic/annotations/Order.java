package org.jryyy.autoumatic.annotations;

import java.lang.annotation.*;

/**
 * 排序
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Order {


    /**
     * @return false:升序 true:降序
     */
    boolean value() default false;
}
