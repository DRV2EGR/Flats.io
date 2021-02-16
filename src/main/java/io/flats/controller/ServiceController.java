package io.flats.controller;

import com.zaxxer.hikari.util.FastList;
import io.flats.dao.FlatDao;
import io.flats.entity.Flat;
import io.flats.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    FlatRepository flatRepository;



    @RequestMapping("/flats")
    public ResponseEntity<ArrayList<FlatDao>> mainPage() {

        List<Flat> lf = flatRepository.findAll();
        ArrayList<FlatDao> fd = new ArrayList<>();

        for(Flat flat : lf) {
            fd.add(new FlatDao(flat.getCountry(), flat.getTown(), flat.getStreet(), flat.getHouseNom(), flat.getFloor(), flat.getDescription()));
        }

        return ResponseEntity.ok(fd);
    }
}
