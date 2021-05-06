package org.jryyy.autoumatic.entity;

import lombok.*;
import org.jryyy.autoumatic.exception.SqlInfoException;
import org.jryyy.autoumatic.sql.SQL;
import org.jryyy.autoumatic.util.SQLSelectSplicingUtil;

public class BaseEntity {

    private static SQL sqlEntity = new SQL();

    public BaseEntity()   {
        try {
            genSQL();
        } catch (SqlInfoException e) {
            e.printStackTrace();
        }
    }

    private SQL genSQL() throws SqlInfoException {
        return SQLSelectSplicingUtil.now.start(this.getClass(),sqlEntity);
    }

    public SQL getSQL(){
        return sqlEntity;
    }



}
