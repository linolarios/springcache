package com.workshop.cache.model;

import java.util.Objects;

public class Admin {

    private boolean isAdmin = true;
    private String userName;
    private String email;
    private String[] permissions;

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Admin)) {
            return false;
        }

        Admin admin = (Admin) o;
        return admin.getUserName().equals(userName) && admin.getEmail().equals(email) && admin.getPermissions() == getPermissions();
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, email, permissions);
    }
}
