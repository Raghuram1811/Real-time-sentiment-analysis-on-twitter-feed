//package kmeans;

import java.io.*;
import java.lang.*;
import java.util.*;

class Cluster1 {
	double min=0;
	double max=1;
	Random r = new Random();
	public List<String> points;
	public double cen1[]=new double[2];
	public String id;


	//Creates a new Cluster
	public Cluster1(String id) {
		this.id = id;
		this.points = new ArrayList<String>();
	}

}

public class tweets
{ 
	int len1,id21;
	double min,r2,r3,dist;
	String r1[]=new String[60];
	double arr2[][]= new double[101][3];
	double udist=0,idist=0,dist1=0,min1=0;


	ArrayList<String> twt1 = new ArrayList<String>();
	ArrayList<String> id1 = new ArrayList<String>();
	ArrayList<String> seeds1 = new ArrayList<String>();
	ArrayList<Double> distarr = new ArrayList<Double>();
	int c1=0 , c2=0;


	public void jaccarddist(Cluster1 clu1[])
	{ dist1=0;
	for(int j1=0;j1<id1.size();j1++)
	{min1=9999999;
	for(int i1=0;i1<len1;i1++)
	{
		unionNinter(id1.get(j1),clu1[i1].id);
		dist1=1-(idist/udist);
		if(dist1<min1)
		{
			min1=dist1;
			id21=i1;
		} ;
	} 
	;
	clu1[id21].points.add(id1.get(j1));
	}

	} 
	
	public void mean1(Cluster1 clu3[])
	{
		dist1=0;
	int k1=0;
	double mdist=0; 
	double m1=0;
	for(int i=0;i<len1;i++)
	{	distarr.clear();
	
	
	for(String j:clu3[i].points)
	 { //System.out.println("Inside insid and inte: "+(k1++));
		mdist=0;

	for(String k:clu3[i].points)
	{
		unionNinter(j,k);
		dist1=1-(idist/udist);
		mdist=mdist+dist1;

	}
	distarr.add(mdist);
	}
	//System.out.println(distarr);
	//System.out.println("old: "+clu3[i].id);
   if(!distarr.isEmpty())
   {
	  //System.out.println("the id is :");
	 // System.out.println( Collections.min(distarr));
	 // System.out.println( distarr.indexOf(Collections.min(distarr)));
	  //System.out.println( clu3[i].points.get(distarr.indexOf(Collections.min(distarr))));
	clu3[i].id=clu3[i].points.get(distarr.indexOf(Collections.min(distarr))) ;
	}
   
  // System.out.println("new: "+clu3[i].id);
	}

	}


	public void unionNinter(String s2,String s3)
	{  udist=0;idist=0;
	//String s4,s5;
	//s4=twt1.get(id1.indexOf(s2));
	//s5=twt1.get(id1.indexOf(s3));
	String[] array1=twt1.get(id1.indexOf(s2)).split(" ");
	String[] array2=twt1.get(id1.indexOf(s3)).split(" ");
	Set<String> set = new LinkedHashSet<String>();
	set.addAll(Arrays.asList(array1));
	//System.out.println(set);
	set.addAll(Arrays.asList(array2));
	//System.out.println(set);
	udist= set.size();
	Set<String> set1 = new LinkedHashSet<String>();
	Set<String> set2 = new LinkedHashSet<String>();
	set1.addAll(Arrays.asList(array1));
	//System.out.println(set1);
	set2.addAll(Arrays.asList(array2));
	//System.out.println(set2);
	set1.retainAll(set2); //System.out.println(set1);
	idist= set1.size();
	//System.out.println(udist);System.out.println(idist);

	}

	public void sse1(Cluster1 clu4[])
	{ double dist123=0;
	double sse1[]=new double[len1];

	for(int j12=0;j12<len1;j12++)
	{
		for(String j:clu4[j12].points)
		{ 
			unionNinter(j,clu4[j12].id);
			dist123=1-(idist/udist);
			sse1[j12]=	sse1[j12]+Math.pow(dist123, 2);
		}

	}
	double total=0;
	for(int i12 =0;i12<len1;i12++)
	{ total=total+sse1[i12];
		
	}
	
System.out.println("Sum of Squared Error: "+total);
	}



	public void clear1(Cluster1 clu2[])
	{
		for(int l1=0;l1<len1;l1++)
		{
			clu2[l1].points.clear();
		}
	}

	public static void main(String[] args) 
	{ 
		
		try{
			FileOutputStream fout=new FileOutputStream(args[3]);
			PrintStream pw=new PrintStream(fout);
			System.setOut(pw);}
			 catch(IOException e1) {
			        System.out.println("Error during reading/writing");
			   }
		
		
		
		int k=0;
		tweets obj=new tweets();
		Scanner s21=new Scanner(System.in);
		Scanner sc2 = null;
		Scanner sc1 = null;

		
		//----------------------------------------------------	 
		try {
			sc2 = new Scanner(new File(args[2]));
			sc1 = new Scanner(new File(args[1]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();  
		}
		while (sc2.hasNextLine()) {
			Scanner s2 = new Scanner(sc2.nextLine()).useDelimiter(" \"");
			obj.c1=0;
			obj.c2=0;
			while (s2.hasNext()) {
				obj.c1++;
				String s = s2.next();
				//System.out.println(s);

				if(obj.c1==2)
				{     	k=s.length();
				s=s.substring(0, k-2);
				obj.twt1.add(s.trim()); }
				if(obj.c1==9)
					obj.id1.add(s.substring(5, 23));  } }

		while (sc1.hasNextLine()) {
			Scanner s1 = new Scanner(sc1.nextLine()).useDelimiter(",");
			obj.c1=0;

			while (s1.hasNext()) {
				obj.c1++;
				String s = s1.next();
				// System.out.println(s);
				if(obj.c1==1)
					obj.seeds1.add(s.trim());  } }

//		for(int i=0;i<25;i++)
//		{
//		System.out.println(obj.twt1.get(i));}
//		System.out.println(obj.id1);
//		System.out.println(obj.seeds1);
//		System.out.println(obj.id1.size());
//		System.out.println(obj.twt1.size()); 
//		System.out.println(obj.seeds1.size());

		//---------------------------------------------------------  
		//System.out.println("Enter the number of clusters");
		obj.len1=Integer.parseInt(args[0]);
		//obj.len1=25;
		System.out.println("The number of cluster are: "+obj.len1);
		Cluster1[] clu =new Cluster1[obj.len1];

		for(int u2=0; u2<obj.len1;u2++)
		{
			//System.out.println(obj.seeds1.get(u2));
			clu[u2] = new Cluster1(obj.seeds1.get(u2));
		}
		for(int l1=0;l1<60;l1++)
		{
			obj.r1[l1]=null;
		}

		for(int f=0;f<25;f++)
		{
			int count=0;
			obj.jaccarddist(clu);
			//System.out.println("Interation: "+f);
			/*for(int i=0;i<obj.len1;i++)
			{
				
				for(String j1:clu[i].points)
				{    
				
					System.out.println(clu[i].id+"   "+j1+"       "+obj.twt1.get(obj.id1.indexOf(j1)));
					
				
				}
				System.out.println(clu[i].points.size());
				System.out.println("-----------------------------------------");
				System.out.println("-----------------------------------------");
				System.out.println("-----------------------------------------");
			}
//			for(String j1:clu[0].points)
			//			{System.out.println(j1);} */
			obj.mean1(clu);

			//------------------------------------------------
			for(int i13=0;i13<obj.len1;i13++)
			{
				if(obj.r1[i13]==clu[i13].id)
				{
					count=count+1;}}
			if(count==obj.len1)
			{
				for(int i13=1;i13<=obj.len1;i13++)
				{
					System.out.println("Cluster "+i13+": "+clu[i13-1].points);

				}
				obj.sse1(clu);
				System.exit(0);
			}


			for(int i13=0;i13<obj.len1;i13++)
			{
				obj.r1[i13]=clu[i13].id;
			}


			//-----------------------------------------------

			if(f!=24){
			obj.clear1(clu);}

		}
		for(int i13=0;i13<obj.len1;i13++)
		{
			System.out.println(clu[i13].points);

		}
		obj.sse1(clu);
		System.exit(0);
	}

}



