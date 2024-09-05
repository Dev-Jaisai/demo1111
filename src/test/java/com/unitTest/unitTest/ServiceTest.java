package com.unitTest.unitTest;

import com.unitTest.unitTest.entity.User;
import com.unitTest.unitTest.repo.UserRepo;
import com.unitTest.unitTest.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("Test Case for Getting all the users")
    public void getAllMethod() {

        List<User> al = new ArrayList<>();
        User u1 = User.builder()
                .id(1)
                .name("jaisai")
                .build();

        User u2 = User.builder()
                .id(2)
                .name("jay")
                .build();

        al.add(u1);
        al.add(u2);
        //stubs
        when(userRepo.findAll()).thenReturn(al);

        List<User> all = userService.getAll();

        assertNotNull(all, "It should not be null");
        assertEquals(2, all.size());


    }
}
