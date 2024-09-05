package com.unitTest.unitTest.repo;

import com.unitTest.unitTest.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    private User user;

    @BeforeEach
    void setup() {
         user = User.builder()
                .id(1)
                .name("jaisai")
                .build();
        userRepo.save(user);
    }

    @Test
    void shouldSaveUserSuccessFully(){
        assertEquals(1,user.getId());
        assertEquals("jaisai",user.getName());

    }
    @Test
    void shouldFindByUserId(){
        Optional<User> byId = userRepo.findById(user.getId());
        assertTrue(byId.isPresent(),"user Should be present by id");
        assertEquals("jaisai",byId.get().getName());

    }

    @Test
    void shouldUpdateTheUser(){
        user.setName("geet");
        userRepo.save(user);

        Optional<User> byId = userRepo.findById(user.getId());

        assertEquals("geet",byId.get().getName());
        assertTrue(byId.isPresent(),"updated User should be found");
    }
}
