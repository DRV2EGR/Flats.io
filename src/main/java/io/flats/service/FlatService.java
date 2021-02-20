package io.flats.service;

import io.flats.dto.FlatDto;
import io.flats.entity.Flat;
import io.flats.entity.FlatsImages;
import io.flats.exception.UserNotFoundExeption;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.FlatOrderTypeRepository;
import io.flats.repository.FlatRepository;
import io.flats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FlatService {
    @Autowired
    FlatRepository flatRepository;

    @Autowired
    FlatOrderTypeRepository flatOrderTypeRepository;

    @Autowired
    UserRepository userRepository;


    public List<String> findImagesByFlatId(long flatId) {

        Flat currentFlat = flatRepository.findById(flatId).orElseThrow(
                () -> { throw new NoSuchElementException("No such flat found."); }
        );

        List<String> res = new ArrayList<>();
        for(FlatsImages entity : currentFlat.getFlatsImages()) {
            res.add(entity.getImgUrl());
        }

        return res;
    }

    public List<Flat> findAll() {
        List<Flat> resArray = new ArrayList<>();

        for (int i = 1; i <= flatRepository.count(); ++i) {
            Flat curFlat = flatRepository.findById(Long.valueOf(i)).orElseThrow(
                    () -> { throw new NoSuchElementException("No such role found."); }
            );

            resArray.add(curFlat);
        }

        return resArray;
    }

    public boolean addSaleFlat(FlatDtoPayload newFlatDao) {
        Flat newFlat = new Flat();
        newFlat.setCountry(newFlatDao.getCountry());
        newFlat.setTown(newFlatDao.getTown());
        newFlat.setStreet(newFlatDao.getStreet());
        newFlat.setHouseNom(newFlatDao.getHouseNom());
        newFlat.setFloor(newFlatDao.getFloor());
        newFlat.setPrice(newFlatDao.getPrice());
        newFlat.setDescription(newFlatDao.getDescription());
        newFlat.setOrderType(flatOrderTypeRepository.findById(1L).get());

        //TODO: исправить на получение юзверя из авторизации
        newFlat.setOwner(userRepository.findById(newFlatDao.getUserId()).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        ));

        //TODO: проверка на то, что такая квартира уже существует

        flatRepository.save(newFlat);

        return true;
    }
}
