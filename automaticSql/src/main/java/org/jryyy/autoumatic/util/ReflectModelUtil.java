package org.jryyy.autoumatic.util;

import org.jryyy.autoumatic.annotations.*;
import org.jryyy.autoumatic.constant.OperationEnum;
import org.jryyy.autoumatic.entity.InsertColumn;
import org.jryyy.autoumatic.entity.JoinTable;
import org.jryyy.autoumatic.exception.SqlInfoException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射模型类信息
 *
 * @author OU
 */
public abstract class ReflectModelUtil extends Resolve {


    /**
     * 获取注解列
     *
     * @param model 数据类型
     * @return 获取字段状态
     */
    public List<String> getColumn(Class model) {
        Field[] columns = model.getDeclaredFields();
        List<String> columnNames = new ArrayList<>();
        for (Field column : columns) {
            if (column.isAnnotationPresent(Column.class)) {
                columnNames.add(getColumnName(column)+" "+column.getName());
            } else {
                columnNames.add(column.getName());
            }
        }
        return columnNames;
    }

    /**
     * 获取注解列
     *
     * @param model 数据类型
     * @return 获取字段状态
     */
    public List<InsertColumn> getInsertColumn(Class model) {
        Field[] columns = model.getDeclaredFields();
        List<InsertColumn> columnNames = new ArrayList<>();
        for (Field column : columns) {
            if (column.isAnnotationPresent(Column.class)) {
                columnNames.add(InsertColumn.builder().var1(getColumnName(column))
                        .var2(placeholder(column)).build());
            } else {
                columnNames.add(InsertColumn.builder().var1(column.getName())
                        .var2(placeholder(column)).build());
            }
        }
        return columnNames;
    }

    /**
     * @param model
     * @return
     */
    public List<String> getUpdateColumn(Class model) {
        Field[] columns = model.getDeclaredFields();
        List<String> columnNames = new ArrayList<>();
        for (Field column : columns) { columnNames.add(getColumnName(column)+" = " +placeholder(column));    }
        return columnNames;
    }


    /**
     * 获取表
     *
     * @return 表名称
     * @throws SqlInfoException {@link SqlInfoException} 反写sql异常信息
     */
    public String getTableName(Class model) throws SqlInfoException {
        if (model.isAnnotationPresent(Table.class)) {
            Table table = (Table) model.getAnnotation(Table.class);
            if (table.value().isEmpty()) {
                throw new SqlInfoException("table 表名称不能为空");
            }
            return table.value();
        } else {
            throw new SqlInfoException("@Table 注解未标注");
        }
    }

    /**
     * join 连接 com.mybatisOu.mysql
     * 例：{@link @Join("user_info b on user.ID = b.userId") } join user_info b on user.ID = b.userId
     * {@link @Join(value = "user_info b on user.ID = b.userId",)}
     *
     * @return 连接表 join sql
     */
    public JoinTable getJoinTable(Field column) {
        JoinTable joinTable = null;
        if (column.isAnnotationPresent(Join.class)) {
            Join join = column.getAnnotation(Join.class);
            joinTable = JoinTable.builder()
                    .join(join.value() + " " + join.column() + " = " + getColumnName(column))
                    .and(join.and()).or(join.or()).joinType(join.joinType()).build();
        }
        return joinTable;
    }

    /**
     * 反射默认 条件sql
     * 例：
     * {@link @Condition(value = "b.username = #{data.useranme}")
     * private string username
     * }
     * 返回数据 ： b.username = #{data.username}
     *
     * @param column 列
     * @return 判单条件
     */
    public String splicingDefaultSql(Field column) {
        Where where = column.getAnnotation(Where.class);
        OperationEnum operation = where.operation();
        return where.value() + " " + operation.getSql();
    }

    /**
     * 反射单行 条件sql
     * 例：
     * {@link @Condition(value = "b.username ",operation = OperationEnum.EQUAL)
     * private string username
     * }
     * 返回数据 ： b.username = #{data.username}
     *
     * @param column 列
     * @return 判单条件
     */
    public String splicingSingleRowsSql(Field column) {
        Where where = column.getAnnotation(Where.class);
        OperationEnum operation = where.operation();
        String sqlString = where.value() + " " + operation.getSql();
        if (operation.equals(OperationEnum.LIKE)) {
            sqlString += " CONCAT('%'," + placeholder(column) + ",'%')";
        } else if (operation.equals(OperationEnum.LEFT_LIKE)) {
            sqlString += " CONCAT('%'," + placeholder(column) + ",'')";
        } else if (operation.equals(OperationEnum.RIGHT_LIKE)) {
            sqlString += " CONCAT(''," + placeholder(column) + ",'%')";
        } else {
            sqlString += placeholder(column);
        }
        return sqlString;
    }


    /**
     * 获取分组 列名
     *
     * @return 分组列名称
     */
    public List<String> getGroupColumnName(Class model) {
        List<String> groupColumns = new ArrayList<>();
        Field[] columns = model.getDeclaredFields();
        if (model.isAnnotationPresent(Group.class)) {
            Group group = (Group) model.getAnnotation(Group.class);
            groupColumns.addAll(Arrays.asList(group.value()));
        }
        for (Field column : columns) {
            if (column.isAnnotationPresent(Group.class)) {
                Group group = column.getAnnotation(Group.class);
                if (group.value().length != 0) {
                    groupColumns.addAll(Arrays.asList(group.value()));
                } else {
                    groupColumns.add(column.getName());
                }
            }
        }
        return groupColumns;
    }

    /**
     * 排序列名
     *
     * @return
     */
    public List<String> getModelOrderColumnName(Class model) {
        List<String> orderColumns = new ArrayList<>();

        return orderColumns;
    }

    public List<String> getValueOrderColumnName(Class value){
        List<String> orderColumns = new ArrayList<>();

        return orderColumns;
    }

    @Override
    public String placeholder(Field column) {
        return "#{" + column.getName() + "}";
    }

    /**
     * 获取当前列名
     *
     * @param column 列名
     * @return 列名
     * @throws SqlInfoException {@link SqlInfoException} 反写sql异常信息
     */
    @Override
    public String getColumnName(Field column) {
        String col = column.getAnnotation(Column.class).value();
        if (col.isEmpty()) {
            return column.getName();
        }
        return col;
    }
}
