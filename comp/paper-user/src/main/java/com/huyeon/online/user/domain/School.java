package com.huyeon.online.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sp_school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    private String name;

    private String city;

    @Transient
    private Long teacherCount;

    @Transient
    private Long studyCount;

    @Column(updatable = false)
    private LocalDateTime created;

    private LocalDateTime updated;

}
