package com.example.fileapi.services;

import java.util.List;

import com.example.fileapi.dto.SampleDto;
import com.example.fileapi.dto.SampleRequestDto;

public interface SampleService {
    String add(SampleDto dto);

    // Logika a Sandi
    // String add2(String name);

    String remove(String id);

    List<SampleDto> view(String name);

    String update(String id , SampleRequestDto dto);

    SampleDto findById(String id);
    // String checkName(String name);

    // boolean checkName2(String name);

}
