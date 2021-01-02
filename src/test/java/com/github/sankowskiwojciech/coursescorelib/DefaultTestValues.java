package com.github.sankowskiwojciech.coursescorelib;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DefaultTestValues {

    //organization
    public static final String ORGANIZATION_ALIAS_STUB = "zslitnr1";
    public static final String ORGANIZATION_NAME_STUB = "Zespół szkół licealnych i technicznych nr 1 w Warszawie";
    public static final String ORGANIZATION_DESCRIPTION_STUB = "Technikum mechatroniczno - informatyczne";
    public static final String ORGANIZATION_EMAIL_ADDRESS_STUB = "info@zslitnr1.pl";
    public static final String ORGANIZATION_PHONE_NUMBER_STUB = "123456789";
    public static final String ORGANIZATION_WEBSITE_URL_STUB = "http://zslitnr1.pl";

    //tutor
    public static final String TUTOR_ALIAS_STUB = "wsankowski";
    public static final String TUTOR_FIRST_NAME_STUB = "Wojciech";
    public static final String TUTOR_LAST_NAME_STUB = "Sankowski";
    public static final String TUTOR_DESCRIPTION_STUB = "Java Developer";
    public static final String TUTOR_EMAIL_ADDRESS_STUB = "sankowski.wojciech@gmail.com";
    public static final String TUTOR_PHONE_NUMBER_STUB = "111222333";

    //tutor
    public static final String STUDENT_FIRST_NAME_STUB = "Marcin";
    public static final String STUDENT_LAST_NAME_STUB = "Baczewski";
    public static final String STUDENT_EMAIL_ADDRESS_STUB = "marcin.b@gmail.com";

    //token
    public static final String TOKEN_VALUE_STUB = "tokenValueStub";
    public static final String RSA_PUBLIC_KEY_STUB = "rsaPublicKey";

    //parent
    public static final String PARENT_EMAIL_ADDRESS_STUB = "kbac@gmail.com";

    //lesson
    public static final long INDIVIDUAL_LESSON_ID_STUB = 1;
    public static final String LESSON_TITLE_STUB = "Tytul lekcji.";
    public static final String LESSON_DESCRIPTION_STUB = "Opis lekcji.";

    //file
    public static final long FILE_ID_STUB = 1;
    public static final String FILE_NAME_STUB = "Test file 1";
    public static final String FILE_EXTENSION_STUB = "txt";
    public static final byte[] FILE_CONTENT_STUB = "This is a test file!".getBytes();
}
