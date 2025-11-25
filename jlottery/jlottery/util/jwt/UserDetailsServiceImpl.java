package ir.mapsa.jlottery.jlottery.util.jwt;

import ir.mapsa.jlottery.jlottery.model.User;
import ir.mapsa.jlottery.jlottery.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return new User(
                user.getId(),
                user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()),
                user.getRoles()
        );
    }

}
