package src.testproject;

import java.util.Date;

public class CleanPayment {
	 	private String subproductid;
	    private String invoiceId;
	    private double InvoiceAmt;
	    private double TranAmt;
	    private Date transDate;
	    
	    public CleanPayment() {}
	    
	    public CleanPayment(String subproductid,String invoiceId, double InvoiceAmt, double TranAmt, Date transDate) {
	        this.subproductid = subproductid;
	        this.invoiceId = invoiceId;
	        this.InvoiceAmt = InvoiceAmt;
	        this.TranAmt = TranAmt;
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
	    public double getTranAmt() {
	        return TranAmt;
	    }
	    public void setTranAmt(double TranAmt) {
	        this.TranAmt = TranAmt;
	    }
	    
	    public Date gettransDate() {
	        return transDate;
	    }
	    public void settransDate(Date transDate) {
	        this.transDate = transDate;
	    }
}
