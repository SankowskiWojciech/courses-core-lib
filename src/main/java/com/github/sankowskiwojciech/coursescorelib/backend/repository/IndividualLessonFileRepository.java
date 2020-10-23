package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonFileEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonFileEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualLessonFileRepository extends JpaRepository<IndividualLessonFileEntity, IndividualLessonFileEntityId> {

    List<IndividualLessonFileEntity> findAllByLessonId(long lessonId);

    List<IndividualLessonFileEntity> findAllByFileId(long fileId);
}
