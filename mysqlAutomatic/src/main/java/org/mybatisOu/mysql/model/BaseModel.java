package org.mybatisOu.mysql.model;

public class BaseModel<T,V> {

    private T condition;

    private V value;

    public BaseModel(V value) {
        this.value = value;
    }

    public BaseModel(T condition, V value) {
        this.condition = condition;
        this.value = value;
    }


    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Class getConditionClass(){
        return this.condition.getClass();
    }

    public Class getValueClass(){
        return this.value.getClass();
    }
}

