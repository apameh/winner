package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.model.User;
import ir.mapsa.jlottery.jlottery.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User user, HttpServletResponse response) {
        return userService.generateToken(user, response);
    }

    @PostMapping("/add-prize")
    @Secured(value = "ADMIN")
    public ResponseEntity<?> addPrize() {
        return null;
    }


}
