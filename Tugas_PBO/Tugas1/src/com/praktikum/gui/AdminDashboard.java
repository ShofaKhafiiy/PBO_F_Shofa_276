package com.praktikum.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.praktikum.models.Item;
import com.praktikum.storage.SystemStorage;
import com.praktikum.users.Admin;

public class AdminDashboard {
    public static void show(Stage stage, Admin admin) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label welcome = new Label("Selamat datang, Admin " + admin.getName());

        TableView<Item> table = new TableView<>();
        ObservableList<Item> data = FXCollections.observableArrayList(SystemStorage.reportedItems);

        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getItemName()));
        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        descCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescription()));
        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");
        locCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getLocation()));
        TableColumn<Item, String> statCol = new TableColumn<>("Status");
        statCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getStatus()));

        table.getColumns().addAll(nameCol, descCol, locCol, statCol);
        table.setItems(data);

        Button deleteClaimed = new Button("Hapus Barang 'Claimed'");
        deleteClaimed.setOnAction(e -> {
            data.removeIf(item -> item.getStatus().equalsIgnoreCase("Claimed"));
            SystemStorage.reportedItems.removeIf(item -> item.getStatus().equalsIgnoreCase("Claimed"));
        });

        Button logout = new Button("Logout");
        logout.setOnAction(e -> {
            LoginPane login = new LoginPane(stage);
            stage.setScene(new Scene(login.getView(), 400, 250));
        });

        root.getChildren().addAll(welcome, table, deleteClaimed, logout);
        stage.setScene(new Scene(root, 600, 400));
    }
}
