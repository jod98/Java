import java.util.*;
public class HaversineFunction
{
  public static void main(String[] args) 
  {
  	Scanner scan = new Scanner(System.in);
    System.out.println("Location 1: ");
    System.out.print("Enter N (Latitude in Degrees): "); //53.379853
    double lat_1 = scan.nextDouble();
    System.out.print("Enter W: (Longitude in Degrees): "); //-6.596787
    double lng_1 = scan.nextDouble();
    
    System.out.println("\nLocation 2: ");
    System.out.print("Enter N (Latitude in Degrees): "); //39.036636
  	double lat_2 = scan.nextDouble();
    System.out.print("Enter W (Longitude in Degrees): "); //125.730919
    double lng_2 = scan.nextDouble();
    
    double result = distance(lat_1, lng_1, lat_2, lng_2);
    System.out.println("\nDistance: " + result + " km");
  }
  //Method that takes in latitudes and longitudes for two places on the globe 
  //and calculates the distance between them
	public static double distance(double lat1, double lng1, double lat2, double lng2) {
        final int Radius = 6371; //Radius of earth
        double disLat = Math.toRadians(lat2 - lat1); //Lat distance between 2 places
        double disLng = Math.toRadians(lng2 - lng1); //Lng distance between 2 places
        lat1 = Math.toRadians(lat1); //Convert Lat distance to radians
        lat2 = Math.toRadians(lat2); //Convert Lng distance to radians
				
		//First part of harversine formula
        double firstPart = Math.sin(disLat / 2) * Math.sin(disLat / 2) + Math.sin(disLng / 2) * Math.sin(disLng / 2) * Math.cos(lat1) * Math.cos(lat2);
        //Second part of harversine formula
        double secondPart = 2 * Math.asin(Math.sqrt(firstPart));
        return Radius * secondPart; //Return distance between 2 points
    }
}