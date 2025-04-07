package com.admin;

public class Mahasiswa {

    private long nim;
    private String userMaha;

    public Mahasiswa(String userMaha, long nim){
        this.userMaha = userMaha;
        this.nim = nim;
    }

    public String getNama(){
        return this.userMaha;

    }

    public long getNim(){
        return this.nim;
    }

    public void displayMaha(){
        System.out.println("==[ MAHASISWA ]==");
        System.out.println("Nama: "+this.userMaha);
        System.out.println("NIM: " + nim);
    }

    public boolean login(String inputMaha, long inputNim){
        return getNama().equals(inputMaha) && getNim() == inputNim;
    }
}
