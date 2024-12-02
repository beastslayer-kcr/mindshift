package com.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contactCustomer")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String fullName;

    @Column(name = "Mobile",nullable = false)
    private String contactNo;

    @Column(name = "Email",nullable = false)
    private String email;

    private String message;
}
