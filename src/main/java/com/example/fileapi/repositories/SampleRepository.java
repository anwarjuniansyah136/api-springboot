package com.example.fileapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fileapi.models.Sample;

public interface SampleRepository extends JpaRepository<Sample, String> {
    @Query(value = "select * from sample order by order_number desc", nativeQuery = true)
    List<Sample> findAllOrderByNumber();

    @Query("select s from Sample s order by s.orderNumber asc")
    List<Sample> findAllOrderByOrderNumberUsingHql();
    // fungsi Hql ==> universal query , keuntungannya bisa di baca diberbagai jenis database (SQL Server , MySQL , dll)

    @Query("select s from Sample s where s.name like  %:name% order by s.orderNumber asc")
    List<Sample> findAllOrderByOrderNumberConditionalUsingHql(String name);

    @Query("select s from Sample s where s.id = :id ")
    Sample findByIdUsingHql(String id);

}
