package com.example.optimize_layout_xml.optimizations.recyclerview;

public class Person {
    private String name;
    private String email;
    private String phone;
    private int avatarResId;

    public Person(String name, String email, String phone, int avatarResId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}
