package com.example.fileapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fileapi.dto.SampleDto;
import com.example.fileapi.dto.SampleRequestDto;
import com.example.fileapi.models.Sample;
import com.example.fileapi.repositories.SampleRepository;

@Service
public class SampleServiceImp implements SampleService {

    @Autowired
    SampleRepository sampleRepository;

    List<Sample> samples = new ArrayList<>();

    // @Override
    // public String add(SampleDto dto) {
    // sampleRepository.save(Sample.builder().name(dto.getName()).description(dto.getDescription()).type(dto.getType())
    // .orderNumber(dto.getOrderNumber()).build());

    // return "Successfully add sample to list";
    // }

    @Override
    public String add(SampleDto dto) {

        // samples.add(Sample.builder().id(dto.getId()).name(dto.getName()).description(dto.getDescription()).build());
        // Sample sample=
        // Sample.builder().name(dto.getName()).description(dto.getDescription()).type(dto.getType()).orderNumber(dto.getOrderNumber()).build();

        Sample sample = new Sample();
        sample.setName(dto.getName());
        sample.setDescription(dto.getDescription());
        sample.setType(dto.getType());
        sample.setOrderNumber(dto.getOrderNumber());
        sampleRepository.save(sample);
        return "Successfully add new sample to list";
    }

    @Override
    public String remove(String id) {
        Sample sample = sampleRepository.findById(id).orElse(null);
        if (sample != null) {
            sampleRepository.delete(sample);
            return "Successfully remove sample from list";

        } else {
            return "Id not Found";
        }
        // samples.stream()
        // .filter(sample -> sample.getId() == id)
        // .findFirst()
        // .ifPresent(sample -> samples.remove(sample));

    }

    @Override
    public List<SampleDto> view(String name) {

        return sampleRepository.findAllOrderByOrderNumberConditionalUsingHql(name).stream().map(this::toSampleDto)
                .toList();
    }

    public SampleDto toSampleDto(Sample sample) {
        return SampleDto.builder().id(sample.getId()).name(sample.getName()).description(sample.getDescription())
                .type(sample.getType()).orderNumber(sample.getOrderNumber()).build();
    }

    @Override
    public String update(String id, SampleRequestDto dto) {
        Sample sample = sampleRepository.findById(id).orElse(null);
        if (sample != null) {
            sample.setName(dto.getName());
            sample.setDescription(dto.getDescription());
            sample.setType(dto.getType());
            sample.setOrderNumber(dto.getOrderNumber());
            sampleRepository.save(sample);
            return "Successfully update sample from list";
        } else {
            return "Id not found";
        }
    }

    @Override
    public SampleDto findById(String id) {
        Sample sample = sampleRepository.findByIdUsingHql(id);
        if (sample != null) {
            SampleDto dto = new SampleDto();
            dto.setId(sample.getId());
            dto.setName(sample.getName());
            dto.setDescription(sample.getDescription());
            dto.setType(sample.getType());
            dto.setOrderNumber(sample.getOrderNumber());
            return dto;
        } else {
            return null;
        }
    }

    // Logika a Sandi
    // public String add2(String name) {
    // names.add(name);
    // return "Successfully add " + name + " to List";

    // }

    // @Override
    // public String remove(String name) {
    // for (String n : names) {
    // if (n.equals(name)) {
    // names.remove(name);
    // return "Successfully remove " + name + " from List";
    // }
    // }
    // return "Name is not listed in the list";
    // }

    // @Override
    // public List<String> view() {

    // return names;
    // }

    // @Override
    // public String checkName(String name) {

    // for (String n : names) {
    // if (n.equals(name)) {
    // return "Name Is Exist";
    // } else {
    // return "Name Not Exist";
    // }
    // }
    // return null;
    // }

    // public boolean checkName2(String name) {
    // // return names.stream()
    // // .filter(s -> s.toLowerCase() == name.toLowerCase())
    // // .findAny()
    // // .isPresent();

    // return names.stream()
    // .anyMatch(s -> s.equalsIgnoreCase(name));
    // }

}
