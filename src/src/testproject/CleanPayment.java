package src.testproject;

import java.util.Date;

public class CleanPayment {
	 	private String subproductid;
	    private String invoiceId;
	    private double InvoiceAmt;
	    private double AmtUnutil;
	    private Date transDate;
	    
	    public CleanPayment() {}
	    
	    public CleanPayment(String subproductid,String invoiceId, double InvoiceAmt, double AmtUnutil, Date transDate) {
	        this.subproductid = subproductid;
	        this.invoiceId = invoiceId;
	        this.InvoiceAmt = InvoiceAmt;
	        this.AmtUnutil = AmtUnutil;
	        this.transDate = transDate;
	    }
	    
	    public String getId() {
	        return subproductid;
	    }
	    public void setsubproductid(String subproductid) {
	        this.subproductid = subproductid;
	    }
	    public String getInvoiceId() {
	        return invoiceId;
	    }
	    public void setInvoiceId(String invoiceId) {
	        this.invoiceId = invoiceId;
	    }
	    public double getInvoiceAmt() {
	        return InvoiceAmt;
	    }
	    public void setInvoiceAmt(double InvoiceAmt) {
	        this.InvoiceAmt = InvoiceAmt;
	    }
	    public double getAmtUnutil() {
	        return AmtUnutil;
	    }
	    public void setAmtUnutil(double AmtUnutil) {
	        this.AmtUnutil = AmtUnutil;
	    }
	    
	    public Date gettransDate() {
	        return transDate;
	    }
	    public void settransDate(Date transDate) {
	        this.transDate = transDate;
	    }
}
