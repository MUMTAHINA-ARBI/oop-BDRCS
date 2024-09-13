package cse213.normalizedtransactionclasses;

import java.io.Serializable;

public class LoginCredential implements Serializable {
    private int userId; //foreign field
    private String password, userType;

    public LoginCredential() {
    }

    public LoginCredential(int userId, String password, String userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "LoginCredential{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
