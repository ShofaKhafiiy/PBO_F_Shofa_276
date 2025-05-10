package com.praktikum.users;

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

    //menambahkan abstract display menu
    public abstract void displayMenu();

    public void displayInfo(){
        System.out.println("Nama: "+this.name);

    }

    


}
