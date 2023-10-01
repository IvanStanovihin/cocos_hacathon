package ru.stanovihin.cocos.models.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
public class CompanyFond {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fondName;
    private Integer current;
    private Integer goal;
}
