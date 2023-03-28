package DiamonShop.Entity;

public class Comments {
	private int id_cmt;
	private long id_product;
	private String name_user;
	private String content;

	public Comments() {

	}

	public int getId_cmt() {
		return id_cmt;
	}

	public void setId_cmt(int id_cmt) {
		this.id_cmt = id_cmt;
	}

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
