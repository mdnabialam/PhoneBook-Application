package com.phone.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class Contact implements Serializable {
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createdate;
	private Date updatedate;
}
