package lk.hasi.labbookingsystem.dto;

import lombok.Data;

@Data
public class TechniciansDTO {

    private Integer tech_id;

    private String tech_name;

    private String tech_email;

    private String tech_specialization;

    private boolean availability;

    private Integer max_appointment_count;

    private String NIC;
}
