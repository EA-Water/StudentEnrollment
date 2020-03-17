package miu.edu.studentenrollment.service.impl;

import miu.edu.studentenrollment.domain.User;
import miu.edu.studentenrollment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

       User user= userRepo.findByUserName(userName);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),getAuthorities(user));
    }

    public static Collection<? extends GrantedAuthority> getAuthorities(User user){
        String [] userRoles = user.getRoles().stream().map((role)->role.getRoleName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
