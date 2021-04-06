package io.flats.service;

import io.flats.JWT_AUTH.exeption.NotFoundException;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.FlatDto;
import io.flats.entity.Flat;
import io.flats.entity.FlatsImages;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.FlatOrderTypeRepository;
import io.flats.repository.FlatRepository;
import io.flats.repository.FlatsImagesRepository;
import io.flats.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The type Flat service.
 */
@Service
@Slf4j
public class FlatService {
    /**
     * The Flat repository.
     */
    @Autowired
    FlatRepository flatRepository;

    /**
     * The Flat order type repository.
     */
    @Autowired
    FlatOrderTypeRepository flatOrderTypeRepository;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    @Autowired
    FlatsImagesRepository flatsImagesRepository;

    @Autowired
    UserService userService;

    /**
     * Find images by flat id list.
     *
     * @param flatId the flat id
     * @return the list
     */
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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Flat> findAll() {
        List<Flat> resArray = new ArrayList<>();

        for (int i = 1; i <= flatRepository.count(); ++i) {
            Flat curFlat = flatRepository.findById((long) i).orElseThrow(
                    () -> { throw new NoSuchElementException("No such role found."); }
            );

            resArray.add(curFlat);
        }

        return resArray;
    }

    /**
     * Add sale flat boolean.
     *
     * @param newFlatDao the new flat dao
     * @return the boolean
     */
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

        //Установка прав владения на объявление на пользователя через его авторизацию.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = userService.findByUsername(currentPrincipalName).orElseThrow(
                () -> {throw new UserNotFoundExeption();
                });
        newFlat.setOwner(currentUser);



        //TODO: проверка на то, что такая квартира уже существует

        flatRepository.save(newFlat);

//        System.out.println(newFlat.getId());

        for (String image: newFlatDao.getFlatsImages()) {
            FlatsImages fi = new FlatsImages();
            fi.setImgUrl(image);
            fi.setFlat(findFlatById(newFlat.getId()));
            flatsImagesRepository.save(fi);
        }

        return true;
    }

    public boolean addRentFlat(FlatDtoPayload newFlatDao) {
        Flat newFlat = new Flat();
        newFlat.setCountry(newFlatDao.getCountry());
        newFlat.setTown(newFlatDao.getTown());
        newFlat.setStreet(newFlatDao.getStreet());
        newFlat.setHouseNom(newFlatDao.getHouseNom());
        newFlat.setFloor(newFlatDao.getFloor());
        newFlat.setPrice(newFlatDao.getPrice());
        newFlat.setDescription(newFlatDao.getDescription());
        newFlat.setOrderType(flatOrderTypeRepository.findById(2L).get());

        //Установка прав владения на объявление на пользователя через его ваторизацию.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = userService.findByUsername(currentPrincipalName).orElseThrow(
                () -> {throw new UserNotFoundExeption();
                });
        newFlat.setOwner(currentUser);

        //TODO: проверка на то, что такая квартира уже существует

        flatRepository.save(newFlat);

        return true;
    }

    public Flat findFlatById(long id) {
        return flatRepository.findById(id).orElseThrow(
                () -> { throw new NotFoundException(); }
        );
    }

    public boolean deleteFlatById(long id) {

        List<FlatsImages> flatsImagesList = flatRepository.findById(id).get().getFlatsImages();
        for (FlatsImages image: flatsImagesList) {
            flatsImagesRepository.delete(image);
        }

        Flat deletingFlat = flatRepository.findById(id).orElseThrow(
                () -> { throw new NotFoundException(); });

        flatRepository.delete(deletingFlat);
        log.info("Deleted flat " + (Object)deletingFlat);

        return flatRepository.findById(id).isEmpty();
    }
}
