package com.phone.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phone.Enitiy.ContactEnitiy;

public interface ContactRepository extends JpaRepository<ContactEnitiy, Serializable> {

}
