package com.pramati.springrest.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PullDocResponse")
//@XmlType(propOrder={"PullDocResponse", "ResponseStatus", "DocDetails"})

public class PullDocResponse {
	private ResponseStatus ResponseStatus;

    private DocDetailsResponse docDetails;

    public ResponseStatus getResponseStatus ()
    {
        return ResponseStatus;
    }
    @XmlElement(name = "ResponseStatus")
    public void setResponseStatus (ResponseStatus ResponseStatus)
    {
        this.ResponseStatus = ResponseStatus;
    }

    public DocDetailsResponse getDocDetails ()
    {
        return docDetails;
    }
    @XmlElement(name = "DocDetails")
    public void setDocDetails (DocDetailsResponse docDetails)
    {
        this.docDetails = docDetails;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ResponseStatus = "+ResponseStatus+", DocDetails = "+docDetails+"]";
    }
}
