package com.example.fileapi.models;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sample")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sample {
     @Id
     @UuidGenerator
     String id;

     @Column(name = "name")
     String name;

     @Column(name = "description")
     String description;

     @Column(name = "type")
     String type;

     @Column(name = "order_number")
     Integer orderNumber;
}
