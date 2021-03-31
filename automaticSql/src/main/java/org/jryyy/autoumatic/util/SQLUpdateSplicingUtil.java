package org.jryyy.autoumatic.util;

public class SQLUpdateSplicingUtil {
    public final static SQLUpdateSplicingUtil now  = SQLUpdateSplicingUtil.now();
    private static SQLUpdateSplicingUtil now(){ return new SQLUpdateSplicingUtil(); }
    private SQLUpdateSplicingUtil(){}
}
