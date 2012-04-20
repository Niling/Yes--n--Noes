package yes.n.noes.data;

public class Category {
	
	private final int id;
	private String name;
	
	public Category(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
