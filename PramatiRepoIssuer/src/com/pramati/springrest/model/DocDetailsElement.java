package com.pramati.springrest.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DocDetails")
/*@XmlAccessorType(XmlAccessType.FIELD)*/
public class DocDetailsElement {
	 private String txn;

	    private String URI;

	    public String getTxn ()
	    {
	        return txn;
	    }
	    @XmlAttribute
	    public void setTxn (String txn)
	    {
	        this.txn = txn;
	    }

	    public String getURI ()
	    {
	        return URI;
	    }
	    @XmlElement
	    public void setURI (String URI)
	    {
	        this.URI = URI;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [txn = "+txn+", URI = "+URI+"]";
	    }
}
