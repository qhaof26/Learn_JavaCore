package constant;

import java.time.LocalDate;

public class AppConst {
    //MESSAGE
    public final static String FULL_NAME_REQUIRED = "FullName must be < 100 character and not null !";
    public final static String DATE_OF_BIRTH_REQUIRED = "Date of birth is not in correct format !";
    public final static String ADDRESS_REQUIRED = "Address must be < 300 character and not null !";
    public final static String HEIGHT_REQUIRED = "Height must be between 50 and 300 (cm) !";
    public final static String WEIGHT_REQUIRED = "Weight must be between 5 and 1000 (kg)!";
    public final static String STUDENT_CODE_REQUIRED = "Student code is not in correct format !";
    public final static String SCHOOL_REQUIRED = "School must be < 200 character and not null !";
    public final static String YEAR_BEGIN_REQUIRED = "Year begin must be > 4 character and >=1900!";
    public final static String AVERAGE_SCORE_REQUIRED = "Average score must be between 0 and 10 !";
    // Const nums
    public static final int MAX_NAME_LENGTH = 100;
    public static final int MAX_ADDRESS_LENGTH = 100;
    public static final double MIN_HEIGHT = 50.0;
    public static final double MAX_HEIGHT = 300.0;
    public static final double MIN_WEIGHT = 5.0;
    public static final double MAX_WEIGHT = 1000.0;
    public static final String REGEX_STUDENT_CODE = "^[A-Za-z0-9]{10}$";
    public static final int MAX_NAME_SCHOOL = 200;
    public static final int MIN_YEAR_BEGIN = 1900;
    public static final String REGEX_YEAR_BEGIN = "^[0-9]{4}$";
    public static final double MIN_AVERAGE_SCORE = 0.0;
    public static final double MAX_AVERAGE_SCORE = 10.0;
    public static final LocalDate MIN_DATE_OF_BIRTH = LocalDate.parse("1900-01-01");

}
