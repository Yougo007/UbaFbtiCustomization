package src.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Validator {
	
	public Validator() {}
	
    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;
    String sqlString;
    PreparedStatement preparedStatement;
    
	ConnectionFactory connector = new ConnectionFactory();
	
	public String getGoods(String code) throws SQLException{
		conn = connector.getDatabaseConnection();
		String query = "select * from EXCEPTIONGOODS WHERE CODE ="+code;
		Statement stmt = conn.createStatement();
		System.out.println("\nExecuting query: " + query);
		ResultSet rs = stmt.executeQuery(query);
		String id1 = null;
		String gCoode1 = null;		
		if (rs.next())
		{
			id1 = rs.getNString("ID");
			System.out.println(id1);
			gCoode1 = rs.getNString("CODE");
			System.out.println(gCoode1);
		}
		return null;
	}	
	
	public String referenceGenerator(String ProductID, String Mbecode) throws SQLException {
		
		//Fetching the last inserted reference
		conn = connector.getDatabaseConnection();
		String query = "SELECT REF_NUM FROM TBL_ILCREF WHERE PRODUCT_ID = ? AND MBE_CODE = ? ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY";
		String lastref = null;
		String nextref = null;
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1, ProductID);
		preparedStatement.setString(2, Mbecode);
		ResultSet rs = preparedStatement.executeQuery();
		
		if (rs.next())
		{
			lastref = rs.getNString("REF_NUM");
			String strRef = lastref.substring(0, 12);
			String strSeq = lastref.substring(12, 16);
			//Generating next reference
			int strSeqincrement = Integer.parseInt(strSeq) + 1;
			String newSeq = String.format("%04d", strSeqincrement);
			nextref = strRef +newSeq;
			
			if(nextref!=null &&!nextref.isEmpty())
			{
				String ID = null;
				DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("DD-MMM-YYYY");
				LocalDateTime datenow = LocalDateTime.now();
				String date = dateformat.format(datenow);
				
				//Inserting generated reference
				String insertnewref = "INSERT INTO TBL_ILCREF VALUES(?,?,?,?,?)";
				System.out.println("\nExecuting query: " + query);
				PreparedStatement ps = conn.prepareStatement(insertnewref);
				System.out.println(date);
				ps.setString(1, ID);
				ps.setString(2, nextref);
				ps.setString(3, date);
				ps.setString(4, ProductID);
				ps.setString(5, Mbecode);
				int i = ps.executeUpdate();
				
				if(i ==1)
				{
					return nextref;
				}		 
			}									
		}
				
		return nextref;
	}
	
	//Get last ILC reference
	public String getLastILCRef() throws SQLException {
		conn = connector.getDatabaseConnection();
		//fetches the last inserted reference

		String query = "SELECT REF_NUM FROM TBL_ILCREF ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY";
		Statement stmt = conn.createStatement();
		System.out.println("Executing getLastRef method");
		System.out.println("\nExecuting query: " + query);
		ResultSet rs = stmt.executeQuery(query);
		String refnum = null;
		//gets the last generated reference
		if (rs.next())
		{
			refnum = rs.getNString("REF_NUM");
		}
		return refnum;
	}
	
	//Get next ILC reference
	public String generateNextILCRef() throws SQLException {
		System.out.println("Executing generateNextRef method");
		String lastref = getLastILCRef();
		String strRef = lastref.substring(0, 12);
		String strSeq = lastref.substring(12, 18);
		int strSeqincrement = Integer.parseInt(strSeq) + 1;
		String newSeq = String.format("%06d", strSeqincrement);
		String nextref = strRef +newSeq;
		
		return nextref;
	}	
	
	//Insert Last ILC reference generated
	public boolean InsertILCRef() throws SQLException {
		System.out.println("Executing InsertRef method");
		String refnum = generateNextILCRef();
		String ID = "3";
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("DD-MMM-YYYY");
		LocalDateTime datenow = LocalDateTime.now();
		String date = dateformat.format(datenow);
		String query = "INSERT INTO TBL_ILCREF VALUES(?,?,?)";
		System.out.println("\nExecuting query: " + query);
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println(date);
		ps.setString(1, ID);
		ps.setString(2, refnum);
		ps.setString(3, date);
		int i = ps.executeUpdate();
		
		if(i ==1)
		{
			return true;
		}		 
		return false;
	}
	
	//Returns CBN limit
	public double getCbnLimit(String ProductID) throws SQLException {
		conn = connector.getDatabaseConnection();
		//fetches the last inserted reference
		String query = "SELECT LIMIT FROM TBL_CBNLIMIT WHERE FIELD_CODE=?";
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1, ProductID);
		ResultSet rs = preparedStatement.executeQuery();
		double cbnlimit = 0;
		if (rs.next())
		{
			cbnlimit = rs.getDouble("LIMIT");
		}
		return cbnlimit;
	}
	
	//Validate ILC reference
	public String ValidateILCRef(String referencenum) throws SQLException {
		connector.getDatabaseConnection();
		String query = "SELECT REF_NUM FROM TBL_ILCREF WHERE CODE ="+referencenum;
		Statement stmt = conn.createStatement();
		System.out.println("\nExecuting query: " + query);
		ResultSet rs = stmt.executeQuery(query);
		String refId = null;
		String refnum = null;
		
		if (rs.next())
		{
			refId = rs.getNString("ID");
			System.out.println(refId);
			refnum = rs.getNString("CODE");
			System.out.println(refnum);
		}
		return refnum;
	}
	
	//Gets the Clean Payment invoice passed by FBTI
	public CleanPayment getInvoiceNumber(String InvoiceNumber) throws SQLException {
		conn = connector.getDatabaseConnection();
		//fetches the last inserted reference
		String query = "SELECT SUBPROD_ID, INVOICE_ID,INVOICE_AMT,TRAN_AMT FROM TBL_CLEANPAYTRANS WHERE INVOICE_ID = ?";
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1, InvoiceNumber);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next())
		{
			CleanPayment cleanpay = new CleanPayment();
			cleanpay.setsubproductid(rs.getString("SUBPROD_ID"));
			cleanpay.setInvoiceId(rs.getString("INVOICE_ID"));
			cleanpay.setInvoiceAmt(rs.getDouble("INVOICE_AMT"));
			cleanpay.setAmtUnutil(rs.getDouble("TRAN_AMT"));
			
			return cleanpay;
		}		
		return null;
	}
	
	//Inserts new Invoice number and details
	public void InsertCleanPaymentInvoice(String subProdId, String invoiceId, double invoiceAmt) throws SQLException {
		conn = connector.getDatabaseConnection();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("DD-MMM-YYYY");
		LocalDateTime datenow = LocalDateTime.now();
		String TransDate = dateformat.format(datenow);
		String lastTranDate = TransDate;
		String query = "INSERT INTO TBL_CLEANPAYTRANS VALUES (?, ?, ?, ?, ?)";
		System.out.println("\nExecuting query: " + query);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, subProdId);
		ps.setString(2, invoiceId);
		ps.setDouble(3, invoiceAmt);
		ps.setDouble(4, invoiceAmt);
		ps.setString(5, TransDate);
		ps.setString(6, lastTranDate);
		int i = ps.executeUpdate();
		
		if(i ==1)
		{
			System.out.println("Successfully inserted");
		}		 
		
	}
	
	public boolean UpdateCleanPaymentInvoice(double tranAmt, String InvoiceNumber) throws SQLException {
		conn = connector.getDatabaseConnection();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("DD-MMM-YYYY");
		LocalDateTime datenow = LocalDateTime.now();
		String TransDate = dateformat.format(datenow);
		String query = "UPDATE TBL_CLEANPAYTRANS SET TRAN_AMT = ?, LAST_TRAN_DATE =? WHERE INVOICE_ID = ?";
		System.out.println("\nExecuting query: " + query);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setDouble(1, tranAmt);
		ps.setString(2, TransDate);
		ps.setString(3, InvoiceNumber);

		int i = ps.executeUpdate();
		
		if(i ==1)
		{
			System.out.println("Successfully Updated");
			
			return true;
		}		 
		
		return false;
	}
}
