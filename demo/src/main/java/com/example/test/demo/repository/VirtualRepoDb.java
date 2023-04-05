package com.example.test.demo.repository;

import com.example.test.demo.domain.CarEntity;
import com.example.test.demo.domain.UserEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class VirtualRepoDb {

    private List<UserEntity> users;

    public UserEntity createUser(UserEntity user) {
        users.add(user);
        return user;
    }


    public List<UserEntity> getAllUsers() {
        return users;
    }


    public Optional<UserEntity> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }


    public UserEntity updateUser(UserEntity userEntityToUpdate, UserEntity userEntity) {
        var index = users.indexOf(userEntityToUpdate);
        var userByIndex = users.get(index);

        userByIndex.setName(userEntity.getName());
        userByIndex.setCars(userEntity.getCars());

        return userByIndex;
    }


    public UserEntity deleteUserById(UserEntity userEntity) {
        users.remove(userEntity);

        return userEntity;
    }

    @PostConstruct
    private List<UserEntity> initUsers() {
        var abraham = UserEntity.builder()
                .id(1L)
                .name("Abraham")
                .cars(Arrays.asList(new CarEntity()
                                .setId(1L)
                                .setModel("Jeep"),
                        new CarEntity()
                                .setId(2L)
                                .setModel("Cadillac")))
                .build();

        var alice = UserEntity.builder()
                .id(2L)
                .name("Alice")
                .cars(Arrays.asList(new CarEntity()
                                .setId(3L)
                                .setModel("Infiniti"),
                        new CarEntity()
                                .setId(4L)
                                .setModel("Kia")))
                .build();

        var alvina = UserEntity.builder()
                .id(3L)
                .name("Alvina")
                .cars(Arrays.asList(new CarEntity()
                                .setId(5L)
                                .setModel("Infiniti"),
                        new CarEntity().
                                setId(6L)
                                .setModel("Kia")))
                .build();

        var christy = UserEntity.builder()
                .id(4L)
                .name("Christy")
                .cars(Collections.singletonList(new CarEntity().setId(7L).setModel("Nissan")))
                .build();

        var elsa = UserEntity.builder()
                .id(5L)
                .name("Elsa")
                .cars(Collections.singletonList(new CarEntity().setId(8L).setModel("Lamborghini")))
                .build();

        var emmi = UserEntity.builder()
                .id(6L)
                .name("Emmi")
                .cars(Collections.singletonList(new CarEntity().setId(9L).setModel("Lexus")))
                .build();

        var fabian = UserEntity.builder()
                .id(7L)
                .name("Fabian")
                .cars(Collections.singletonList(new CarEntity().setId(10L).setModel("Opel")))
                .build();

        users = new ArrayList<>();
        users.add(abraham);
        users.add(alice);
        users.add(alvina);
        users.add(christy);
        users.add(elsa);
        users.add(emmi);
        users.add(fabian);

        return users;

    }
}
