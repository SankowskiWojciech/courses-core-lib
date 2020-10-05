package com.github.sankowskiwojciech.coursescorelib;

import com.github.sankowskiwojciech.coursescorelib.model.exception.ResponseEntityBadRequestExceptionHandler;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(ResponseEntityBadRequestExceptionHandler.class)
@EnableJpaRepositories("com.github.sankowskiwojciech.coursescorelib.backend.repository")
@EntityScan("com.github.sankowskiwojciech.coursescorelib.model.db")
public class CoursesCoreLibConfig {
}
