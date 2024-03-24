package lk.hasi.labbookingsystem.service.impl;


import lk.hasi.labbookingsystem.dto.AuthenticationResponse;
import lk.hasi.labbookingsystem.dto.LoginDto;
import lk.hasi.labbookingsystem.dto.RegisterRequestDto;
import lk.hasi.labbookingsystem.dto.UserDto;
import lk.hasi.labbookingsystem.repo.UserRepository;
import lk.hasi.labbookingsystem.entity.Doctors;
import lk.hasi.labbookingsystem.security.AutUserDetailsImpl;
import lk.hasi.labbookingsystem.security.JWTServiceImpl;
import lk.hasi.labbookingsystem.service.AuthenticationService;
import lk.hasi.labbookingsystem.service.DoctorService;
import lk.hasi.labbookingsystem.service.PatientService;
import lk.hasi.labbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private JWTServiceImpl jwtService;

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private PatientService patientService;
  
  @Autowired
  AutUserDetailsImpl autUserDetails;

  @Autowired
  DoctorService doctorService;

  @Autowired
  private UserRepository userRepository;

  @Override
  public AuthenticationResponse authenticate(LoginDto loginDto) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginDto.getUserName(),
            loginDto.getPassword()
        )
    );


    UserDto userDto = userService.findByUser(loginDto.getUserName());
    String jwtToken = jwtService.generateToken(new User(userDto.getUserName(),userDto.getPassword(),new ArrayList<>()));
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .tokenType("Bearer")
        .userid(userDto.getUserId())
        .userType(userDto.getUserType())
        .status("200")
        .build();
  }

  @Override
  public AuthenticationResponse singUp(RegisterRequestDto registerRequestDto) {
    UserDto userDto = new UserDto();

    if(registerRequestDto.getUserType().equalsIgnoreCase("PATIENT")){
//      Patient patient = new Patient();
//      patient.setName(registerRequestDto.getName());
//      patient.setAddress(registerRequestDto.getAddress());
//      patient.setEmail(registerRequestDto.getEmail());
//      patient.setAge(Integer.parseInt(registerRequestDto.getAge()));
//      patient.setGender(registerRequestDto.getGender());
//      patient.setNIC(registerRequestDto.getNic());
//      patient.setEmail(registerRequestDto.getEmail());


//      patientService.patientRegistration(patient);
//
//      userDto.setUserId(patient.getId().toString());

    }else if(registerRequestDto.getUserType().equalsIgnoreCase("DOCTOR")){
      Doctors doctors = new Doctors();
      doctors.setNIC(registerRequestDto.getNic());
      doctors.setDoctor_email(registerRequestDto.getEmail());
      doctors.setDoctor_name(registerRequestDto.getName());
      doctors.setAvailability(true);
      doctors.setMax_appointment_count(registerRequestDto.getDoctorMaxAppointment());
      doctors.setDoctor_specialization(registerRequestDto.getDoctorSpecialization());

      doctorService.doctorRegistration(doctors);
      userDto.setUserId(doctors.getId().toString());
    }



    userDto.setUserName(registerRequestDto.getUserName());
    userDto.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
    userDto.setUserType(registerRequestDto.getUserType());


    userService.saveUser(userDto);

    UserDetails userDetails = new User(userDto.getUserName(),userDto.getPassword(),new ArrayList<>());
    String jwtToken = jwtService.generateToken(userDetails);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .tokenType("Bearer")
        .userid(userDto.getUserId())
        .userType(userDto.getUserType())
        .status("200")
        .build();
  }
}
