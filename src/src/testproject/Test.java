package src.testproject;

public class Test {
	
	public Test() {}
	
	public static void main(String[] args) throws Exception {
		Validator data = new Validator();
		//System.out.println(data.getCbnLimit("cAAA"));
		/*double InvoiceAmt = data.getInvoiceNumber("ABD0010114").getInvoiceAmt();
		double AmtUnutil = data.getInvoiceNumber("ABD0010114").getAmtUnutil();
		
		double avalInvoiceAmt = InvoiceAmt - AmtUnutil;
		
		System.out.println(data.getInvoiceNumber("ABD0010114").getId());
		System.out.println(data.getInvoiceNumber("ABD0010114").getInvoiceId());
		System.out.println(data.getInvoiceNumber("ABD0010114").getInvoiceAmt());
		System.out.println(data.getInvoiceNumber("ABD0010114").getAmtUnutil());
		System.out.println(data.getInvoiceNumber("ABD0010114").gettransDate());
	*/	
		String test = "AB00124BC";
		System.out.println(data.UpdateCleanPaymentInvoice(3000, test));
	
	    
	}
}
