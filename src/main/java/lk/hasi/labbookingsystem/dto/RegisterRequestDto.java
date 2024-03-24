package lk.hasi.labbookingsystem.dto;


import lombok.Data;

@Data
public class RegisterRequestDto {
  private Long id;
  private String password;
  private String userName;
  private String userType;
  private String userId;
  private String name;
  private String telNumber;
  private String address;
  private String email;
  private String gender;
  private String age;
  private String nic;
  private Integer doctorMaxAppointment;
  private String doctorSpecialization;
}
