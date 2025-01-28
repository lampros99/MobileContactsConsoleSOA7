package gr.aueb.cf.mobileContact.dao;

import gr.aueb.cf.mobileContact.Model.MobileContact;

import java.util.ArrayList;
import java.util.List;

public class MobileContactDAOImpl implements IMobileContactDAO {
    private static final List<MobileContact> contacts = new ArrayList<>();
    private static Long id = 1L;


    @Override
    public MobileContact insert(MobileContact mobileContact) {
        mobileContact.setId(id++);
        contacts.add(mobileContact);
        return mobileContact;
    }

    @Override
    public MobileContact update(Long id, MobileContact mobileContact) {
        contacts.add(mobileContact);
        return mobileContact;
    }

    @Override
    public void deleteById(Long id) {
//        contacts.remove(getIndexby(id));
        contacts.removeIf(contact -> contact.getId().equals(id));
    }

    @Override
    public MobileContact getById(Long id) {
        int positionToReturn = getIndexById(id);
        return (positionToReturn != -1) ? contacts.get(positionToReturn) : null;
    }


    @Override
    public List<MobileContact> getAll() {
        return new ArrayList<>(contacts);
    }

    @Override
    public void deleteByPhoneNumber(String phoneNumber) {
        contacts.removeIf(contacts -> contacts.getPhoneNumber().equals(phoneNumber));

    }

    @Override
    public MobileContact getByPhoneNumber(String phoneNumber) {
        int positionToReturn = getIndexByPhoneNumber(phoneNumber);
        return  (positionToReturn != -1) ? contacts.get(positionToReturn) : null;
    }

    @Override
    public boolean userIdExists(Long id) {
        int position = getIndexById(id);
        return position != -1;
    }

    private int getIndexById(Long id) {
        int positionToReturn = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(id)) {
                positionToReturn = i;
                break;
            }
        }
        return positionToReturn;
    }

    @Override
    public int phoneNumberExist(String phoneNumber) {
        int positionToReturn = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                positionToReturn = i;
                break;
            }
        }
        return positionToReturn;
    }

    private int getIndexByPhoneNumber(String phoneNumber) {
        int positionToReturn = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(id)) {
                positionToReturn = i;
                break;
            }
        }
        return positionToReturn;
    }
}