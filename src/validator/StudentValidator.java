package validator;

import constant.AppConst;

public class StudentValidator {
    public static boolean validateStudentCode(String studentCode){
        return studentCode == null || studentCode.trim().isEmpty() || !studentCode.matches(AppConst.REGEX_STUDENT_CODE);
    }
    public static boolean validateSchool(String school){
        return school == null || school.trim().isEmpty() || school.length() > AppConst.MAX_NAME_SCHOOL;
    }
    public static boolean validateYearBegin(int yearBegin){
        return yearBegin <= AppConst.MIN_YEAR_BEGIN || !String.valueOf(yearBegin).matches(AppConst.REGEX_YEAR_BEGIN);
    }
    public static boolean validateAverageScore(double score){
        return score < AppConst.MIN_AVERAGE_SCORE || score > AppConst.MAX_AVERAGE_SCORE;
    }
}
