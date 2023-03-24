package dio.diospringsecurity.init;

import dio.diospringsecurity.model.User;
import dio.diospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.transaction.Transactional;

public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if(user == null){
            user = new User();
            user.setNome("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            userRepository.save(user);
        }
        user = userRepository.findByUsername("user");
        if(user == null){
            user = new User();
            user.setNome("USERS");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            userRepository.save(user);
        }
    }
}
