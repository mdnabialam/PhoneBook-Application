package com.phone.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.phone.dto.Contact;
import com.phone.service.ConteactService;


@Controller
public class ContactInfoController {
	@Autowired
	private ConteactService conteactService;
	
	@GetMapping(value = {"/","/addContact"})
	public String loadFrom(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		//System.out.println("Contact Save Success");
		return "index"; 
	}
	
	
	@PostMapping(value = "/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact")  Contact c, Model model) {
		boolean isSave = conteactService.saveContact(c); 
		if (isSave) {
			model.addAttribute("succMsg", "Contact Save");
		} else {
			model.addAttribute("errMsg", "Failed To Save Contacr");
		}
		return "index";
	}
	
	@GetMapping("/viewContacts")
	public String handviewLink(Model model) {
	 List<Contact> contactsList=conteactService.getAllContact();
	 model.addAttribute("contacts", contactsList);
		return "viewContacts";
	}
	
	
	
	
	
}
