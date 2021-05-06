package org.jryyy.autoumatic.generation;

import org.apache.ibatis.jdbc.SQL;
import org.jryyy.autoumatic.exception.SqlInfoException;
import org.jryyy.autoumatic.model.BaseModel;

public class SplicingSqlProvider {

    public String findMultipleData(BaseModel baseModel) throws SqlInfoException, IllegalAccessException {
        Class model = baseModel.getDateClass();
        String sql = GenerateSqlStringUtil.start(new SQL(), model, baseModel.getData())
                .column().table().join().where().group().order().toString();
        System.out.println(sql);
        return sql;
    }

}
