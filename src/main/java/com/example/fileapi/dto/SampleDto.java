package com.example.fileapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleDto {
    private String id;
    private String name;
    private String description;
    private String type;
    private Integer orderNumber;
}
