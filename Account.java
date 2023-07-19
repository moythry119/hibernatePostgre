package com.entity;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account {

	  @Id
	    private int id;
	    private String coaaccountno;
	    private String coaaccountname;
	    private String coacurrencycode;

	    public Account() {
	    }

	    public Account(int id, String coaaccountno, String coaaccountname, String coacurrencycode) {
	        this.id = id;
	        this.coaaccountno = coaaccountno;
	        this.coaaccountname = coaaccountname;
	        this.coacurrencycode = coacurrencycode;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCoaaccountno() {
	        return coaaccountno;
	    }

	    public void setCoaaccountno(String coaaccountno) {
	        this.coaaccountno = coaaccountno;
	    }

	    public String getCoaaccountname() {
	        return coaaccountname;
	    }

	    public void setCoaaccountname(String coaaccountname) {
	        this.coaaccountname = coaaccountname;
	    }

	    public String getCoacurrencycode() {
	        return coacurrencycode;
	    }

	    public void setCoacurrencycode(String coacurrencycode) {
	        this.coacurrencycode = coacurrencycode;
	    }
}
