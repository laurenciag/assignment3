package com.bcaf.lgd.testing.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface MahasiswaDAO extends PagingAndSortingRepository<Mahasiswa, Integer> {
//    @Query("select id,name,ipk,jurusan,nim from mahasiswa")
//    List<Mahasiswa> findAll(Pageable pageable, Model model);
//
//    @Query("select id,name,ipk,jurusan,nim from mahasiswa where id=?1")
//    List<Mahasiswa> findById(String id);
}
