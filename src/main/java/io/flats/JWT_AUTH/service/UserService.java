package io.flats.JWT_AUTH.service;

import io.flats.JWT_AUTH.payload.BasicPayload;
import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.entity.Role;
import io.flats.entity.User;
import io.flats.repository.RoleRepository;
import io.flats.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent())
        log.info("User " + optionalUser.get().toString() + "found by username " + username);
        else log.info("User with username '" + username + "' not found.");
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent())
            log.info("User " + optionalUser.get().toString() + "found by id " + userId);
        else log.info("User with id '" + userId + "' not found.");
        return userRepository.findById(userId);
    }

    private User createNewUserAndFillBasicFields(BasicPayload basicPayload) {
        User user = new User();

        user.setUsername(basicPayload.getUsername());
        user.setEmail(basicPayload.getEmail());
        user.setFirstName(basicPayload.getFirstName());
        user.setLastName(basicPayload.getLastName());
        user.setPhoneNumber(basicPayload.getPhoneNumber());
        user.setSecondName(basicPayload.getSecondName());

        return user;
    }

    public User registerNewSailor(UserDtoPayload sailorDtoPayload) {

        //TODO: проверить мрабатоспособность такого метода.
        User user = createNewUserAndFillBasicFields(sailorDtoPayload);

        user.setRole((Role) roleRepository.findByName("ROLE_SELLER").orElseThrow(() -> { throw new NoSuchElementException("No such role found.");}));

        user.setUserProfileImageUrl(sailorDtoPayload.getUserProfileImageUrl());
        //user.setActivationCode(UUID.randomUUID().toString());
        //user.setCreatedActivationCode(LocalDateTime.now());

        String encodedPassword = bCryptPasswordEncoder.encode(sailorDtoPayload.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);


        return user;
    }

    public User registerNewRealtor(UserDtoPayload realtorDtoPayload) {

        //TODO: проверить мрабатоспособность такого метода.
        User user = createNewUserAndFillBasicFields(realtorDtoPayload);

        user.setRole((Role) roleRepository.findByName("ROLE_REALTOR").orElseThrow(() -> { throw new NoSuchElementException("No such role found.");}));

        user.setUserProfileImageUrl(realtorDtoPayload.getUserProfileImageUrl());
        //user.setActivationCode(UUID.randomUUID().toString());
        //user.setCreatedActivationCode(LocalDateTime.now());

        String encodedPassword = bCryptPasswordEncoder.encode(realtorDtoPayload.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);


        return user;
    }


//    public Curator registerNewCurator(CuratorDto curatorDto) {
//        Curator user = new Curator();
//        user.setUsername(curatorDto.getUsername());
//        user.setEmail(curatorDto.getEmail());
//        user.setFirstName(curatorDto.getFirstName());
//        user.setLastName(curatorDto.getLastName());
//        user.setPhoneNumber(curatorDto.getPhoneNumber());
//        user.setSecondName(curatorDto.getSecondName());
//        user.setRole(roleRepository.findByName("ROLE_CURATOR").orElseThrow(() -> { throw new NoSuchElementException("No such role found.");}));
//
//        user.setActivationCode(UUID.randomUUID().toString());
//        user.setCreatedActivationCode(LocalDateTime.now());
//
//        String encodedPassword = bCryptPasswordEncoder.encode(curatorDto.getPassword());
//        user.setPassword(encodedPassword);
//
//        user.setNameCompany(curatorDto.getNameCompany());
//
//        User registeredUser = curatorRepository.save(user);
//        log.info("Registered new curator: " + registeredUser.toString());
//
//        mailService.send(user.getEmail(), "Активация аккаунта.", mailService.compareRegistrationEmail(user.getSecondName(),
//                user.getLastName(), "куратора", user.getActivationCode()));
//
//        return user;
//    }


//    public void activateUser(String encodedUserActivationCode) {
//
//        User activatedUser = userRepository.findByActivationCode(encodedUserActivationCode).orElseThrow(
//                                    () -> {
//                                        throw new NotFoundException();
//                                    }
//                                );
//
//        activatedUser.setActivationCode(null);
//
//        userRepository.save(activatedUser);
//    }
}