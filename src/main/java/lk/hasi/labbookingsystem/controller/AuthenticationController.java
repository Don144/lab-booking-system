package lk.hasi.labbookingsystem.controller;


import lk.hasi.labbookingsystem.dto.AuthenticationResponse;
import lk.hasi.labbookingsystem.dto.LoginDto;
import lk.hasi.labbookingsystem.dto.RegisterRequestDto;
import lk.hasi.labbookingsystem.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authentication")
@CrossOrigin("*")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("/singIn")
  public ResponseEntity<?> signIn (@RequestBody LoginDto loginDto){
    AuthenticationResponse authenticate = authenticationService.authenticate(loginDto);
    return ResponseEntity.ok(authenticate);
  }

  @PostMapping("/singUp")
  public ResponseEntity<?> signUp (@RequestBody RegisterRequestDto registerRequestDto){

    AuthenticationResponse authenticate = authenticationService.singUp(registerRequestDto);

    return ResponseEntity.ok(authenticate);
  }

}
