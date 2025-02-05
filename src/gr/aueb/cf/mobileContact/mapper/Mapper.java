package gr.aueb.cf.mobileContact.mapper;

import gr.aueb.cf.mobileContact.Model.MobileContact;
import gr.aueb.cf.mobileContact.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactUpdateDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactsReadOnlyDTO;

public class Mapper {

    private Mapper(){};

    public static MobileContact mapInsertDTOToContact(MobileContactInsertDTO dto){
        return new MobileContact(null, dto.getFirstname(), dto.getLastname(), dto.getPhoneNumber());
    }

    public static MobileContact mapUpdateDTOToContact(MobileContactUpdateDTO dto){
        return new MobileContact(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getPhoneNumber());
    }

    public static MobileContactsReadOnlyDTO mapMobileContactToDTO(MobileContact mobileContact){
        return new MobileContactsReadOnlyDTO(mobileContact.getId(), mobileContact.getFirstname(),
                mobileContact.getLastname(), mobileContact.getPhoneNumber());
    }

}
