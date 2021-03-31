package org.jryyy.autoumatic.genera;

import org.jryyy.autoumatic.entity.BaseEntity;
import org.jryyy.autoumatic.entity.PagingInfo;
import org.jryyy.autoumatic.exception.SqlInfoException;
import org.jryyy.autoumatic.sql.SQL;
import org.jryyy.autoumatic.util.SQLSelectSplicingUtil;

public class ParseSql {

    private SQLSelectSplicingUtil selectUtil = SQLSelectSplicingUtil.now;

    public <V> String findDataByInfo(Class model, V value) throws SqlInfoException {
        return selectUtil.start(model,value,new SQL()).toString();
    }

    public <T extends  BaseEntity> String findDataById(Class<T> model,Long id) throws SqlInfoException{
        return selectUtil.start(model,new SQL()).toString();
    }

    public  String findDataByAll(Class model) throws SqlInfoException{
        return selectUtil.start(model,new SQL()).toString();
    }

    public <T, V extends PagingInfo> String findDataByPage(T data, V value) throws SqlInfoException {
        return null;
    }

    public <T> String insertData(T data) throws SqlInfoException {
        return null;
    }

}
