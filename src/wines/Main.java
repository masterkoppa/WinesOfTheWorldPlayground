package wines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Wine> wines = new ArrayList<Wine>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader("E:\\Users\\Andres\\IdeaProjects\\WinesOfTheWorldPlayground\\wines.csv" ) );
			String line = null;
			int counter = 0;
			while (( line = reader.readLine()) != null ) {
				if( counter == 0 ){
					counter++;
					continue;
				}
				String[] explodedLine = line.split(",");
				String name = explodedLine[0].trim();
				String type = explodedLine[1].trim();
				String grape = explodedLine[2].trim();
				String vintage = explodedLine[3].trim();
				String price = explodedLine[4].trim();
				String region = explodedLine[5].trim();
				String country = explodedLine[6].trim();
				String abv = explodedLine[7].trim();
				String notes = explodedLine[8].trim();
				
				Wine wine = null;
				if( type.equals("white")){
					wine = new WhiteWine( grape );
				} else if( type.equals("red") ){
					wine = new RedWine( grape );
				} else if( type.equals("rose") ){
					
				} else if( type.equals("fortified" ) ){
					
				}
				
				wine.setName(name);
				wine.setVintage( Integer.parseInt(vintage));
				wine.setPrice( Double.parseDouble(price));
				wine.setRegion(region);
				wine.setCountry(country);
				wine.setAbv( Double.parseDouble(abv));
				wine.setTastingNotes( notes );
				wines.add(wine);
				counter++;
			}
			reader.close();
			
			for( Wine wine: wines ){
				System.out.println( wine );
				System.out.println();
				System.out.println();
			}
			
			//search for Pinot Gris types
			ArrayList<Wine> searchedWines = searchByGrape( wines, "Pinot Gris");
			for( Wine wine: searchedWines ){
				System.out.println( wine );
			}
			System.out.println();
			System.out.println();
			
			//search for 2012 wines
			searchedWines = searchByVintage( wines, 2011 );
			for( Wine wine: searchedWines ){
				System.out.println( wine );
			}
			
			System.out.println();
			System.out.println();
			
			//search for wines priced between 10 and 19
			searchedWines = searchByPrice( wines, 10.0, 19.0 );
			for( Wine wine: searchedWines ){
				System.out.println( wine );
			}
			
			System.out.println();
			System.out.println();
			
			//search for wines in a specific region: Oregon
			searchedWines = searchByRegion( wines, "Oregon" );
			for( Wine wine: searchedWines ){
				System.out.println( wine );
			}
			
			System.out.println();
			System.out.println();
			
			//search for wines in a specific country: U.S.
			searchedWines = searchByCountry( wines, "U.S." );
			for( Wine wine: searchedWines ){
				System.out.println( wine );
			}
			
			System.out.println();
			System.out.println();
			
			//search by tasting note: pepper
			searchedWines = searchByTastingNotes( wines, "pepper");
			for( Wine wine: searchedWines ){
				System.out.println( wine );
			}
			
		} catch (Exception e){
			System.out.println("Something happened.");
			e.printStackTrace();
		}
	}
	
	private static ArrayList<Wine> searchByGrape( ArrayList<Wine> wines, String grape ){
		ArrayList<Wine> searchedWines = new ArrayList<Wine>();
		
		for( Wine wine: wines ){
			if( wine.getGrape().contains( grape ) ){
				searchedWines.add( wine );
			}
		}
		
		return searchedWines;
	}
	
	private static ArrayList<Wine> searchByVintage( ArrayList<Wine> wines, int vintage ){
		ArrayList<Wine> searchedWines = new ArrayList<Wine>();
		
		for( Wine wine: wines ){
			if( wine.getVintage() == vintage ){
				searchedWines.add( wine );
			}
		}
		
		return searchedWines;
	}
	
	private static ArrayList<Wine> searchByPrice( ArrayList<Wine> wines, Double lowerPrice, Double higherPrice ){
		ArrayList<Wine> searchedWines = new ArrayList<Wine>();
		
		for( Wine wine: wines ){
			if( lowerPrice == null ){
				if( wine.getPrice() <= higherPrice ){
					searchedWines.add(wine);
				}
			} else if ( higherPrice == null ){
				if( wine.getPrice() >= lowerPrice ){
					searchedWines.add(wine);
				}
			} else {
				if( wine.getPrice() >= lowerPrice && wine.getPrice() <= higherPrice ){
					searchedWines.add(wine);
				}
			}
		}
		
		return searchedWines;
	}
	
	private static ArrayList<Wine> searchByRegion( ArrayList<Wine> wines, String region ){
		ArrayList<Wine> searchedWines = new ArrayList<Wine>();
		
		for( Wine wine: wines ){
			if( wine.getRegion().contains( region ) ){
				searchedWines.add( wine );
			}
		}
		
		return searchedWines;
	}
	
	private static ArrayList<Wine> searchByCountry( ArrayList<Wine> wines, String country ){
		ArrayList<Wine> searchedWines = new ArrayList<Wine>();
		
		for( Wine wine: wines ){
			if( wine.getCountry().contains( country ) ){
				searchedWines.add( wine );
			}
		}
		
		return searchedWines;
	}
	
	private static ArrayList<Wine> searchByTastingNotes( ArrayList<Wine> wines, String ... notes ){
		ArrayList<Wine> searchedWines = new ArrayList<Wine>();
		
		for( Wine wine: wines ){
			for( String note: notes ){
                // Escape the special character with \\
                String[] individualNotes = wine.getTastingNotes().split("\\|");
				for (String tastingNote : individualNotes){
                    //System.out.println(tastingNote.trim()); //DEBUG
					if( tastingNote.contains( note ) ){
						searchedWines.add(wine);
					}
				}
			}
			
		}
		
		return searchedWines;
	}
}
