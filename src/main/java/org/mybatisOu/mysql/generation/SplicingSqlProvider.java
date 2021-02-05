package org.mybatisOu.mysql.generation;

import org.apache.ibatis.jdbc.SQL;
import org.mybatisOu.mysql.exception.SqlInfoException;
import org.mybatisOu.mysql.model.BaseModel;

public class SplicingSqlProvider {

    public String findMultipleData(BaseModel baseModel) throws SqlInfoException, IllegalAccessException {
        Class model = baseModel.getDateClass();
        String sql = GenerateSqlStringUtil.start(new SQL(), model, baseModel.getData())
                .column().table().join().where().group().order().toString();
        System.out.println(sql);
        return sql;
    }

}
