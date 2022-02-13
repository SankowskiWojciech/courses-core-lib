package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileWithoutContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {
    List<FileWithoutContent> findAllByIdIn(Set<String> fileIds);
}
