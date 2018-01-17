package src.testproject;

public class Test {
	
	public Test() {}
	
	public static void main(String[] args) throws Exception {
		Validator data = new Validator();
		//System.out.println(data.getCbnLimit("cAAA"));
		double InvoiceAmt = data.getInvoiceNumber("EDU").getInvoiceAmt();
		double AmtUnutil = data.getInvoiceNumber("EDU").getAmtUnutil();
		
		double avalInvoiceAmt = InvoiceAmt - AmtUnutil;
		
		System.out.println(data.getInvoiceNumber("EDU").getId());
		System.out.println(data.getInvoiceNumber("EDU").getInvoiceId());
		System.out.println(data.getInvoiceNumber("EDU").getInvoiceAmt());
		System.out.println(data.getInvoiceNumber("EDU").getAmtUnutil());
		System.out.println(data.getInvoiceNumber("EDU").gettransDate());
		
		System.out.println(avalInvoiceAmt);
		//System.out.println(AmtUnutil);
	
	    
	}
}
