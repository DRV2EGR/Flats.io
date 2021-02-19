package io.flats.service;

import io.flats.entity.Flat;
import io.flats.repository.FlatRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FlatService {
    @Autowired
    FlatRepository flatRepository;



    public List<Flat> findAll() {
        List<Flat> resArray = new ArrayList<>();

        for (int i = 0; i < flatRepository.count(); ++i) {
            Flat curFlat = flatRepository.findById(Long.valueOf(i)).orElseThrow(
                    () -> { throw new NoSuchElementException("No such role found."); }
            );

            resArray.add(curFlat);
        }

        return resArray;
    }
}
