import java.util.Scanner;

/**
 * 
 * @author Vladimir Vilenchik s0556191@htw-berlin.de
 * @since 10.11.2016
 * @version 1.0.0
 *
 */

public class test_polynom {
	public static void main (String[] args)
	{
		/**
		 *
		 *@param SIZE Size of array to contain the polynoms
		 *@param pols Array of the polynoms
		 *@param selection Contains the user's choice in the menu
		 *@param selection_print Contains the user's choice from the printing menu
		 *@param choice Array to contain on which arrays will the future operation holden
		 *@throws Will give input mismatch for every input that is not integer number in all the menus
		 *@throws If "99" is chosen in the very first menu, it will be shown one more time anyway
		 *
		 */
		final int SIZE=4;  //size of array that will contain the polynoms
		final int SIZE_CHOICE=2;
		int selection=0,selection_print=0;  //
		//array to keep, on which polynoms will the future operation held
		int[] choice = new int[SIZE_CHOICE];
		//array for polynoms and result
		Polynom[] pols = new Polynom[SIZE];
		
		for(int j=0;j<SIZE;j++)//array to contain 3 polynoms + one polynom as result of last operation 
		{
			pols[j] = new Polynom();
		}
		selection = menu();
		do
		{
			
			switch (selection)  {
			case 1 : //selection = 1;
			{
				pols[0].eingabe();
				break;
			}
			case 11 : //selection = 11;
			{
				pols[1].eingabe();
				break;
			}
			case 111 : //selection = 111;
			{
				pols[2].eingabe();
				break;
			}
			case 2 : //selection = 2;
			{
				selection_print = menu_print();
				if (selection_print == 1)
					pols[0].ausgabe_print();
				else if (selection_print == 11)
					pols[1].ausgabe_print();
				else if (selection_print ==111)
					pols[2].ausgabe_print();
				else if (selection_print ==1111)
					pols[3].ausgabe_print();
				break;
			}
			case 3 :
			{
				choice = menu_operation();
				//result polynom wil contain add operation of the two choosen polynoms (out of 3 available)
				pols[3]=pols[choice[0]-1].summe(pols[choice[0]-1], pols[choice[1]-1]);
				break;
			}
			case 4 :
			{
				choice = menu_operation();
				//result polynom wil contain add operation of the two choosen polynoms (out of 3 available)
				pols[3]=pols[choice[0]-1].differ(pols[choice[0]-1], pols[choice[1]-1]);
				break;
			}
			case 5 :
			{
				selection_print = menu_print();
				if (selection_print == 1)
					pols[0].abteilung();
				else if (selection_print == 11)
					pols[1].abteilung();
				else if (selection_print ==111)
					pols[2].abteilung();
				else if (selection_print ==1111)
					pols[3].abteilung();
				break;
			}
			
			case 6 :
			{
				choice = menu_operation();
				pols[3]=pols[choice[0]-1].multiplication(pols[choice[0]-1], pols[choice[1]-1], pols[3]);
				break;
			}
			
			case 7 :
			{
				selection_print = menu_single_choice_general();
				System.out.println("Please provide the place inside the polynom");
				Scanner value = new Scanner(System.in);
				int place = value.nextInt();
				if (selection_print == 1)
					pols[0].print_value(place);
				else if (selection_print == 11)
					pols[1].print_value(place);
				else if (selection_print ==111)
					pols[2].print_value(place);
				else if (selection_print ==1111)
					pols[3].print_value(place);
				break;
			}
			default :
			{
				//System.out.printf("Sorry wrong input, please try again \44n");
				break;
			}
		
			}
			String temp_str;
			System.out.println("\n");
			temp_str = pols[0].ausgabe_return();
			System.out.println("The first polynom is \n" + temp_str);
			temp_str = pols[1].ausgabe_return();
			System.out.println("The second polynom is \n" + temp_str);
			temp_str = pols[2].ausgabe_return();
			System.out.println("The third polynom is \n" + temp_str);
			temp_str = pols[3].ausgabe_return();
			System.out.println("The result of last operation, excluding derevative is \n" + temp_str);

			selection = menu();  //self comment - was important to prevent infinite loop
		} while (selection!=99);
		
		
		System.out.printf("*********Finished******** \n");		
		
	}
	
    public static int menu() {
    	/**
    	 * @return selection
    	 */

        int selection;  //can use same name, the variable is absolutely local
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Choose from the following choices");
        System.out.println("-------------------------\n");
        System.out.println("(1)   - Enter first polynom");
        System.out.println("(11)  - Enter second polynom");
        System.out.println("(111) - Enter third polynom");
       // System.out.println("1111 - Enter result polynom");
        System.out.println("(2)   - Print a polynom");
        System.out.println("(3)   - Add 2 polynoms");
        System.out.println("(4)   - Difference of 2 polynoms");
        System.out.println("(5)   - Deravative of a polynom");
        System.out.println("(6)   - Multiplication of 2 polynoms");
        System.out.println("(7)   - Get the value on a specific place (place as a degree)");
        System.out.println("(99)   - Quit");

        selection = input.nextInt();
        
        System.out.println("\n");
        
        return selection;    
    }
    
    public static int menu_print() {  //this is a mini-menu, to choose which polynom to print 

    	/**
    	 * @return selection for printing
    	 */
        int selection;  //can use same name, the variable is absolutely local
        Scanner input = new Scanner(System.in);

        /***************************************************/

      //  System.out.println("Choose from these choices - which polynom would you like to print ?");
        System.out.println("Choose from these choices ");
        System.out.println("-------------------------\n");
        System.out.println("(1)   -  Enter first polynom");
        System.out.println("(11)  -  Enter second polynom");
        System.out.println("(111) -  Enter third polynom");
        System.out.println("(1111) - Result of the last operation");
        System.out.println("(99)   - Quit");

        selection = input.nextInt();
        return selection;    
    }
    
    public static int menu_single_choice_general() {  

        int selection;  //can use same name, the variable is absolutely local
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Choose from these choices ");
        System.out.println("-------------------------\n");
        System.out.println("(1)   -  Enter first polynom");
        System.out.println("(11)  -  Enter second polynom");
        System.out.println("(111) -  Enter third polynom");
        System.out.println("(1111) - Result of the last operation");
        System.out.println("(99)   - Quit");

        selection = input.nextInt();
        return selection;    
    }
    
    //menu to choose on which polynoms would the operation be handled
    public static int[] menu_operation()
    {
    	/**
    	 * @param selection Array that keeps the choosen polynoms
    	 * @return array with the polynoms (on which the user wants to perform the operation)
    	 */
    	final int SIZE=2; //
    	int selection[] = new int[SIZE];
    	for (int i=0;i<SIZE;i++)
    		selection[i]=0;
    	
    	Scanner input = new Scanner(System.in);
    	
        System.out.println("Choose first polynom for the operation:");
        System.out.println("-------------------------\n");
        System.out.println("(1)   -  Enter first polynom");
        System.out.println("(11)  -  Enter second polynom");
        System.out.println("(111) -  Enter third polynom");
        selection[0]=input.nextInt();
        
        System.out.println("Choose second polynom for the operation:");
        System.out.println("-------------------------\n");
        System.out.println("(1)   -  Enter first polynom");
        System.out.println("(11)  -  Enter second polynom");
        System.out.println("(111) -  Enter third polynom");
        selection[1]=input.nextInt();
        //converts the choice for future use into array numbers
        for (int i=0;i<SIZE;i++)
        {
        	if (selection[i]==1)
        		selection[i]=1;
        	else if (selection[i]==11)
        		selection[i]=2;
        	else if(selection[i]==111)
        		selection[i]=3;
        	else
        		selection[i]=0;
        }
        
        return selection;
    	
    	
    	
    }

}
