package com.example.security.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {

    public static boolean validar(String username, String password){
        return  (username.equals("admin") && password.equals("admin"));
    }
}
