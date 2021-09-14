package com.example.demo;

public class Person {

    Integer id =0;
    String name;
    Integer age;
    String poblation;

    public Person(){

    }

    public Person(Integer id, String name, Integer age, String poblation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.poblation = poblation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPoblation() {
        return poblation;
    }

    public void setPoblation(String poblation) {
        this.poblation = poblation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", poblation='" + poblation + '\'' +
                '}';
    }
}
