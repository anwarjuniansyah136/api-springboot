package com.example.fileapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SampleRequestDto {
    private String name;
    private String description;
    private String type;
    private Integer orderNumber;
}
