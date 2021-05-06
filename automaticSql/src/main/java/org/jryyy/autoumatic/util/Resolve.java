package org.jryyy.autoumatic.util;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Resolve {
    /**
     * 获取参数名称
     * @param column    列
     */
    public abstract String placeholder(Field column);

    public abstract String getColumnName(Field column);

    /**
     *  驼峰式名称 转换为 下划线名称
     * @param camelName  名称
     * @return  下划线名称；例：“camelName”->“came_name”
     */
    public String camelToUnderscore(String camelName){
        StringBuilder camelNameBuilder = new StringBuilder();
        if(isCamel(camelName)){
            for (int i = 0;i <  camelName.length(); i++){
                char c = camelName.charAt(i);
                if(Character.isUpperCase(c)){
                    camelNameBuilder.append("_").append(c);
                }else {
                    camelNameBuilder.append(c);
                }
            }
            return camelNameBuilder.toString();
        }
        return camelName;
    }

    /**
     * 是否驼峰名称
     * @param name  名称
     * @return 判断驼峰true/false
     */
    public boolean isCamel(String name){
        String regex = "^([a-z])$|^(([a-z|0-9]+[A-Z]?)+[a-z|0-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
}
