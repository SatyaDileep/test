package com.pramati.springrest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name =  "document_details")
public class DocumentDetails {
	@Id	@GeneratedValue(strategy = GenerationType.TABLE)		// tells that this is the primary key
	private int doc_Id;
	String doc_Uri, doc_name, doc_path;
	
	
	
	public int getDoc_Id() {
		return doc_Id;
	}
	public void setDoc_Id(int doc_Id) {
		this.doc_Id = doc_Id;
	}
	public String getDoc_Uri() {
		return doc_Uri;
	}
	public void setDoc_Uri(String doc_Uri) {
		this.doc_Uri = doc_Uri;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getDoc_path() {
		return doc_path;
	}
	public void setDoc_path(String doc_path) {
		this.doc_path = doc_path;
	}
	
}
