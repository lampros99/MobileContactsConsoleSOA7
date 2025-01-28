package gr.aueb.cf.mobileContact.service;

import gr.aueb.cf.mobileContact.Model.MobileContact;
import gr.aueb.cf.mobileContact.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactUpdateDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactsReadOnlyDTO;
import gr.aueb.cf.mobileContact.exceptions.ContactNotFoundException;
import gr.aueb.cf.mobileContact.exceptions.PhoneNumberAlreadyExistsException;

import java.util.List;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactInsertDTO dto) throws PhoneNumberAlreadyExistsException;
    MobileContact updateMobileContact(MobileContactUpdateDTO dto) throws
            PhoneNumberAlreadyExistsException, ContactNotFoundException;
    void deleteContact(Long id) throws ContactNotFoundException;
    MobileContact getContact(Long id) throws ContactNotFoundException;
    List<MobileContact> getAllContacts();


}
