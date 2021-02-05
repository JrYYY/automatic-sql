package org.mybatisOu.mysql.generation;


import org.apache.ibatis.annotations.SelectProvider;
import org.mybatisOu.mysql.model.BaseModel;

import java.util.List;

/**
 * 未启用 test
 *
 * @author OU
 */
public interface MybatisBaseRepository<T> {


    @SelectProvider(type = SplicingSqlProvider.class, method = "findMultipleData")
    List<T> findDataByInfo(BaseModel<T> baseModel) throws Exception;


    T findDataById() throws Exception;

}
