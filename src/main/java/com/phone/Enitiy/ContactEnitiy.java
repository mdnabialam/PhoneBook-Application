package com.phone.Enitiy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Phonebook_Info")
public class ContactEnitiy {
		
	@GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "phonebook"
		    
		)
		@SequenceGenerator(
		    name = "phonebook",
		    allocationSize=1
		)
	
	@Id
	@Column(name = "PHONE_ID")
	private Integer contactId;  
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREARE_DATE",updatable = false)
	private Date createdate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Update_Date",insertable = false)
	private Date updatedate;
}
