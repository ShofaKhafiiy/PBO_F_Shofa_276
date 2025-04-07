package com.admin;

public class Admin {

    private String username, passAdmin;

    public Admin(String username, String passAdmin){
        this.username = username;
        this.passAdmin = passAdmin;
    }

    public void display(){
        System.out.println("==[ ADMIN ]==");
        System.out.println("Nama: "+this.username);
        System.out.println("Login admin berhasil!");
    }

    public String getName(){
        return this.username;
    }

    public String getPass(){
        return this.passAdmin;
    }

    public  boolean login(String inputNama, String inputPass){
        return getName().equals(inputNama) && getPass().startsWith(inputPass);
    }


}
