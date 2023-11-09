package com.phone.service;

import java.util.List;

import com.phone.dto.Contact;

public interface ConteactService {
	
	
	boolean saveContact(Contact c);
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer contactId);
	
	
	
	boolean deleteContact(Integer contactId);
}
