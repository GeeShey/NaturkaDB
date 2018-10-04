import java.io.IOException;

public class Core {
	public static int[] daysPendingTillSupply,purchaseIds,CustomerIds;
	public static boolean[] stillSubscribed;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void getPurchaseInfo() throws IOException {
		InfoGetter x= new InfoGetter("Workbook1.xlsx","/Users/vediccoimbatore/Desktop");
		int[] purchaseIds= x.getPurchaseId();
		int[] customerIds= x.getCustomerIds();
		int[] purchaseIds= x.getPurchaseId();
		
		
	}

}
