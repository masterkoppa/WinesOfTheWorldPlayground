package wines;

public enum RedWineType implements WineType {
	CABERNET_SAV( "Cabernet Sauvignon" ),
	CABERNET_FRANC( "Cabernet Franc" ),
	MALBEC( "Malbec" ),
	MERLOT( "Merlot" ),
	PINOT_NOIR( "Pinot Noir" ),
	SANGIOVESE( "Sangiovese" ),
	SHIRAZ( "Shiraz" ),
	ZINFADEL( "Zinfadel" );
	
	private String typeOfRed = "";
	private RedWineType( String type ){
		typeOfRed = type;
	}
	
	public String getType(){
		return typeOfRed;
	}
}
