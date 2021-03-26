package com.test;

import org.junit.Test;
import org.mybatisOu.mysql.exception.SqlInfoException;
import org.mybatisOu.mysql.generation.SplicingSqlProvider;
import org.mybatisOu.mysql.model.BaseModel;

public class TestString {

    @Test
    public void main()  {
        SplicingSqlProvider splicingSqlProvider = new SplicingSqlProvider();
        User user = User.builder().username("DOU1010").build();
        try {
            splicingSqlProvider.findMultipleData(new BaseModel<>(user));
        } catch (SqlInfoException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
