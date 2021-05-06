import entity.User;
import org.jryyy.autoumatic.exception.SqlInfoException;
import org.jryyy.autoumatic.genera.ParseSql;
import org.jryyy.autoumatic.sql.SQL;
import org.junit.Test;

public class TestSqlSpring {

    private ParseSql parseSql = new ParseSql();

    @Test
    public void test() throws SqlInfoException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        String s = new User().getSQL().toString();
        System.out.println(s);
//        System.out.println(parseSql.findDataByInfo(User.class,new User()));
    }

    @Test
    public void test1(){
        System.out.println(new SQL().ORDER_BY("ID").WHERE("USER = 1").toString());
    }


}
