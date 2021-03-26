package org.mybatisOu.mysql.generation;

import org.apache.ibatis.jdbc.SQL;
import org.mybatisOu.mysql.exception.SqlInfoException;
import org.mybatisOu.mysql.model.BaseModel;

public class SplicingSqlProvider {

    public String findMultipleData(BaseModel baseModel) throws SqlInfoException, IllegalAccessException {
        Class model = baseModel.getValueClass();
        Class condition = baseModel.getConditionClass();
        String sql = null;
        System.out.println(sql);
        return sql;
    }

    public <T,V> String find(T data,V info)throws  SqlInfoException, IllegalAccessException {
        return null;
    }

}
