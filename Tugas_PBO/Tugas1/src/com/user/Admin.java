package com.user;

public class Admin extends User{


    private static int jumlahAdmin = 0;
    private  String passAdmin;

    public Admin(String username, String passAdmin){
        super(username, "Admin");
        this.passAdmin = passAdmin;
        jumlahAdmin++;
    }

    public Admin(String nama){
        this(nama, "Password123");
    }

    public String getPassAdmin(){
        return this.passAdmin;
    }

    public void setPassAdmin(String password){
       if (password != null && !password.isEmpty()){
            this.passAdmin = password;
       }
    }



    @Override
    public boolean login(){
        return getName().equals("Admin") && getPassAdmin().equals("Password123");
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



