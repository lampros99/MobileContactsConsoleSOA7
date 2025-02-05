package gr.aueb.cf.mobileContact.core.serializer;

import gr.aueb.cf.mobileContact.dto.MobileContactsReadOnlyDTO;

public class Serializer {

    private Serializer(){};

    public static String serializeSTO(MobileContactsReadOnlyDTO readOnlyDTO) {
        return "ID: " + readOnlyDTO.getId() +
                ", Όνομα: " + readOnlyDTO.getFirstname() +
                ", Eπώνυμο: " + readOnlyDTO.getLastname() +
                ", Τηλ. Αριθμός: " + readOnlyDTO.getPhoneNumber();
    }
}
