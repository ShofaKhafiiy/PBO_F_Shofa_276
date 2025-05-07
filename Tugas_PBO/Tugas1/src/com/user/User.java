package com.user;

public abstract class User {
    private String name;


    User(String nama){
        this.name = nama;

    }



    public final String getName(){
        return this.name;
    }

    public void setName(String name){
        if(name != null && !name.isEmpty()){
            this.name = name;
        }
    }


    public abstract boolean login();
    public abstract void afterLogin();

    public void displayInfo(){
        System.out.println("Nama: "+this.name);

    }


}
