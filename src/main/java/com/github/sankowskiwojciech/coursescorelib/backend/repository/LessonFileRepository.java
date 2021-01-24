package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileWithoutContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LessonFileRepository extends JpaRepository<LessonFileEntity, String> {

    List<LessonFileWithoutContent> findAllByFileIdIn(Set<String> fileIds);

    List<LessonFileWithoutContent> findAllByCreatedBy(String fileOwnerId);

    @Query(value = "SELECT lessonFileEntity.createdBy FROM LessonFileEntity lessonFileEntity WHERE lessonFileEntity.fileId = :fileId")
    String getFileOwnerId(@Param("fileId") String fileId);
}
