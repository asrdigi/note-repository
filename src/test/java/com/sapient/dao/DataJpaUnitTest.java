package com.sapient.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.internal.runners.TestClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SuiteClasses({DataJpaUnitTest.class})
@DataJpaTest
public class DataJpaUnitTest {
 
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void givenACorrectSetup_thenAnEntityManagerWillBeAvailable() {
        assertNotNull(entityManager);
    }

}