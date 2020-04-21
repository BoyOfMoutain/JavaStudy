package com.boye.copy;

public class DeepSubject implements Cloneable{
    private String name;

    public DeepSubject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Subject{DeepSubject: " + this.hashCode() +", name='" + name + '\'' + '}';
    }
}
