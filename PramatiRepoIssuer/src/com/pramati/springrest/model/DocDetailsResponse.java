package com.pramati.springrest.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DocDetailsResponse")
public class DocDetailsResponse {
	private String docContent;

    public String getDocContent ()
    {
        return docContent;
    }
    @XmlElement
    public void setDocContent (String docContent)
    {
        this.docContent = docContent;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [docContent = "+docContent+"]";
    }
}
