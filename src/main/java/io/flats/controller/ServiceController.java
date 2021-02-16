package io.flats.controller;

import com.zaxxer.hikari.util.FastList;
import io.flats.entity.Flat;
import io.flats.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    FlatRepository flatRepository;



    @RequestMapping("/flats")
    public ResponseEntity<List<Flat>> mainPage() {


        return ResponseEntity.ok(flatRepository.findAll());
    }
}
