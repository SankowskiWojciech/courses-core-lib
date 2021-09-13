package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IndividualLessonRepository extends JpaRepository<IndividualLessonEntity, String>, QuerydslPredicateExecutor<IndividualLessonEntity> {
    @Query("SELECT lesson FROM IndividualLessonEntity lesson WHERE :startDateOfLesson < lesson.endDate AND :endDateOfLesson > lesson.startDate AND lesson.tutorEntity.emailAddress = :tutorEmailAddress")
    List<IndividualLessonEntity> findAllLessonsWhichCanCollideWithNewLesson(@Param("startDateOfLesson") LocalDateTime startDateOfLesson, @Param("endDateOfLesson") LocalDateTime endDateOfLesson, @Param("tutorEmailAddress") String tutorEmailAddress);

    @Query("SELECT lesson FROM IndividualLessonEntity lesson WHERE lesson.startDate >= :startDateOfLesson AND lesson.endDate <= :endDateOfLesson AND lesson.tutorEntity.emailAddress = :tutorEmailAddress")
    List<IndividualLessonEntity> findAllLessonsInRangeForTutor(@Param("startDateOfLesson") LocalDateTime startDateOfLesson, @Param("endDateOfLesson") LocalDateTime endDateOfLesson, @Param("tutorEmailAddress") String tutorEmailAddress);

    @Query("SELECT lesson FROM IndividualLessonEntity lesson WHERE (lesson.tutorEntity.emailAddress = :userId OR lesson.studentEntity.emailAddress = :userId) AND lesson.id IN (:lessonIds)")
    List<IndividualLessonEntity> findAllByUserIdAndLessonIdIn(@Param("userId") String userId, @Param("lessonIds") List<String> lessonIds);

    @Query("SELECT lesson FROM IndividualLessonEntity lesson WHERE (lesson.tutorEntity.emailAddress = :userId OR lesson.studentEntity.emailAddress = :userId)")
    List<IndividualLessonEntity> findAllByUserId(@Param("userId") String userId);
}
