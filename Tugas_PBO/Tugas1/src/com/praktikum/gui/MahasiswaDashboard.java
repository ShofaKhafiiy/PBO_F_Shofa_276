package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.praktikum.models.Item;
import com.praktikum.storage.SystemStorage;
import com.praktikum.users.Mahasiswa;

public class MahasiswaDashboard {
    public static void show(Stage stage, Mahasiswa mhs) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label welcome = new Label("Halo, " + mhs.getName());
        TextField namaBarang = new TextField();
        namaBarang.setPromptText("Nama Barang");

        TextField deskripsi = new TextField();
        deskripsi.setPromptText("Deskripsi");

        TextField lokasi = new TextField();
        lokasi.setPromptText("Lokasi");

        Button lapor = new Button("Laporkan Barang");
        Label info = new Label();

        lapor.setOnAction(e -> {
            String nama = namaBarang.getText();
            String desk = deskripsi.getText();
            String lok = lokasi.getText();

            if (!nama.isEmpty() && !desk.isEmpty() && !lok.isEmpty()) {
                SystemStorage.reportedItems.add(new Item(nama, desk, lok));
                info.setText("Barang berhasil dilaporkan!");
                namaBarang.clear();
                deskripsi.clear();
                lokasi.clear();
            } else {
                info.setText("Semua field wajib diisi!");
            }
        });

        Button logout = new Button("Logout");
        logout.setOnAction(e -> {
            LoginPane login = new LoginPane(stage);
            stage.setScene(new Scene(login.getView(), 400, 250));
        });

        root.getChildren().addAll(welcome, namaBarang, deskripsi, lokasi, lapor, info, logout);
        stage.setScene(new Scene(root, 400, 350));
    }
}
