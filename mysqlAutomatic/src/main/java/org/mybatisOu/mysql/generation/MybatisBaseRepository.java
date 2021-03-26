package org.mybatisOu.mysql.generation;


import org.apache.ibatis.annotations.SelectProvider;
import org.mybatisOu.mysql.model.BaseModel;

import java.util.List;

/**
 * 未启用 test
 *
 * @author OU
 */
public interface MybatisBaseRepository<T,V> {


    @SelectProvider(type = SplicingSqlProvider.class, method = "findMultipleData")
    List<V> findDataByInfo(BaseModel<T, V> baseModel) throws Exception;


    V findDataById() throws Exception;

//    @SelectProvider()
    List<V> findData()throws Exception;

}
