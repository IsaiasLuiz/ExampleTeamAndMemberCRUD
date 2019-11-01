package com.example.demo.unitary.domain.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@SequenceGenerator(name = "id_team_sequence", initialValue = 11)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter

public class Team {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_team_sequence")
    @Column(name = "id_team")
    @Id
    private Long id;

    @NotBlank
    private String name;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "team", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members;

}
