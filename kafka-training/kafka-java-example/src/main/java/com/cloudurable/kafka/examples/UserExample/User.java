package com.cloudurable.kafka.examples.UserExample;

/**
 * Created by duu19572 on 17/10/2018.
 */
public class User {

    private String name;
    private int age;
    private String establishment;

    public User() {

    }

    public User(String name, int age, String establishment) {
        this.name = name;
        this.age = age;
        this.establishment = establishment;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEstablishment() { return this.establishment; }

    @Override public String toString() {
        return "User (" + name + ", " + age + ", " + establishment + ")";
    }
}
