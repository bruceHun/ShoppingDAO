package shopping.Class;

public class ProductCategory {
	private int CategoryID;
	private String CategoryName;
	
	public ProductCategory(){
		
	}

	public ProductCategory(int categoryID, String categoryName) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategory [CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + "]";
	}
	
	
}
