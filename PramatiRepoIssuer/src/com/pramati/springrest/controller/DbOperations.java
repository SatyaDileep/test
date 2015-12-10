package com.pramati.springrest.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.pramati.springrest.model.DocumentDetails;


@Repository
public class DbOperations {
	
	private static SessionFactory sessionFactoryObj;
	private static ServiceRegistry serviceRegistryObj;
	final static Logger logger = Logger.getLogger(DbOperations.class);
	
	public static SessionFactory buildSessionFactory(){
		Configuration config = new Configuration();
		config.configure();
		serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactoryObj = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}
	
	public String getDocumentFromFileSystem(String docUriReceived){
		
		String documentNameFromFileSystem = "";
		String hql = "";
		Session session = null;
		try{
	        
			buildSessionFactory();	// builds the session factory
			session = sessionFactoryObj.openSession();
			session.beginTransaction();
			
			if (docUriReceived != null && !docUriReceived.isEmpty()) {
				hql = "FROM " + DocumentDetails.class.getName() +" where doc_Uri="+"'"+docUriReceived+"'";
				Query query = session.createQuery(hql);
				logger.info("Querying the db for document name as : "+hql);
				
				@SuppressWarnings("unchecked")
				List<DocumentDetails> listOfDocumentDetails = (List<DocumentDetails>) query.list();
				
				if(listOfDocumentDetails.size() > 0 && listOfDocumentDetails.size() ==1){
					Iterator<DocumentDetails> docDetailsIterator = listOfDocumentDetails.iterator();
					while(docDetailsIterator.hasNext()){
						DocumentDetails docDetailsObj = docDetailsIterator.next();
						documentNameFromFileSystem = docDetailsObj.getDoc_name();
					}
				}
				else
					logger.warn("No matching documents found in the database with the provided uri - "+docUriReceived);
			}
			else
				logger.warn("Document URI received is found to be null..!");
			
		}
		catch(Exception e){
			logger.error("Exception occured in Dboperations class try block.."+e);
		}
		finally{
			session.getTransaction().commit();
			session.close();
			sessionFactoryObj.close();
		}
		return documentNameFromFileSystem;
	}
	
}
