package org.example.itop_admin.config;

import org.example.itop_admin.entity.User;
import org.example.itop_admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName MyUserDetailsService
 * @Author zhaoyb
 * @Date 2024-05-09
 * @Version 1.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("NOT FOUND: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
