import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Random;

public class travellingSalesman
{
	public static void main(String args[]) throws Exception
	{
		Random rand = new Random();
		university arr[]= new university[1000]; //Creating an array of University objects that contain rank, uni, country, lat, lon
		data(arr); //Calling data method on University objects
		
		/////////////////////////////////////////////////////////////////////
		
		double result = 0;
		university arrRes[] = new university[1001]; //Add Maynooth at end
		int pos = 0;
		//Goes from Maynooth to Last Uni (Odd)
		for(int i=607; i<arr.length; i++)
		{
			if(i%2!=0)
			{
				arrRes[pos] = arr[i];
				pos++;
			}
		}
		//Goes from last Uni to first Uni (Even)
		for(int i=arr.length-1; i>=0; i--)
		{
			if(i%2 == 0)
			{
				arrRes[pos] = arr[i];
				pos++;
			}
		}
		for(int i=0; i<608; i++)
		{
			if(i%2!=0)
			{
				arrRes[pos] = arr[i];
				pos++;
			}
		}
	
	for(int k=1; k<arrRes.length-4; k++)
	{
		int temp = k + rand.nextInt(4);
		swap(k, temp, arrRes);
	} 
	
	for(int i=0; i<arrRes.length; i++)
	{
		System.out.print(arrRes[i].rank + ", ");
	}
	
	for(int i=0; i<arrRes.length-2; i++)
	{
		result += haversine(arrRes[i], arrRes[i+1]);
	}
		System.out.println("Distance is: " + result + " km");
		System.out.println(); //Blank line
	
}
	/////////////////////////////////////////////////////
	public static void swap(int i, int j, university arrRes[])
	{
		university temp = arrRes[i];
		arrRes[i] = arrRes[j];
		arrRes[j] = temp;
	}
	
	//Method that reads in data for universities
	public static void data(university arr[]) throws Exception
	{
		StringTokenizer st; //Allows us to parse string and extract values i.e. lat and lon
		BufferedReader file = new BufferedReader(new FileReader("UniversityData.tsv")); //Reading in file contents
		String dataLine = file.readLine(); // Read first line.
		
		int uniCount = 0; //Variable used to store current Uni data
		int rank; //Variable used to store rank
		String name; //Variable used to store name 
		String country; //Variable used to store country
		double lat; //Variable used to store lat co-ordinates 
		double lon; //Variable used to store lon co-ordinates 
		
		while (dataLine != null) //Iterates through each line in file and sets rank, name etc. to that of current line
		{
				st = new StringTokenizer(dataLine, "\t");  //Adds line contents to StringTokenizer, "\t" specifies type of seperation in file			
				rank = Integer.parseInt(st.nextToken()); //Adds rank to variable rank
				name = st.nextElement().toString();
				country = st.nextElement().toString();
				lat = Double.parseDouble(st.nextToken());
				lon = Double.parseDouble(st.nextToken());
				arr[uniCount] = new university(rank,name,country,lat,lon); //Setting each element of univeristy array to particular univeristy and its Details
			uniCount++; //Increments counter so it can be added to next element of university array
			dataLine = file.readLine(); // Read next line of data.
		}
		file.close(); // Close the file once all data has been read.
	}
	
	//Method that takes in latitudes and longitudes for two places on the globe 
  //and calculates the distance between them
	public static double haversine(university A, university B)
	{
		double lat_1 = A.lat;
		double lon_1 = A.lon;
		double lat_2 = B.lat;
		double lon_2 = B.lon;
		
		final double Radius = 6371; // In kilometers
		double dLat = Math.toRadians(lat_2 - lat_1);
		double dLon = Math.toRadians(lon_2 - lon_1);
		lat_1 = Math.toRadians(lat_1);
		lat_2 = Math.toRadians(lat_2);

		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat_1) * Math.cos(lat_2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return Radius * c;
	}
} 

//University class that allows us to access university data individual part
class university
{
	public int rank;
	public String name;
	public String country;
	public double lat;
	public double lon;

	public university()
	{
		this.rank = 0;
		this.name = "NULL";
		this.country = "NULL";
		this.lat = 0;
		this.lon = 0;
	}

	public university(int rank, String name, String country, double lat, double lon)
	{
		this.rank = rank;
		this.name = name;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
	}

	public void setDetails(int rank, String name, String country, double lat, double lon)
	{
		this.rank = rank;
		this.name = name;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
	}

	public void print()
	{
		System.out.println(rank + "\t" + name + "\t" + country + "\t" + "\t" + lat + "\t" + lon);
	}
}


