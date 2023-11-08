package com.phone.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phone.dto.Contact;
import com.phone.service.ConteactService;

@Controller
public class ViewContactController {

	@Autowired
	private ConteactService conteactService;
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer ContactId,Model model) {
		Contact c = conteactService.getContactById(ContactId);
		//System.out.println(c+"fhgfmhgmfgfjhfmhgfmh");
		model.addAttribute("contact", c);
		return "index";
	}
	
	
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		boolean isDelete = conteactService.deleteContact(contactId);
		if (isDelete) {
			return "redirect:/viewContacts";
		}
		return null;
	}
	
	
}
