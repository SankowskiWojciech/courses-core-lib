package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.grouplesson.GroupLessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GroupLessonRepository extends JpaRepository<GroupLessonEntity, String>, QuerydslPredicateExecutor<GroupLessonEntity> {
    @Query("SELECT lesson FROM GroupLessonEntity lesson WHERE :startDate < lesson.endDate AND :endDate > lesson.startDate AND lesson.tutorEntity.emailAddress = :tutorEmailAddress")
    List<GroupLessonEntity> findAllLessonsWhichCanCollideWithNewLesson(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("tutorEmailAddress") String tutorEmailAddress);

    @Query("SELECT lesson FROM GroupLessonEntity lesson WHERE lesson.startDate >= :startDateOfLesson AND lesson.endDate <= :endDateOfLesson AND lesson.tutorEntity.emailAddress = :tutorEmailAddress")
    List<GroupLessonEntity> findAllLessonsInRangeForTutor(@Param("startDateOfLesson") LocalDateTime startDateOfLesson, @Param("endDateOfLesson") LocalDateTime endDateOfLesson, @Param("tutorEmailAddress") String tutorEmailAddress);
}
