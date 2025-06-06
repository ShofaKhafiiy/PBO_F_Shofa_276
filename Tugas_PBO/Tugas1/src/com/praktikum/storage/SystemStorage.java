package com.praktikum.storage;

import com.praktikum.models.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.List;

public class SystemStorage {
    public static final List<User> userList = new ArrayList<>();
    public static final List<Item> reportedItems = new ArrayList<>();

    static {
        userList.add(new Admin("Admin", "Password123"));
        userList.add(new Mahasiswa("Shofa Khafidin", 202410370110276L));
    }
}
