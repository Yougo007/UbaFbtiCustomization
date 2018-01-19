package src.testproject;

public class Test {
	
	public Test() {}
	
	public static void main(String[] args) throws Exception {
		Validator data = new Validator();
		//Get payment invoice
		
		/*try {
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
			*/
					//System.out.println(data.getCbnLimit("cAAA"));
		//double InvoiceAmt = data.getInvoiceNumber("AB00124BC").getInvoiceAmt();
		//double AmtUnutil = data.getInvoiceNumber("AB00124BC").getTranAmt();
		
		System.out.println(data.getInvoiceNumber("AB00124BC").getId());
		System.out.println(data.getInvoiceNumber("AB00124BC").getInvoiceId());
		System.out.println(data.getInvoiceNumber("AB00124BC").getInvoiceAmt());
		System.out.println(data.getInvoiceNumber("AB00124BC").getTranAmt());
		
		////String test = "AB00124BC";
		//System.out.println(data.UpdateCleanPaymentInvoice(24000, test));
	}			
	    
	}
