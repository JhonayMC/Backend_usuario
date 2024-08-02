package com.web.webbd.controlador;

import com.web.webbd.modelo.User;
import com.web.webbd.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Listar todos los empleados
    @GetMapping("/lista")
    public List<User> listarTodosLosUser() {
        return userRepository.findAll();
    }
    @PostMapping("/lista")
    public User GuardarUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/lista/{id}")
    public User ActualizarUser(@PathVariable Long id, @RequestBody User userDetails) {

        User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));

        user.setUsername(userDetails.getUsername());
        user.setLastname(userDetails.getLastname());

        return userRepository.save(user);
    }

    @DeleteMapping("/lista/{id}")
    public void eliminarUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
        userRepository.delete(user);
    }


}

