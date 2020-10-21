package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonFileRepository extends JpaRepository<LessonFileEntity, Long> {

    @Query(value = "SELECT CREATED_BY FROM LESSON_FILE WHERE FILE_ID = :fileId", nativeQuery = true)
    String getFileOwnerId(@Param("fileId") long fileId);
}
