package lk.hasi.labbookingsystem.security;


import lk.hasi.labbookingsystem.dto.UserDto;
import lk.hasi.labbookingsystem.repo.UserRepository;
import lk.hasi.labbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutUserDetailsImpl implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDto userDto = userService.findByUser(username);
    UserDetails userDetails = new User(userDto.getUserName(),userDto.getPassword(),new ArrayList<>());

    return userDetails;

  }
}
