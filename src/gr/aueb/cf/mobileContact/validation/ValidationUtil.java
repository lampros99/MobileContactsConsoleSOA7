package gr.aueb.cf.mobileContact.validation;

import gr.aueb.cf.mobileContact.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactUpdateDTO;

public class ValidationUtil {

    private ValidationUtil(){};

    public static String validateDTO(MobileContactInsertDTO insertDTO){
        String errorResponse = "";

        if(insertDTO.getPhoneNumber().length() <= 5)
            errorResponse += "Ο τηλ. αριθμός πρέπει να έχει περισσότερα απο πέντε σύμβολα.\n";
        if(insertDTO.getFirstname().length() < 2)
            errorResponse += "Tο όνομα πρέπει να περιέχει δύο ή περισσότερους χαρακτήρες.\n";
        if (insertDTO.getLastname().length() < 2)
            errorResponse += "To επώνυμο πρέπει να περιέχει δύο η περισσότερους χαρακτήρες.\n";
        return errorResponse;
    }

    public static String validateDTO(MobileContactUpdateDTO updateDTO){
        String errorResponse = "";

        if(updateDTO.getPhoneNumber().length() <= 5)
            errorResponse += "Ο τηλ. αριθμός πρέπει να έχει περισσότερα απο πέντε σύμβολα.\n";
        if(updateDTO.getFirstname().length() < 2)
            errorResponse += "Tο όνομα πρέπει να περιέχει δύο ή περισσότερους χαρακτήρες.\n";
        if (updateDTO.getLastname().length() < 2)
            errorResponse += "To επώνυμο πρέπει να περιέχει δύο η περισσότερους χαρακτήρες.\n";
        return errorResponse;
    }




}
