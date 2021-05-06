package org.jryyy.autoumatic.annotations;

import org.jryyy.autoumatic.constant.JoinTypeEnum;

import java.lang.annotation.*;

/**
 * join com.mybatisOu.mysql
 *
 * @author OU
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Join {
    /**；；；；/
     * @return 表名称
     */
    String value();

    /**
     * @return 字段名
     */
    String column();

    /**
     * @return 并连接条件
     */
    String and() default "";

    /**
     * @return 或连接条件
     */
    String or() default "";

    /**
     * @return 连接方式
     */
    JoinTypeEnum joinType() default JoinTypeEnum.JOIN;
}
