package jhvt.jwtautorizacion.Demo;


import jhvt.jwtautorizacion.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "demo")
    public String welcomePost(@RequestBody User user) {
        StringBuilder response = new StringBuilder();
        response.append(user.getUsername()).append(" bienvenido\n");
        response.append("Eres parte de esta familia.");
        return response.toString();
    }

    @GetMapping(value = "demo")
    public String welcomeGet() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) authentication.getPrincipal();

        // Aquí puedes construir la respuesta deseada
        StringBuilder response = new StringBuilder();
        response.append("Welcome\n");
        response.append("Username: ").append(userDetails.getUsername()).append("\n");
        response.append("First Name: ").append(userDetails.getFirstname()).append("\n");
        response.append("Last Name: ").append(userDetails.getLastname()).append("\n");
        response.append("Country: ").append(userDetails.getCountry()).append("\n");

        return response.toString();
    }
}
