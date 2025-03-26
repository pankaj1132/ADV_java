package servlet_Context;

public class Cricketer {
	private String name;
	private int id;
	
	
	public Cricketer() {
		
	}

	 Cricketer(int id , String name) {
		
		this.setId(id);
		this.setName(name);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
}
