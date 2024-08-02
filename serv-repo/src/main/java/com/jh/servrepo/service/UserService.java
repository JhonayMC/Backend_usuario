package com.jh.servrepo.service;

import com.jh.servrepo.modelo.User;
import com.jh.servrepo.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodosLosUser() {
        return userRepository.findAll();
    }

    //metodo para obtener los usuarios por su id
    public  User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public User GuardarUser(User user) {
        return userRepository.save(user);
    }

    public User ActualizaUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));

        user.setUsername(userDetails.getUsername());
        user.setLastname(userDetails.getLastname());

        return userRepository.save(user);
    }

    public void EliminarUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
        userRepository.delete(user);
    }
}
