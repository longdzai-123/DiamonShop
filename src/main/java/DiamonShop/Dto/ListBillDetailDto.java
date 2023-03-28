package DiamonShop.Dto;

public class ListBillDetailDto {
	private long id_product;
	private String name;
	private double price;
	private int quanty;
	private double total;
	private String img;

	public ListBillDetailDto() {
	}

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
