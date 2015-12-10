package com.pramati.springrest.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.pramati.springrest.model.DocumentConfigurationProperties;


public class FileReaderController {
	
	final static Logger logger = Logger.getLogger(FileReaderController.class);
	/**
     * This method converts the content of a source file into Base64 encoded data and saves that to a target file.
     * If isChunked parameter is set to true, there is a hard wrap of the output  encoded text.
     */
	
    private static String encode(String sourceFile) throws Exception {
 
        byte[] base64EncodedData = Base64.encodeBase64(loadFileAsBytesArray(sourceFile), true);
        String encodedPdfContent = new String(base64EncodedData);
        return encodedPdfContent;
    //    decode("C:/Users/satyadinleep/Desktop/something-encoded.pdf", base64EncodedData);
    //    writeByteArraysToFile(targetFile, base64EncodedData);
    }
 
    public static void decode(String target,byte[] encodedData) throws Exception {
 
        byte[] decodedBytes = Base64.decodeBase64(encodedData);
        System.out.println(decodedBytes);
        writeByteArraysToFile(target, decodedBytes);
    }
	
	public static byte[] loadFileAsBytesArray(String fileName) throws Exception {
		
		DocumentConfigurationProperties documentConfigProperties = new DocumentConfigurationProperties();
		String folderName = documentConfigProperties.getPropValues("config.properties");
		logger.info("Reading the "+fileName+" from.."+folderName);
		
        File file = new File(folderName+fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;
 
    }
 
    /**
     * This method writes byte array content into a file.
     *
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {
 
        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();
 
    }
	
	public String getContentFromFile(String pdfFileName)throws IOException{
		try {
			String encodedPdfContent = encode(pdfFileName);
	        return encodedPdfContent;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
