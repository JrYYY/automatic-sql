package org.jryyy.autoumatic.bind;

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
    /**
     * 连接表名称
     *
     * @return 表名称
     */
    String[] value();

    /**
     * @return 连接方式
     */
    JoinTypeEnum[] joinType() default JoinTypeEnum.JOIN;
}
