package com.lzy.boottest03.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: lzy
 * @description:
 * @date: 2021-03-03-19:38
 */
@SpringBootTest
class PersonMapperTest {
    @Autowired
    PersonMapper personMapper;

    @Test
    void getPerson() {
        personMapper.getAllPerson();
    }

}