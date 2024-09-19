package com.example.fileapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fileapi.dto.SampleDto;
import com.example.fileapi.dto.SampleRequestDto;
import com.example.fileapi.services.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    // @GetMapping("/add")
    // public String add(@RequestParam String name) {
    // return sampleService.add(name);
    // }

    // Logika a Sandi

    @PostMapping("/add")
    public String add(@RequestBody SampleDto dto) {
        return sampleService.add(dto);
    }

    @GetMapping("/view")
    public List<SampleDto> view(@RequestParam String name) {
        return sampleService.view(name);
    }

    @GetMapping("/find-by-id/{id}")
    public SampleDto findById(@PathVariable String id) {
        return sampleService.findById(id);
    }

    @DeleteMapping("/remove")
    public String remove(@RequestParam String id) {
        return sampleService.remove(id);
    }

    @PutMapping("/update")
    public String update(@RequestParam String id, @RequestBody SampleRequestDto dto) {
        return sampleService.update(id, dto);
    }

    // @GetMapping("/add")
    // public String add(@RequestParam String name) {
    // boolean isExist = sampleService.checkName2(name);
    // if(!isExist){
    // return sampleService.add2(name);
    // }
    // else {
    // return "Name Already Exist";
    // }
    // }

    // @GetMapping("/remove")
    // public String remove(@RequestParam String name) {
    // return sampleService.remove(name);
    // }

    // @GetMapping("/view")
    // public List<String> view() {
    // return sampleService.view();
    // }

    // @GetMapping("/check")
    // public String check(@RequestParam String name) {
    // return sampleService.checkName(name);
    // }

}
