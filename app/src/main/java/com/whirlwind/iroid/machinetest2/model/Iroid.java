package com.whirlwind.iroid.machinetest2.model;

/**
 * Created by Acer on 27-Jul-17.
 */

public class Iroid {


    int id;
    String name;
    String place;
    String age;
    String phone;
    String qualification;



    public Iroid(){   }


    public Iroid(int id, String name, String place, String age, String phone, String qualification){
        this.id = id;
        this.name = name;
        this.place = place;
        this.age = age;
        this.phone = phone;
        this.qualification = qualification;

    }


    public Iroid(String name, String age, String phone){
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
