package src.testproject;

public class Test {
	
	public Test() {}
	
	public static void main(String[] args) throws Exception {
		Validator data = new Validator();
		//System.out.println(data.getCbnLimit("cAAA"));
		double InvoiceAmt = data.getInvoiceNumber("FXD").getInvoiceAmt();
		double AmtUnutil = data.getInvoiceNumber("FXD").getAmtUnutil();
		
		double avalInvoiceAmt = InvoiceAmt - AmtUnutil;
		
		System.out.println(data.getInvoiceNumber("FXD").getId());
		System.out.println(data.getInvoiceNumber("FXD").getInvoiceId());
		System.out.println(data.getInvoiceNumber("FXD").getInvoiceAmt());
		System.out.println(data.getInvoiceNumber("FXD").getAmtUnutil());
		System.out.println(data.getInvoiceNumber("FXD").gettransDate());
		
		System.out.println(avalInvoiceAmt);
		//System.out.println(AmtUnutil);
	
	    
	}
}
