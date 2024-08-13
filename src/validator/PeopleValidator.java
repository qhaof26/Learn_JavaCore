package validator;

import constant.AppConst;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PeopleValidator {
    public static boolean validateFullName(String fullName){
        return fullName == null || fullName.trim().isEmpty() || fullName.length() > AppConst.MAX_NAME_LENGTH;
    }
    public static boolean validateDateOfBirth(String dateOfBirth){
        return dateOfBirth == null || dateOfBirth.trim().isEmpty() || stringToLocalDate(dateOfBirth) == null;
    }
    public static LocalDate stringToLocalDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
    public static boolean validateAddress(String address){
        return address == null || address.trim().isEmpty() || address.length() > AppConst.MAX_ADDRESS_LENGTH;
    }
    public static boolean validateHeight(double height){
        return height < AppConst.MIN_HEIGHT || height > AppConst.MAX_HEIGHT;
    }
    public static boolean validateWeight(double weight){
        return weight < AppConst.MIN_WEIGHT || weight > AppConst.MAX_WEIGHT;
    }
}