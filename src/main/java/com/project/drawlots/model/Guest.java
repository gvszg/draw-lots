package com.project.drawlots.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Builder
@Table(name = "guests")
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, length = 128)
    private String username;
    @Column(name = "age", nullable = false)
    private int age;
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private Instant createTime;
    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private Instant updateTime;
}
