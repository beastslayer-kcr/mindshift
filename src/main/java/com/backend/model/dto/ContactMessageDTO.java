package com.backend.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageDTO {
    @Column(name = "Name", nullable = false)
    private String fullName;

    @Column(name = "Mobile",nullable = false)
    private String contactNo;

    @Column(name = "Email",nullable = false)
    private String email;

    private String message;
}
