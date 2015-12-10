package com.pramati.springrest.controller;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.springrest.model.DocDetailsResponse;
import com.pramati.springrest.model.PullDocRequestElement;
import com.pramati.springrest.model.PullDocResponse;
import com.pramati.springrest.model.ResponseStatus;

@RestController
@RequestMapping("/issuer")
public class PramatiRepoIssuerController {
	
	@Autowired
	private DbOperations db;
	
	@Autowired
	private PullDocResponse pullDocResponse;
	
	@Autowired
	private DocDetailsResponse docDetailsResponse;
	
	@Autowired
	private ResponseStatus responseStatusObj ;
	
	private FileReaderController fileReaderController;
	
	final static Logger logger = Logger.getLogger(PramatiRepoIssuerController.class);
	
	/**
     * This method accepts an xml input equivalent to the PullDocRequestElement model class, extracts the uri tag and 
     * reads the document from the filesystem and finally produces xml output in the form of PullDocResponse model class
     */
	@RequestMapping(value="/documentDetails", method = RequestMethod.POST, consumes = "application/xml",
		    produces = "application/xml")
	public PullDocResponse getDocumentDetails(@RequestBody PullDocRequestElement pullDocRequestElementObj){
		
		logger.info("Received payload obj: " + pullDocRequestElementObj);
		String receivedURI = "";
		if(pullDocRequestElementObj.getDocDetails() !=null){
			receivedURI = pullDocRequestElementObj.getDocDetails().getURI();
			logger.info("Received DocDetails element as <DocDetails>");
		}
		else{
			receivedURI = pullDocRequestElementObj.getDocDetailsLowerCase().getURI();
			logger.info("Received DocDetails element as <docDetails>");
		}
		
		String documentName = "";
		
		if(receivedURI != null && !receivedURI.isEmpty())
			documentName = db.getDocumentFromFileSystem(receivedURI);
		else{
			logger.info("<URI> tag doesn't have a valid URI");
			return null;
		}
		
		String encodedContent = "";
		if(documentName!= null && !documentName.isEmpty()) {
			fileReaderController = new FileReaderController();
			try {
				responseStatusObj.setStatusCode("");
        		responseStatusObj.setStatus("1");
        		responseStatusObj.setTs(new Date().toString());
        		responseStatusObj.setTxn(pullDocRequestElementObj.getTxn());
				encodedContent = fileReaderController.getContentFromFile(documentName);
				docDetailsResponse.setDocContent(encodedContent);
				
				pullDocResponse.setResponseStatus(responseStatusObj);
        		pullDocResponse.setDocDetails(docDetailsResponse);
			} catch (IOException e) {
				logger.error("Exception occured in try block while reading the file from file system. Caused by "+e);
			//	e.printStackTrace();
			}
			return pullDocResponse;
		}
		else
			return null;
		
	}
	
}
