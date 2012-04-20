package yes.n.noes.data;

public class ProsCons {

	private final int id;
	private final String state;
	private final String category;

	private String name;
	private String date;
	private String comment;

	public ProsCons(int id, String category, String state) {
		this.id = id;
		this.state = state;
		this.category = category;
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

	public String getState() {
		return state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

}
