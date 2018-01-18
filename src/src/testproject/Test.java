package src.testproject;

public class Test {
	
	public Test() {}
	
	public static void main(String[] args) throws Exception {
		Validator data = new Validator();
		//Get payment invoice
		
		try {
			String testInv = "AB00124BC";
			String strInvoiceNum = data.getInvoiceNumber(testInv).getInvoiceId();
			
			if(strInvoiceNum != null && !strInvoiceNum.isEmpty())
			{
				System.out.println(data.getInvoiceNumber(testInv).getId());
				System.out.println(data.getInvoiceNumber(testInv).getInvoiceId());
				System.out.println(data.getInvoiceNumber(testInv).getInvoiceAmt());
				System.out.println(data.getInvoiceNumber(testInv).getTranAmt());
			}		
			else {			
				String subProdID = "EDU";
				String invoiceId = testInv;
				double invoiceAmt = 52000;
				data.InsertCleanPaymentInvoice(subProdID, invoiceId, invoiceAmt);	
			}
		}
		
		catch(NullPointerException e) {
			System.out.println(e);
		}		
		
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
		////String test = "AB00124BC";
		//System.out.println(data.UpdateCleanPaymentInvoice(24000, test));
	
	    
	}
}
