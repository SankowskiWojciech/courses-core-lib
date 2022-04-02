package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.group.StudentGroupAccessEntity;
import com.github.sankowskiwojciech.coursestestlib.stub.GroupEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentGroupAccessRepositoryTest {
    @Autowired
    private StudentGroupAccessRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<StudentGroupAccessEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByGroupEntityCorrectly() {
        //given
        String groupIdStub = "90cf0d45-700c-4384-84b4-7da0875f9d53";
        GroupEntity groupEntityStub = GroupEntityStub.createWithId(groupIdStub);

        //when
        List<StudentGroupAccessEntity> entities = testee.findAllByGroupEntity(groupEntityStub);

        //then
        assertFalse(entities.isEmpty());
        assertEquals(1, entities.size());
    }
}