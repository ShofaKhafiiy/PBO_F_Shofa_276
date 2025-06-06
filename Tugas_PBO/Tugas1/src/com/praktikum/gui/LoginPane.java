package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.praktikum.storage.SystemStorage;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

public class LoginPane {
    private final VBox view = new VBox(10);

    public LoginPane(Stage stage) {
        view.setPadding(new Insets(10));
        Label label = new Label("Login Sistem");
        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Admin", "Mahasiswa");
        roleBox.setValue("Admin");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Nama / Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password / NIM");

        TextField Latihan = new TextField();
        Latihan.setPromptText("ZZZZZZZ");

        Button loginBtn = new Button("Login");
        Label msg = new Label();

        Button logutBtn = new Button("Logut");

        loginBtn.setOnAction(e -> {
            String role = roleBox.getValue();
            String name = usernameField.getText().trim();
            String pass = passwordField.getText().trim();

            if (name.isEmpty() || pass.isEmpty()) {
                msg.setText("Semua field harus diisi!");
                return;
            }

            for (User user : SystemStorage.userList) {
                if (role.equals("Admin") && user instanceof Admin admin) {
                    if (admin.getName().equals(name) && admin.getPassAdmin().equals(pass)) {
                        AdminDashboard.show(stage, admin);
                        return;
                    }
                } else if (role.equals("Mahasiswa") && user instanceof Mahasiswa mhs) {
                    if (mhs.getName().equals(name) && Long.toString(mhs.getNim()).equals(pass)) {
                        MahasiswaDashboard.show(stage, mhs);
                        return;
                    }
                }
            }

            msg.setText("Login gagal! Data tidak ditemukan.");
        });

        view.getChildren().addAll(label, roleBox, usernameField, passwordField,logutBtn, loginBtn,  msg,Latihan);

    }

    public VBox getView() {
        return view;
    }
}
