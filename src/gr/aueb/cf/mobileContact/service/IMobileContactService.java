package gr.aueb.cf.mobileContact.service;

import gr.aueb.cf.mobileContact.Model.MobileContact;
import gr.aueb.cf.mobileContact.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactUpdateDTO;
import gr.aueb.cf.mobileContact.exceptions.ContactNotFoundException;
import gr.aueb.cf.mobileContact.exceptions.PhoneNumberAlreadyExistsException;

import java.util.List;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactInsertDTO dto) throws PhoneNumberAlreadyExistsException;
    MobileContact updateMobileContact(MobileContactUpdateDTO dto) throws
            PhoneNumberAlreadyExistsException, ContactNotFoundException;
    void deleteContactById(Long id) throws ContactNotFoundException;
    MobileContact getContactById(Long id) throws ContactNotFoundException;
    List<MobileContact> getAllContacts();

    MobileContact getContactByPhoneNumber(String phoneNumber) throws ContactNotFoundException;
    void deleteContactByPhoneNumber(String phoneNumber) throws ContactNotFoundException;


}
