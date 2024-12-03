package com.backend.confee.service;

import com.backend.confee.entity.AllUsers;
import com.backend.confee.repo.AllUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AllUserDetailsService implements UserDetailsService {
    @Autowired
    private AllUsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepo.findByEmail(username).orElseThrow();
    }
    public Integer getUserIdByEmail(String email) {
        Optional<AllUsers> user = usersRepo.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getId(); // Return the user ID if found
        }
        throw new IllegalArgumentException("User with email " + email + " not found");
    }

}
