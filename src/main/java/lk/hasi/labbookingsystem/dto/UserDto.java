package lk.hasi.labbookingsystem.dto;


import lombok.Data;

@Data
public class UserDto {
  private Long id;
  private String password;
  private String userName;
  private String userType;
  private String userId;
}
