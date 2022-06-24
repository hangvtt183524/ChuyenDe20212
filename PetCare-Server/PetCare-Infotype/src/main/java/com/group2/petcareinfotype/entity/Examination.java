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
@Table(name = "examination")
public class Examination implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long ownerId;

    private Long petId;

    private Long doctorId;

    private Integer startDate;

    private Integer endDate;

    private String firstDescription;

    private String result;
}
