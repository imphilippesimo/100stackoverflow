package com.zerofiltre.stackoverflow.q_66483932_5615357_security;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {


  @PostConstruct
  public void init(){
    System.out.println("Initializing...");
  }

  @Override
  public UserDetails loadUserByUsername(String emailOrPhoneNumber) {

    List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        .commaSeparatedStringToAuthorityList("ROLE_ADMIN");

    return new User("philippesimo@zerofiltre.tech", "password", grantedAuthorities);
  }

}
