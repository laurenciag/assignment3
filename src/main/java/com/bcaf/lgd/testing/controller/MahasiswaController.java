package com.bcaf.lgd.testing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

//import java.awt.print.Pageable;

@Controller
public class MahasiswaController {
    @Autowired
    private MahasiswaDAO mahasiswaRepository;
//    private MahasiswaEdit mahasiswaEdit;

    @GetMapping("/")
    public String index(@PageableDefault(size = 3) Pageable pageable, Model model) {
        Page<Mahasiswa> page = mahasiswaRepository.findAll(pageable);
        model.addAttribute("page",page);
        return "indexListMahasiswa";
    }

    @PostMapping(path = "/save-student") //MAP ONLY POST Requests
    public @ResponseBody
    String addNewMahasiswa(@RequestParam String jurusan, @RequestParam String name, @RequestParam String nim, @RequestParam float ipk){
        Mahasiswa m = new Mahasiswa();
        m.setIpk(ipk);
        m.setJurusan(jurusan);
        m.setName(name);
        m.setNim(nim);
        mahasiswaRepository.save(m);
        return "Saved";
    }

    @GetMapping(path = "/all-student")
    public @ResponseBody
    Iterable<Mahasiswa> getAllStudents() {
        // This returns a JSON or XML with the users
        return mahasiswaRepository.findAll();
    }

    @GetMapping("/edit/{id}")
    public String getMahasiswa(@PathVariable("id") int id, Model model) throws JsonProcessingException {
        Mahasiswa iu=mahasiswaRepository.findById(id).get();
//        MahasiswaTime mahasiswaTime=new MahasiswaTime();
//        mahasiswaTime.setId(iu.getId());
//        mahasiswaTime.setIpk(iu.getIpk());
//        mahasiswaTime.setNim(iu.getNim());
//        mahasiswaTime.setName(iu.getName());
//        mahasiswaTime.setJurusan(iu.getJurusan());
//        ObjectMapper Obj = new ObjectMapper();
//        String rs=Obj.writeValueAsString(mahasiswaTime);
        model.addAttribute("user",iu);
        return "detail";
    }

    @PostMapping("/updateMahasiswa/{id}")
    public String updateMahasiswa(@PathVariable("id") int id, Mahasiswa mhs){
//        Mahasiswa iu=mahasiswaRepository.findById(id).get();
////        Mahasiswa iu = new Mahasiswa();
//        iu.setName(name);
//        iu.setJurusan(jurusan);
//        iu.setNim(nim);
//        iu.setIpk(ipk);
//        iu.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        mahasiswaRepository.save(mhs);
        return "indexListMahasiswa";
    }
}

