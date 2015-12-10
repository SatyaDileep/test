package com.pramati.springrest.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PullDocRequest")
/*@XmlAccessorType(XmlAccessType.FIELD)*/
public class PullDocRequestElement {
	private String orgId;

    private String ts;

    private String txn;

    private String ver;

    private String keyhash;
    
    
    private DocDetailsElement docDetails;
    private DocDetailsElementLowerCase docDetailsLowerCase;
    
	public String getOrgId ()
    {
        return orgId;
    }
    @XmlAttribute
    public void setOrgId (String orgId)
    {
        this.orgId = orgId;
    }

    public String getTs ()
    {
        return ts;
    }
    @XmlAttribute
    public void setTs (String ts)
    {
        this.ts = ts;
    }

    public String getTxn ()
    {
        return txn;
    }
    @XmlAttribute
    public void setTxn (String txn)
    {
        this.txn = txn;
    }

    public String getVer ()
    {
        return ver;
    }
    @XmlAttribute
    public void setVer (String ver)
    {
        this.ver = ver;
    }

    public String getKeyhash ()
    {
        return keyhash;
    }
    @XmlAttribute
    public void setKeyhash (String keyhash)
    {
        this.keyhash = keyhash;
    }

    public DocDetailsElement getDocDetails ()
    {
        return docDetails;
    }
    @XmlElement (name="DocDetails")
    public void setDocDetails (DocDetailsElement docDetails)
    {
        this.docDetails = docDetails;
    }
    
    public DocDetailsElementLowerCase getDocDetailsLowerCase() {
		return docDetailsLowerCase;
	}
    @XmlElement (name="docDetails")
	public void setDocDetailsLowerCase(DocDetailsElementLowerCase docDetailsLowerCase) {
		this.docDetailsLowerCase = docDetailsLowerCase;
	}

    @Override
    public String toString()
    {
    	return "ClassPojo [orgId = "+orgId+", ts = "+ts+", txn = "+txn+", ver = "+ver+", keyhash = "+keyhash+", DocDetails = "+getDocDetails()+", docDetails = "+getDocDetailsLowerCase()+"]";
    }
}
