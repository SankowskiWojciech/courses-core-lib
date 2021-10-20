-- ORGANIZATIONS
insert into ORGANIZATION(EMAIL_ADDRESS, ALIAS, NAME, DESCRIPTION)
values ('info@zslitnr1.pl', 'zslitnr1', 'Zespół szkół licealnych i technicznych nr 1 w Warszawie',
        'Technikum mechatroniczno - informatyczne');
insert into ORGANIZATION(EMAIL_ADDRESS, ALIAS, NAME, DESCRIPTION)
values ('not.spam@dancewithme.pl', 'ssit', 'Szkoła śpiewu i tańca', 'Szkoła gdzie się uczy śpiewać i tańczyć');

-- TUTORS
insert into TUTOR(EMAIL_ADDRESS, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION)
values ('sankowski.wojciech@gmail.com', 'wsankowski', 'Wojciech', 'Sankowski', 'Java Developer');
insert into TUTOR(EMAIL_ADDRESS, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION)
values ('kaminski.bart@dancewithme.pl', 'barkam', 'Bartosz', 'Kamiński', 'Profesjonalny tancerz');
insert into TUTOR(EMAIL_ADDRESS, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION)
values ('janko@gmail.com', 'janko', 'Jan', 'Kowalski', 'Profesjonalny Jan');

-- SUBDOMAIN
insert into SUBDOMAIN(SUBDOMAIN_ID, SUBDOMAIN_TYPE)
values ('zslitnr1', 'ORGANIZATION');
insert into SUBDOMAIN(SUBDOMAIN_ID, SUBDOMAIN_TYPE)
values ('wsankowski', 'TUTOR');
insert into SUBDOMAIN(SUBDOMAIN_ID, SUBDOMAIN_TYPE)
values ('ssit', 'ORGANIZATION');
insert into SUBDOMAIN(SUBDOMAIN_ID, SUBDOMAIN_TYPE)
values ('barkam', 'TUTOR');

-- PARENTS
insert into PARENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('kbac@gmail.com', 'Kamil', 'Baczewski');
insert into PARENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('piotr.bielski@gmail.com', 'Piotr', 'Bielski');
insert into PARENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('roberts@gmail.com', 'Robert', 'Sierpiński');

-- STUDENTS
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PARENT_ID)
values ('marcin.b@gmail.com', 'Marcin', 'Baczewski', 'kbac@gmail.com');
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PARENT_ID)
values ('anna.biala@gmail.com', 'Anna', 'Bielska', 'piotr.bielski@gmail.com');
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PARENT_ID)
values ('marlena123@gmail.com', 'Marlena', 'Sierpińska', 'roberts@gmail.com');
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('rawskaka@gmail.com', 'Karolina', 'Rawska');
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('adamjan@wp.pl', 'Adam', 'Janczewski');
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('4rturz@gmail.com', 'Artur', 'Zdun');

-- GROUP OF STUDENTS
insert into GROUP_OF_STUDENTS(ID, NAME, DESCRIPTION, CREATION_DATE_TIME, SUBDOMAIN_ID, TUTOR_ID)
values ('90cf0d45-700c-4384-84b4-7da0875f9d53', 'English B2', NULL, '2020-07-17T18:00:00', 'zslitnr1',
        'sankowski.wojciech@gmail.com');
insert into GROUP_OF_STUDENTS(ID, NAME, DESCRIPTION, CREATION_DATE_TIME, SUBDOMAIN_ID, TUTOR_ID)
values ('02fc3377-25cc-4e92-86f7-230a4654fad0', 'English B2', NULL, '2020-07-17T18:00:00', 'ssit',
        'kaminski.bart@dancewithme.pl');
insert into GROUP_OF_STUDENTS(ID, NAME, DESCRIPTION, CREATION_DATE_TIME, SUBDOMAIN_ID, TUTOR_ID)
values ('31526a5b-3d1f-485e-b035-e1f72dc715fb', 'Grupa Janka', NULL, '2020-07-17T18:00:00', 'zslitnr1',
        'janko@gmail.com');
insert into GROUP_OF_STUDENTS(ID, NAME, DESCRIPTION, CREATION_DATE_TIME, SUBDOMAIN_ID, TUTOR_ID)
values ('c3fe86e3-a498-4880-9d15-3d2516951493', 'Test', NULL, '2020-07-17T18:00:00', 'zslitnr1',
        'sankowski.wojciech@gmail.com');

-- STUDENT GROUP ACCESS
insert into STUDENT_GROUP_ACCESS(STUDENT_ID, GROUP_ID)
values ('marcin.b@gmail.com', '90cf0d45-700c-4384-84b4-7da0875f9d53');

-- SUBDOMAIN USER ACCESSES
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('zslitnr1', 'sankowski.wojciech@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('zslitnr1', 'janko@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('wsankowski', 'sankowski.wojciech@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('wsankowski', 'marcin.b@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('zslitnr1', 'marcin.b@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('ssit', 'marcin.b@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('ssit', 'kaminski.bart@dancewithme.pl');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('wsankowski', 'rawskaka@gmail.com');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('zslitnr1', 'adamjan@wp.pl');
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_ID, USER_EMAIL_ADDRESS)
values ('zslitnr1', '4rturz@gmail.com');

-- LOGIN_CREDENTIALS
-- password: Test1
-- Base64 encoded password: VGVzdDE=
insert into LOGIN_CREDENTIALS(USER_EMAIL_ADDRESS, PASSWORD_HASH, ACCOUNT_TYPE)
values ('sankowski.wojciech@gmail.com', '$2a$15$IuZTBhr5cSi9f4uaZ52uOekG.S/CvFRtxNhQGh1yjhHwJrOY0GbkW', 'TUTOR');
-- password: Test2
-- Base64 encoded password: VGVzdDI=
insert into LOGIN_CREDENTIALS(USER_EMAIL_ADDRESS, PASSWORD_HASH, ACCOUNT_TYPE)
values ('kaminski.bart@dancewithme.pl', '$2a$15$ysHuzvs3tPGi3FOBuZeu.OMWoSbho.Iqz7vDIt7i4FCfaUFx0RbGy', 'TUTOR');
-- password: Test3
-- Base64 encoded password: VGVzdDM=
insert into LOGIN_CREDENTIALS(USER_EMAIL_ADDRESS, PASSWORD_HASH, ACCOUNT_TYPE)
values ('marcin.b@gmail.com', '$2a$15$F4w/Nu1S/fe3AXvpHd.nFOak77SXQmWcziYiMydX91mJ1JW.Oom2K', 'STUDENT');

-- TOKENS
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME)
values ('token1', 'tokenNotIssuedForProvidedClient', 'sankowski.wojciech@gmail.com', 'TUTOR', 'rsaPublicKey',
        '2020-07-18T18:21:14.144', '2220-07-18T18:21:14.144');
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME, REVOCATION_DATE_TIME)
values ('token2', 'tokenIsRevoked', 'sankowski.wojciech@gmail.com', 'TUTOR', 'rsaPublicKey', '2020-07-18T18:21:14.144',
        '2220-07-18T18:21:14.144', '2020-07-18T18:21:14.144');
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME)
values ('token3', 'tokenIsExpired', 'sankowski.wojciech@gmail.com', 'TUTOR', 'rsaPublicKey', '2020-07-18T18:21:14.144',
        '2020-07-19T18:21:14.144');
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME)
values ('token4', 'tokenIsValid', 'sankowski.wojciech@gmail.com', 'TUTOR', 'rsaPublicKey', '2020-07-18T18:21:14.144',
        '2220-07-18T18:21:14.144');
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME)
values ('token5', 'tokenIsValidForStudent', 'marcin.b@gmail.com', 'STUDENT', 'rsaPublicKey', '2020-07-18T18:21:14.144',
        '2220-07-18T18:21:14.144');
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME)
values ('token6', 'tokenIsValidAgain', 'rawskaka@gmail.com', 'STUDENT', 'rsaPublicKey', '2020-07-18T18:21:14.144',
        '2220-07-18T18:21:14.144');
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME,
                  EXPIRATION_DATE_TIME)
values ('token7', 'tokenIsValidForAnotherTutor', 'kaminski.bart@dancewithme.pl', 'TUTOR', 'rsaPublicKey',
        '2020-07-18T18:21:14.144', '2220-07-18T18:21:14.144');

-- INDIVIDUAL LESSONS
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, STUDENT_ID,
                              CREATION_DATE_TIME)
values (CAST('f0604742-8031-4d8a-b6e4-a9d7faaaaba3' AS VARCHAR), 'Lekcja 1', '2020-07-18T18:00:00',
        '2020-07-18T20:00:00', 'Opis lekcji', 'info@zslitnr1.pl', 'sankowski.wojciech@gmail.com', 'marcin.b@gmail.com',
        '2020-07-17T18:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, STUDENT_ID,
                              CREATION_DATE_TIME)
values ('93ec0365-1c31-4fb3-b90b-b92d89ea8cfa', 'Lekcja 2', '2020-07-20T18:00:00', '2020-07-20T20:00:00', 'Opis lekcji',
        'info@zslitnr1.pl', 'sankowski.wojciech@gmail.com', 'marcin.b@gmail.com', '2020-07-19T18:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, TUTOR_ID, STUDENT_ID, CREATION_DATE_TIME)
values ('21809b9c-1cf6-482f-a67f-6283c23a85f8', 'Lekcja indywidualna bardzo', '2020-07-20T14:00:00',
        '2020-07-20T15:00:00', 'Opis lekcji', 'sankowski.wojciech@gmail.com', 'marcin.b@gmail.com',
        '2020-07-20T12:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, TUTOR_ID, STUDENT_ID, CREATION_DATE_TIME)
values ('f88ec986-e473-48d2-85fe-1eecaa39f10a', 'Lekcja indywidualna nr 2', '2020-07-21T14:00:00',
        '2020-07-21T16:00:00', 'Opis lekcji', 'sankowski.wojciech@gmail.com', 'rawskaka@gmail.com',
        '2020-07-21T10:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, STUDENT_ID,
                              CREATION_DATE_TIME)
values ('7d0ae6d0-7da0-4a36-9876-ee8881b9ceae', 'Lekcja 3', '2020-07-21T18:00:00', '2020-07-21T20:30:00', 'Opis lekcji',
        'not.spam@dancewithme.pl', 'kaminski.bart@dancewithme.pl', 'marcin.b@gmail.com', '2020-07-15T18:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, STUDENT_ID,
                              CREATION_DATE_TIME)
values ('fce3f15e-6725-4ae6-8665-28cb23e56f92', 'Angular routing część 1', '2020-09-18T18:00:00', '2020-09-18T19:00:00',
        'Kurs dotyczący routingu w Angularze 9+', 'info@zslitnr1.pl', 'sankowski.wojciech@gmail.com',
        'rawskaka@gmail.com', '2020-07-17T18:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, STUDENT_ID,
                              CREATION_DATE_TIME)
values ('0c02bcf0-f5a7-40d7-a04b-80e5fbbff57e', 'Angular routing część 2', '2020-09-19T18:00:00', '2020-09-19T20:00:00',
        'Kontynuacja kursu dotyczący routingu w Angularze 9+', 'info@zslitnr1.pl', 'sankowski.wojciech@gmail.com',
        'rawskaka@gmail.com', '2020-07-17T18:00:00');
insert into INDIVIDUAL_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, STUDENT_ID,
                              CREATION_DATE_TIME)
values ('3945d30e-dc54-4f7c-a99a-ecb1219b5b18', 'Angular template-driven forms', '2020-09-18T18:00:00',
        '2020-09-18T21:00:00', 'Template-driven forms w pigułce.', 'info@zslitnr1.pl', 'sankowski.wojciech@gmail.com',
        'rawskaka@gmail.com', '2020-07-17T18:00:00');

-- GROUP LESSONS
insert into GROUP_LESSON(ID, TITLE, START_DATE, END_DATE, DESCRIPTION, ORGANIZATION_ID, TUTOR_ID, GROUP_ID,
                         CREATION_DATE_TIME)
values ('c41361f8-c0a5-4827-ba8e-f5b56ef61669', 'Lekcja grupowa nr 1', '2021-07-18T18:00:00', '2021-07-18T20:00:00',
        'Opis pierwszej lekcji grupowej.', 'info@zslitnr1.pl', 'sankowski.wojciech@gmail.com',
        '90cf0d45-700c-4384-84b4-7da0875f9d53', '2020-07-17T18:00:00');

-- FILES
insert into FILE(ID, NAME, EXTENSION, CONTENT, CREATED_BY, CREATION_DATE_TIME)
values ('65462773-84dc-4738-816b-d044409498bf', 'Test file.pdf', 'pdf', STRINGTOUTF8('This is a test file!'),
        'sankowski.wojciech@gmail.com', '2020-09-18T18:00:00');
insert into FILE(ID, NAME, EXTENSION, CONTENT, CREATED_BY, CREATION_DATE_TIME)
values ('93a86ee9-b655-4d24-aa0d-4e3a051f6111', 'Test file 2', 'doc', STRINGTOUTF8('Test file 2'),
        'sankowski.wojciech@gmail.com', '2020-09-18T18:00:00');
insert into FILE(ID, NAME, EXTENSION, CONTENT, CREATED_BY, CREATION_DATE_TIME)
values ('1aec4bf9-31ef-4234-8f74-55b2bbf45908', 'Test file 3', 'pptx', STRINGTOUTF8('Test Test Test Test Test'),
        'sankowski.wojciech@gmail.com', '2020-09-18T18:00:00');
insert into FILE(ID, NAME, EXTENSION, CONTENT, CREATED_BY, CREATION_DATE_TIME)
values ('bdf391a9-fb3f-49ae-9dac-7a5520bfd781', 'Not my file', 'pptx', STRINGTOUTF8('Test Test Test Test Test'),
        'kaminski.bart@dancewithme.pl', '2020-09-18T18:00:00');
insert into FILE(ID, NAME, EXTENSION, CONTENT, CREATED_BY, CREATION_DATE_TIME)
values ('3f3ab813-25bc-41fb-9e26-3055cfbb9aa2', 'Student file', 'pptx', STRINGTOUTF8('Test Test Test Test Test'),
        'marcin.b@gmail.com', '2020-09-18T18:00:00');

-- LESSON_FILE_ACCESS
insert into LESSON_FILE_ACCESS(LESSON_ID, FILE_ID)
values ('f0604742-8031-4d8a-b6e4-a9d7faaaaba3', '65462773-84dc-4738-816b-d044409498bf');
insert into LESSON_FILE_ACCESS(LESSON_ID, FILE_ID)
values ('f0604742-8031-4d8a-b6e4-a9d7faaaaba3', 'bdf391a9-fb3f-49ae-9dac-7a5520bfd781');
insert into LESSON_FILE_ACCESS(LESSON_ID, FILE_ID)
values ('7d0ae6d0-7da0-4a36-9876-ee8881b9ceae', '65462773-84dc-4738-816b-d044409498bf');
insert into LESSON_FILE_ACCESS(LESSON_ID, FILE_ID)
values ('7d0ae6d0-7da0-4a36-9876-ee8881b9ceae', '93a86ee9-b655-4d24-aa0d-4e3a051f6111');
insert into LESSON_FILE_ACCESS(LESSON_ID, FILE_ID)
values ('fce3f15e-6725-4ae6-8665-28cb23e56f92', '3f3ab813-25bc-41fb-9e26-3055cfbb9aa2');