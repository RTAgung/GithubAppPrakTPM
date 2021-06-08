package com.example.githubapp.utils;

public class Helper {
    public static boolean loginVerification(String username, String password) {
        boolean verification = false;
        if (username.equals("RTAgung") && password.equals("12345678")) {
            verification = true;
        } else if (username.equals("Munadia34") && password.equals("12345678")) {
            verification = true;
        }
        return verification;
    }
}
