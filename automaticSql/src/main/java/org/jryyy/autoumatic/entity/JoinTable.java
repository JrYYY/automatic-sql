package org.jryyy.autoumatic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jryyy.autoumatic.constant.JoinTypeEnum;

/**
 * 表连接信息
 * @author OU
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinTable {

    /**
     * join com.mybatisOu.mysql information
     */
    private String join;

    /**
     *  and 连接
     */
    private String and;

    /**
     * or 连接
     */
    private String or;

    /**
     * join type 连接类型
     */
    private JoinTypeEnum joinType;

}