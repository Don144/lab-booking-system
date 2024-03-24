package lk.hasi.labbookingsystem.dto;

import lombok.Data;

@Data
public class TestDto {

    private Integer id;

    private String test_name;

    private String test_category;

    private Boolean avaliable;

    private TechniciansDTO techniciansDTO;
}
