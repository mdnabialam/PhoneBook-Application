package com.phone.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phone.Enitiy.ContactEnitiy;
import com.phone.dto.Contact;
import com.phone.exception.PhoneBookException;
import com.phone.repository.ContactRepository;
import com.phone.service.ConteactService;


@Service
public class ContactImpl implements ConteactService {
	@Autowired
	private   ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact c) {
		
		boolean isSave=false;
		
		try {
			
			/*
			if (c.getContactId()!=null) {
				Optional<ContactEnitiy> findById = contactRepository.findById(c.getContactId());
				enitiy= findById.get();
			}
			*/
			ContactEnitiy  enitiy = /* null*/new ContactEnitiy();
			BeanUtils.copyProperties(c, enitiy);
			ContactEnitiy savedEnitiy= contactRepository.save(enitiy);
			if (savedEnitiy.getContactId() !=null) {
				isSave= true;
			}
			
		} catch (Exception e) {
			throw new PhoneBookException("Save Failed");
		}
		return  isSave;
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactEnitiy> enitiys= contactRepository.findAll();
		
		
		// old approach
	/*	List<Contact> contacts= new ArrayList<Contact>();
		for (ContactEnitiy enitiy : enitiys) {
			Contact contact= new Contact();
			BeanUtils.copyProperties(enitiy, contacts);
			contacts.add(contact);
		}*/
		// java -8 
		/*
		List<Contact> contacts= enitiys.stream().map(entity->{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		
		
		return contacts;
		*/
		
		return enitiys.stream().map(entity->{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		
	}

	@Override
	public Contact getContactById(Integer cid) {
		 Optional<ContactEnitiy> findById = contactRepository.findById(cid);
		if (findById.isPresent()) {
			ContactEnitiy enitiy= findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(enitiy, c);
			return c;
		}
		return null;
	}

	

	@Override
	public boolean deleteContact(Integer contactId) {
		contactRepository.deleteById(contactId);
		return true;
	}

}
