package com.oocl.web.sampleWebApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.oocl.web.sampleWebApp.jpaSample.AssertHelper.assertThrows;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityTests {
    @Autowired
    private SingleEntityRepository singleEntityRepository;
    @Test
    public void should_fetch_entity(){
        //Given
        SingleEntity singleEntity=new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "Hi";
        singleEntityRepository.save(singleEntity);

        //When
        SingleEntity fetched=singleEntityRepository.getOne(1L);

        //Then
        assertEquals("Hi",fetched.name);
    }

    @Test
    public void should_not_store_in_database_if_name_length_exceed(){
        //Given
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.id=1L;
        singleEntity.name="12345678901";

        //When
        //Then
        assertThrows(Exception.class,()-> {
                    singleEntityRepository.save(singleEntity);
                    singleEntityRepository.flush();
        });


    }
}
