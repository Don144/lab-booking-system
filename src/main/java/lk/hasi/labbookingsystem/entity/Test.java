package lk.hasi.labbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String test_name;

    private String test_category;

    private Boolean avaliable;

    @ManyToOne
    @JoinColumn(name="tech_id", nullable=false)
    private Technicians technicians;
}
