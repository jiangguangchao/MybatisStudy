package com.jgc.bean;

/**
 * @description:
 * @author:jgc
 * @create:2020-04-08 21:24
 */
public class Person {
    private Integer ID;
    private String lastName;
    private String addr;
    private Integer gender;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", lastName='" + lastName + '\'' +
                ", addr='" + addr + '\'' +
                ", gender=" + gender +
                '}';
    }
}
