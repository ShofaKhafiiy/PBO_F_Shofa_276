package com.user;

public abstract class User {
    private String name;
    private final String role;

    User(String nama, String role){
        this.name = nama;
        this.role = role;
    }

    public  final String getRole(){
        return this.role;
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
        System.out.println("Role: "+this.role);
    }


}
