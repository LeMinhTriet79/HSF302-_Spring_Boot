package com.example.thi_thu.service;

import com.example.thi_thu.entity.Director;
import com.example.thi_thu.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepo;
    public List<Director> findAll() { return directorRepo.findAll(); }
}
