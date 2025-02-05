package gr.aueb.cf.mobileContact.controller;

import gr.aueb.cf.mobileContact.Model.MobileContact;
import gr.aueb.cf.mobileContact.core.serializer.Serializer;
import gr.aueb.cf.mobileContact.dao.IMobileContactDAO;
import gr.aueb.cf.mobileContact.dao.MobileContactDAOImpl;
import gr.aueb.cf.mobileContact.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactUpdateDTO;
import gr.aueb.cf.mobileContact.dto.MobileContactsReadOnlyDTO;
import gr.aueb.cf.mobileContact.exceptions.ContactNotFoundException;
import gr.aueb.cf.mobileContact.exceptions.PhoneNumberAlreadyExistsException;
import gr.aueb.cf.mobileContact.mapper.Mapper;
import gr.aueb.cf.mobileContact.service.IMobileContactService;
import gr.aueb.cf.mobileContact.service.MobileContactServicelmpl;
import gr.aueb.cf.mobileContact.validation.ValidationUtil;

import java.util.ArrayList;
import java.util.List;


public class MobileContactController {
    private final IMobileContactDAO dao = new MobileContactDAOImpl();
    private final IMobileContactService service = new MobileContactServicelmpl(dao);


    public String insertContact(MobileContactInsertDTO insertDTO) {
        MobileContact mobileContact;
        MobileContactsReadOnlyDTO readOnlyDTO;

        try {
            String errorVector = ValidationUtil.validateDTO(insertDTO);
            if(!errorVector.isEmpty()){
                return "Error.\n" + "Validation error\n" + errorVector;
            }

            mobileContact = service.insertMobileContact(insertDTO);
            readOnlyDTO = Mapper.mapMobileContactToDTO(mobileContact);
            return "OK\n" + Serializer.serializeSTO(readOnlyDTO);
        }catch (PhoneNumberAlreadyExistsException e){
            return "Error.\n" + e.getMessage() + "\n";
        }
    }
    public String updateContact(MobileContactUpdateDTO updateDTO){
        MobileContact mobileContact;
        MobileContactsReadOnlyDTO readOnlyDTO;

        try{
            String errorVector = ValidationUtil.validateDTO(updateDTO);
            if(!errorVector.isEmpty()){
                return "Error.\n" + "Validation error\n" + errorVector;
            }

            mobileContact = service.updateMobileContact(updateDTO);
            readOnlyDTO = Mapper.mapMobileContactToDTO(mobileContact);
            return "OK\n" + Serializer.serializeSTO(readOnlyDTO);

        }catch (PhoneNumberAlreadyExistsException | ContactNotFoundException e){
            return "Error.\n" + e.getMessage() + "\n";
        }
    }

    public String deleteContactById(Long id){
        try {
            service.deleteContactById(id);
            return "OK\n H επαφή διαγράφηκε";
        }catch (ContactNotFoundException e){
            return "Error.\n" + "Λάθος κατα τη διαγραφή. Η επαφή δεν βρέθηκε";
        }
    }

    public String getContactById(Long id){
        MobileContact mobileContact;
        MobileContactsReadOnlyDTO readOnlyDTO;

        try {
            mobileContact = service.getContactById(id);
            readOnlyDTO = Mapper.mapMobileContactToDTO(mobileContact);
            return "ΟΚ\n" + Serializer.serializeSTO(readOnlyDTO);
        }catch (ContactNotFoundException e){
            return "Error.\n" + "H επαφή δεν βρεθήκε \n";
        }
    }

    public List<String> getAllContacts(){
        List<MobileContact> contacts;
        List<String> serializedList = new ArrayList<>();
        MobileContactsReadOnlyDTO readOnlyDTO;
        String serialized;

        contacts = service.getAllContacts();

        for(MobileContact contact : contacts){
            readOnlyDTO = Mapper.mapMobileContactToDTO(contact);
            serialized = Serializer.serializeSTO(readOnlyDTO);
            serializedList.add(serialized);
        }

        return serializedList;
    }

    public String getContactByPhoneNumber(String phoneNumber){
        MobileContact mobileContact;
        MobileContactsReadOnlyDTO readOnlyDTO;

        try {
            mobileContact = service.getContactByPhoneNumber(phoneNumber);
            readOnlyDTO = Mapper.mapMobileContactToDTO(mobileContact);
            return "OK\n" + Serializer.serializeSTO(readOnlyDTO);
        } catch (ContactNotFoundException e) {
            return "Error.\n" + "H επαφή δεν βρέθηκε \n";
        }
    }


    public String deleteContactByPhoneNumber(String phoneNumber){
        MobileContact mobileContact;
        MobileContactsReadOnlyDTO readOnlyDTO;
        try {
            mobileContact = service.getContactByPhoneNumber(phoneNumber);
            readOnlyDTO = Mapper.mapMobileContactToDTO(mobileContact);
            service.deleteContactByPhoneNumber(phoneNumber);
            return "OK\n Η επαφή διαγράφηκε" + Serializer.serializeSTO(readOnlyDTO);
        }catch (ContactNotFoundException e){
            return "Error.\n" + "Λάθοε κατά την διαγραφή. Η επαφή δεν βρέθηκε";
        }
    }


}
