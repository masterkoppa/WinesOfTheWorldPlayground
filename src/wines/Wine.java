package wines;
/**
 * Basic Wine class,
 * Contains the year and name.
 * @author chris
 *
 */
public class Wine {
	private String name = "";
	private int vintage;
	private String producerName = "";
	private String price = "";
	private String region = "";
	private String country = "";
	private double abv = 0.0;
	
	public int getVintage() {
		return vintage;
	}
	public void setVintage(int vintage) {
		this.vintage = vintage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
