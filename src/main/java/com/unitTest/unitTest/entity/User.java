package com.unitTest.unitTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data@NoArgsConstructor
@Builder
@Table(name = "users") // Renaming table to "users"

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

}
