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
public interface IndividualLessonRepository extends JpaRepository<IndividualLessonEntity, Long>, QuerydslPredicateExecutor {

    @Query("SELECT individualLesson FROM IndividualLessonEntity individualLesson WHERE :startDateOfLesson < individualLesson.endDateOfLesson AND :endDateOfLesson > individualLesson.startDateOfLesson AND individualLesson.tutorEntity.emailAddress = :tutorEmailAddress AND individualLesson.organizationEntity.emailAddress = :organizationEmailAddress")
    List<IndividualLessonEntity> findAllLessonsWhichCanCollideWithNewLesson(@Param("startDateOfLesson") LocalDateTime startDateOfLesson, @Param("endDateOfLesson") LocalDateTime endDateOfLesson, @Param("tutorEmailAddress") String tutorEmailAddress, @Param("organizationEmailAddress") String organizationEmailAddress);

    @Query("SELECT individualLesson FROM IndividualLessonEntity individualLesson WHERE individualLesson.startDateOfLesson >= :startDateOfLesson AND individualLesson.endDateOfLesson <= :endDateOfLesson AND individualLesson.tutorEntity.emailAddress = :tutorEmailAddress AND individualLesson.organizationEntity.emailAddress = :organizationEmailAddress")
    List<IndividualLessonEntity> findAllLessonsInRangeForTutor(@Param("startDateOfLesson") LocalDateTime startDateOfLesson, @Param("endDateOfLesson") LocalDateTime endDateOfLesson, @Param("tutorEmailAddress") String tutorEmailAddress, @Param("organizationEmailAddress") String organizationEmailAddress);

    @Query("SELECT individualLesson FROM IndividualLessonEntity individualLesson WHERE (individualLesson.tutorEntity.emailAddress = :userId OR individualLesson.studentEntity.emailAddress = :userId) AND individualLesson.lessonId IN (:lessonsIds)")
    List<IndividualLessonEntity> findAllByUserIdAndLessonsIds(@Param("userId") String userId, @Param("lessonsIds") List<Long> lessonsIds);

    @Query("SELECT individualLesson FROM IndividualLessonEntity individualLesson WHERE (individualLesson.tutorEntity.emailAddress = :userId OR individualLesson.studentEntity.emailAddress = :userId)")
    List<IndividualLessonEntity> findAllByUserId(@Param("userId") String userId);
}
