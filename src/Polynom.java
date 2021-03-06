import java.util.Scanner;
import java.io.*;

/**
 * 
 * @author Vladimir Vilenchik s0556191@htw-berlin.de
 * @since 10.11.2016
 * @version 1.0.0
 *
 */

public class Polynom {
	
	/**
	 * @param DIM maximal degree of the polynom ( 0,1,2,3,4,5,6)
	 * @param pol array that will contain the values of polynom fields
	 * @param pol_derivativ array, that will contain the derivative polynom
	 */
	 final int DIM = 7; 
	 private double[] pol = new double[DIM];  
	 private double[] pol_derivativ = new double[DIM]; 
	 private String polystring = "" ;
	 
	 Polynom ()    // simple constructor, builds 0+..+0 = 0  polynom
	 {
		 for (int i=0;i<DIM;i++)
			 this.pol[i] = 0;
		 this.polystring = this.ausgabe(this.pol);
	 }
	 
	 
	 public void eingabe()  //some functions are private, and have public access function. This is maybe not needed right now,
	                        //but may provide future security in case the Class will grow further
	 
	 {
		/**
		 * @param reader saves the input from the user 
		 */
		 Scanner reader = new Scanner(System.in);
		 System.out.printf("Please provide the degree of the polynom(maximum 6) \n");
		 int choice = reader.nextInt();

		 for (int i = choice; i>=0;i--)
		  //switch is used only because of the words first, second etc. Could be avoided
	      // with less user friendly output text
	      // the place in array fits the degree, for example, p[0]=a  -> ... +a*x^0
		 {
			 switch (i) {
			 case 6:// i = 6;
			 {
			 	System.out.println("Please provide the first element of the polynom from the highest to the lowest");
			 	double temp = reader.nextDouble();
			 	pol[i] = temp;
			 	break;
			 }
			 case 5:// i = 5;
			 {
				 	System.out.println("Please provide the second element of the polynom from the highest to the lowest");
				 	double temp = reader.nextDouble();
				 	pol[i] = temp;
				 	break;
			 }
			 case 4:// i = 4;
			 {
				 	System.out.println("Please provide the third element of the polynom from the highest to the lowest");
				 	double temp = reader.nextDouble();
				 	pol[i] = temp;
				 	break;
			 }
			 case 3 :// i = 3;
			 {
				 	System.out.println("Please provide the fourth element of the polynom from the highest to the lowest");
				 	double temp = reader.nextDouble();
				 	pol[i] = temp;
				 	break;
			 }
			 case 2 :// i = 2;
			 {
				 	System.out.println("Please provide the fifth element of the polynom from the highest to the lowest");
				 	double temp = reader.nextDouble();
				 	pol[i] = temp;
				 	break;
			 }
			 case 1 :// i = 1;
			 {
				 	System.out.println("Please provide the sixth element of the polynom from the highest to the lowest");
				 	double temp = reader.nextDouble();
				 	pol[i] = temp;
				 	break;
			 }
			 case 0: //i = 0;
			 {
				 	System.out.println("Please provide the seventh element of the polynom from the highest to the lowest");
				 	double temp = reader.nextDouble();
				 	pol[i] = temp;
				 	break;
			 }
			 
		 }
	 }
		 // in case, user would like to re-write big polynom with smaller polynom,
		 //this will eliminate the old values of higher degrees of previous polynom
		for (int i = choice+1; i<DIM;i++)
			pol[i]=0;
	 }
	 
	 
	 public void ausgabe_print()   // function to print the polynom
	 {
		 String ausgabe ="";
		 ausgabe = ausgabe(this.pol);
		 System.out.printf("The polynom is %s \n",ausgabe);
		 System.out.println("\n");
		 
	 } 
	 

	 public String ausgabe_return()  // function to get the polynom inside a string, without printing
	 {
		 /**
		  * 
		  * @return Polynom as string
		  */
		return ausgabe(this.pol);
		
	 }
	 
	 
	 // service function for the class - builds string from the polynom,
	 // instead toString

	 private String ausgabe(double[] p)  //calculating private function
	 {
		 /**
		  * 
		  * @param p the given polynom
		  * @param tmp_arr array of chars to contain the polynom
		  * @return polynom as string
		  */
		 String polstring = "";
		 for (int i=DIM-1;i>=0;i--)   // building the polynom and saving inside a string variable
		 {
			 if ((p[i]>0) && (p[i]-(int)p[i]==0))
				 polstring += "+" + (int)p[i] + "x^" + i;
			 else if ((p[i]>0) && (p[i]-(int)p[i]!=0))
				 polstring += "+" + p[i] + "x^" + i;
			 else if (p[i] == 0)
				 polstring += "";
			 else if ((p[i] < 0) && (p[i] - (int)p[i] != 0))
				 polstring += p[i] + "x^" + i;
			 else if ((p[i] < 0) && (p[i] - (int)p[i] == 0))
				 polstring += p[i] + "x^" + i;
			 
		 }
		 
		 polstring += " = 0";  //adds the second side of the polynom to the string
	     char[] tmp_arr = polstring.toCharArray();  // The following actions would determine if the polynom string 
		 if ((tmp_arr[0] == 43)) //starts with "+" or "-" char, convert it to array of chars,
			 tmp_arr[0] = 32;    
	     // change the first element to space, and convert back to string
		 
		 polstring = String.valueOf(tmp_arr); 
		 return polstring;
	 }
	 
	 
	 private void change (/*double[] orig_p,*/ double[] new_p)  //receives an array that contains the 
	                                                        //  new values, and saves them in the original
	                                                        // polynom
	 {
		 for (int i=DIM-1;i>=0;i--)
			 this.pol[i]=new_p[i];
		 
	 }
	 //public function to load an existing polynom with new values, 
	 //implemented but not used
	 public void change_pol(double[] new_p)
	 {
		 this.change(new_p);
	 }

	 private double get_place_value(int x)  //returns the value on the place x in the polynom
	 {
		 /**
		  * 
		  * @param x The place in polynom who's value is needed
		  * @return value on this place
		  */
		 return this.pol[x];
	 }
	 

	 public void print_value(int x)
	 {
		 /**
		  * 
		  * @param x The place in polynom who's value is needed
		  * @param value value on this place
		  */
		 double value = this.get_place_value(x);
		 System.out.println("The value on a place " + x + " is" + value + "\n");
	 }
	 
	 public Polynom summe (Polynom p1,Polynom p2)
	 {
		 /**
		  * 
		  * @param p1 First polynom
		  * @param p2 Second polynom
		  * @param result The sum of first and second polynoms
		  * @return result of the add operation 
		  */
		 Polynom result = new Polynom();
		 
		 for (int i = DIM-1; i>=0 ; i--)
			 result.pol[i] = p1.pol[i] + p2.pol[i];
		 System.out.println("The result saved in polynom 'result'");
		 return result;
		 
	 }
	 

	 public Polynom differ(Polynom p1, Polynom p2)  
	 // substracts p2 from p1, and saves the result
	 									   
	 {
		 /**
		  * 
		  * @param p1 First polynom
		  * @param p2 Second polynom
		  * @param result The difference of first nd second polynom
		  * @return Result of the difference action 
		  */
		 Polynom result = new Polynom();
		 
		 for (int i = DIM-1; i>=0 ; i--)
			 result.pol[i] = p1.pol[i] - p2.pol[i];
		 
		 System.out.println("The result saved in polynom 'result'");
		 return result;
	 }
	 
	 
	 public void abteilung()  // saves the polynom after derivative in pol_derivative. Will loose one degree
	 {
		 double temp=0;
		 this.polystring = this.ausgabe(this.pol);  // converting original polynom into string 
		 // printing the original before the derevative
		 System.out.println("The derevative of " + this.polystring + " is : \n");
		 for (int i = 0; i<DIM-1; i++)
		 {
			//calculation of derivative function
			 this.pol_derivativ[i] = this.pol[i+1]*(i+1);
		 }
		 String polstring = this.ausgabe(this.pol_derivativ);
		 System.out.println(polstring + "\n");
		 
	 }
	 

	 public Polynom  multiplication(Polynom p1, Polynom p2, Polynom result)
	 {
		 /**
		  * 
		  * @param p1 first polynom
		  * @param p2 second polynom
		  * @param result result of multiplication of first and second polynoms
		  * @param HIGH size of service array to keep the degrees of polynoms
		  * @param highest array to keep highest degree of each of the polynoms
		  * @param possible tests if it is possible to multiplicate 2 given polynoms according to provided demands 
		  * @return the result
		  */
		 
		 final int HIGH = 2;
		 // max allowed degree of result polynom after multiplication
		 final int MAX_RES=6;
		 // 
		 boolean possible;
		 // arrays to contain the highest degree of each of 
		 //the two polynoms that should be multiplieziert
		 int[] highest = new int[HIGH];
		 int i=DIM;
		 // checks the highest degree of both polynoms
         highest[0]=h_degree(p1);
         highest[1]=h_degree(p2);
         if (highest[0] + highest[1] <=MAX_RES)
        	 possible =true;
         else 
        	 possible = false;
         if (possible == false)
         {
        	 System.out.printf("Sorry, cannot perform multiplication - the degree \n");
        	 System.out.printf("of result polynom is higher then " + MAX_RES + "\n");
         }
         // if the variable possible is true, the multiplication will be calculated as following:
         else
         {
        	for(int k=DIM-1; k>=0;k--)
        	{
        		for(int l=DIM-1;l>=0;l--)
        		{
        			if (l+k<=MAX_RES)
        	           result.pol[k+l]+=p1.pol[k]*p2.pol[l]; //multiplication calculation -> saved in "result"
        			
        			
        		}
        	}
           for (int temp = highest[0] + highest[1];i<DIM;i++)
           {
        		result.pol[temp]=0;
           }
        	String res_string = result.ausgabe(result.pol);
            System.out.println("The result of multiplication is " + res_string);
         }	
         
         return result;
		  
	 }
	

	 private int h_degree(Polynom p1)
	 {
			
		 /**
		  * 
		  * @param p1 Polynom
		  * @return Highest degree of the given polynom
		  */
		 int i=DIM;
		 int result;
		 // checks the highest degree of a polynom
		 while ((p1.pol[i-1]==0) && (i>=0))
		 {
			 i--;
			 
		 }
		 if (i<0)
			 result=0;
		 else
			 result=i-1;
		 return result;
	 }

}
