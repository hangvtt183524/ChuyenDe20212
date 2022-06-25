package com.group2.petcareinfotype.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String doctorName;

    private String password;

    private String phone;

    private String mail;

    private String birthDate;

    private String address;

    private String major;
}
