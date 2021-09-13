package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonFileAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonFileAccessEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonFileAccessRepository extends JpaRepository<LessonFileAccessEntity, LessonFileAccessEntityId> {
    List<LessonFileAccessEntity> findAllByLessonId(String lessonId);

    List<LessonFileAccessEntity> findAllByFileId(String fileId);

    List<LessonFileAccessEntity> findAllByLessonIdIn(List<String> lessonsIds);
}
