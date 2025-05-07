package com.user;

public class Mahasiswa extends User {


    private long nim;




    public Mahasiswa(String userMaha, long nim) {
        super(userMaha);
        this.nim = nim;

    }




    public long getNim() {
        return this.nim;
    }

    public void setNim(long nim) {
        this.nim = nim;}




   @Override
    public boolean login(){
        return getName().equals("Shofa Khafidin") && this.nim == 202410370110276L;
    }



    @Override
    public void afterLogin(){
        displayInfo();

    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("NIM: "+ getNim());
        System.out.println("Status Mahasiswa Aktif");
    }

    }


