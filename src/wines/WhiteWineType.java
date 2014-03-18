package wines;

public enum WhiteWineType implements WineType {
	CHARDONNAY( "Chardonnay" ),
	GEWURZTRAMINER( "Gewurztraminer"),
	MUSCAT( "Muscat" ),
	PINOT_BLANC( "Pinot Blanc" ),
	PINOT_GRIGIO( "Pinot Grigio" ),
	PINOT_GRIS( "Pinot Gris" ),
	RIESLING( "Riesling" ),
	SAUVIGNON( "Sauvignon" ),
	SEMILLON( "Semillon" ),
	;
	String type = "";
	
	private WhiteWineType( String typeOfWine ){
		type = typeOfWine;
	}
	
	public String getType( ) {
		return type;
	}

}
