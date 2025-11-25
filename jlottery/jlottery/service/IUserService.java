package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.model.User;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IUserService {

    User save(User user);

    User update(User user);

    User findById(Long id);

    void delete(User user);

    List<User> findAll();

    ResponseEntity<String> generateToken(User user, HttpServletResponse response);

}
