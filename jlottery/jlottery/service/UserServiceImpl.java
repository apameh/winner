package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.model.User;
import ir.mapsa.jlottery.jlottery.respository.UserRepository;
import ir.mapsa.jlottery.jlottery.util.jwt.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User savedUser = userRepository.findById(user.getId()).orElseThrow();

        savedUser.setId(user.getId());
        savedUser.setUsername(user.getUsername());
        savedUser.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public ResponseEntity<String> generateToken(User user, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(),
                            user.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(token);
    }


}
