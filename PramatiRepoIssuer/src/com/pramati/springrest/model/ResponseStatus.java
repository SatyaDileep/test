package com.pramati.springrest.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseStatus")
public class ResponseStatus {
	private String StatusCode;

    private String content;

    private String Status;

    private String ts;

    private String txn;

    public String getStatusCode ()
    {
        return StatusCode;
    }
    @XmlAttribute(name = "StatusCode")
    public void setStatusCode (String StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public String getContent ()
    {
        return content;
    }
    @XmlAttribute
    public void setContent (String content)
    {
        this.content = content;
    }

    public String getStatus ()
    {
        return Status;
    }
    @XmlAttribute(name = "Status")
    public void setStatus (String Status)
    {
        this.Status = Status;
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

    @Override
    public String toString()
    {
        return "ClassPojo [StatusCode = "+StatusCode+", content = "+content+", Status = "+Status+", ts = "+ts+", txn = "+txn+"]";
    }
}
