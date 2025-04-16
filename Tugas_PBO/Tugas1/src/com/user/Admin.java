package com.user;

public class Admin extends User{


    private static int jumlahAdmin = 0;
    private final String passAdmin;

    public Admin(String username, String passAdmin){
        super(username, "admin");
        this.passAdmin = passAdmin;
        jumlahAdmin++;
    }

    public Admin(String nama){
        this(nama, "admin123");
    }

    public String getPassAdmin(){
        return this.passAdmin;
    }


    @Override
    public boolean login(){
        return getName().equalsIgnoreCase("Admin") && getPassAdmin().equals("Admin123");
    }


    public static int getJumlahAdmin(){
        return jumlahAdmin;

    }



    public void aksesPanel(){
        System.out.println("Admin dapat akses penuh ke sistem kampus");
    }

    @Override
    public void afterLogin(){
        displayInfo();
        aksesPanel();
        System.out.println("Jumlah Admin: "+ getJumlahAdmin());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admin akses");
    }





    }



