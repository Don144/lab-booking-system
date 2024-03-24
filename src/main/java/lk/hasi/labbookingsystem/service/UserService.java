package lk.hasi.labbookingsystem.service;


import lk.hasi.labbookingsystem.dto.UserDto;

public interface UserService {

  void saveUser(UserDto userDto);

  UserDto findByUser(String userName);
}
