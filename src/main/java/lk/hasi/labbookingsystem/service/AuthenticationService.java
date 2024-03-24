package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.AuthenticationResponse;
import lk.hasi.labbookingsystem.dto.LoginDto;
import lk.hasi.labbookingsystem.dto.RegisterRequestDto;

public interface AuthenticationService {

  AuthenticationResponse authenticate(LoginDto loginDto);
  AuthenticationResponse singUp(RegisterRequestDto registerRequestDto);
}
