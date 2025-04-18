package com.user;

public class Mahasiswa extends User {


    private long nim;
    private static int jumlahMahasiswa = 0;

    private String name;

    public Mahasiswa(String userMaha, long nim) {
        super(userMaha, "Mahasiswa");
        this.nim = nim;
        jumlahMahasiswa++;
    }

    public Mahasiswa(String name) {
        this(name, 0L);
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

    public static  int getJumlahMahasiswa(){
        return jumlahMahasiswa;
    }

    @Override
    public void afterLogin(){
        displayInfo();
        System.out.println("Jumlah mahasiswa: "+getJumlahMahasiswa());
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("NIM: "+ getNim());
        System.out.println("Status Mahasiswa Aktif");
    }

    }


