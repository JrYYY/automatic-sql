package org.jryyy.autoumatic.util;

import org.jryyy.autoumatic.entity.JoinTable;
import org.jryyy.autoumatic.exception.SqlInfoException;
import org.jryyy.autoumatic.sql.SQL;

import java.lang.reflect.Field;
import java.util.List;

public class SQLSelectSplicingUtil {

    public final static SQLSelectSplicingUtil now  = SQLSelectSplicingUtil.now();
    private static SQLSelectSplicingUtil now(){ return new SQLSelectSplicingUtil(); }
    private SQLSelectSplicingUtil(){}

    private ReflectModelUtil reflectModelUtil = new ReflectModelUtil() {
        @Override
        public String getColumnName(Field column) {
            return super.getColumnName(column);
        }
    };


    public <V> SQL start(Class model, V value, SQL sql) throws SqlInfoException {
        select(model,sql);
        table(model,sql);
        join(model,sql);
        return sql;
    }

    public SQL start(Class model,SQL sql) throws SqlInfoException {
        select(model,sql);
        table(model,sql);
        join(model,sql);
        return sql;
    }


    private SQLSelectSplicingUtil select(Class model,SQL sql) throws SqlInfoException {
        reflectModelUtil.getColumn(model).forEach(sql::SELECT);
        return this;
    }

    private SQLSelectSplicingUtil table(Class model,SQL sql) throws SqlInfoException {
        sql.FROM(reflectModelUtil.getTableName(model));
        return this;
    }

    private SQLSelectSplicingUtil join(Class model,SQL sql){
        Field[] columns = model.getDeclaredFields();
        for(Field column : columns){
            JoinTable joinTable = reflectModelUtil.getJoinTable(column);
        }
        return this;
    }


}
