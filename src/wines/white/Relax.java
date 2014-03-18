package wines.white;

import wines.WhiteWine;
import wines.WhiteWineType;

public class Relax extends WhiteWine {
	public Relax(){
		super( WhiteWineType.RIESLING );
		this.initialize();
	}
	
	private void initialize(){
		this.setName("Relax");
	}
}
