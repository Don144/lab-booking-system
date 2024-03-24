package lk.hasi.labbookingsystem.dto;

import lombok.Data;

@Data
public class TestResultDTO {

    private Integer id;

    private String result_url;

    private String doctorName;

    private String patient_name;

    private String patient_address;

    private String patient_email;

    private Integer technicians_id;

    private String technicians_name;
}
