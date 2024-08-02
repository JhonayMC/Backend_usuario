package com.jh.servrepo.controlador;

import com.jh.servrepo.modelo.User;
import com.jh.servrepo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/lista")
    public List<User> listarTodosLosUser() {
        return userService.listarTodosLosUser();
    }
    @GetMapping("lista/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }

    @PostMapping("/lista")
    public User GuardarUser(@RequestBody User user) {
        return userService.GuardarUser(user);
    }
    @PutMapping("/lista/{id}")
    public User ActualizarUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.ActualizaUser(id, userDetails);
    }

    @DeleteMapping("/lista/{id}")
    public void EliminarUser(@PathVariable Long id) {
        userService.EliminarUser(id);
    }

}
