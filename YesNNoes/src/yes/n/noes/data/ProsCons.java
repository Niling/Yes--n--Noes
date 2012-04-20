package yes.n.noes.data;

public class ProsCons {

	private final int id;
	private boolean state;
	private final int categoryId;

	private String name;
	private String date;
	private String comment;

	public ProsCons(int id, int categoryId) {
		this.id = id;
		this.categoryId = categoryId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

}
