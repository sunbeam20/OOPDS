import java.util.*;
import java.util.Scanner;
/**
 *Restaurant Class Contains Restaurant name and menu 
 */
public class Restaurant{
/**
* 	Declared restaurantName of String data type, to hold the Name of the restaurant 
*/
	public String restaurantName;
/**
* 	Declared dishName Arraylist of String data type, to hold the Name of the Menu 
*/
/**
* 	Declared dishCode Arraylist of Integer data type, to hold the Code of the Menu 
*/
/**
* 	Declared dishPrice Arraylist of Double data type, to hold the Price of the Menu 
*/
	protected List <String> dishName = new ArrayList<>();
	protected List <Integer> dishCode = new ArrayList<>();
	protected List <Double> dishPrice = new ArrayList<>();
/**
* 	This void Method viewMenu - Views Specific Restaurant menu by Its object
*	@param r Object of Restaurant Class
*/	
	public void viewMenu(Restaurant r){
		int i=0;
		System.out.println("\n\nRestaurant " + r.restaurantName);
		System.out.println("Code \tPrice(RM) \tItem");
		do{		
			System.out.print(r.dishCode.get(i)+ "\t");
			System.out.print(r.dishPrice.get(i)+ "\t\t");
			System.out.println(r.dishName.get(i) + "\t");
			i++;
		}while(i<r.dishName.size());
	}
/**
* 	This void Method addMenu - adds Menu to Specific Restaurant 
*	@param name of the menu
*	@param code of the menu
*	@param price of the menu
*/
	public void addMenu(String name, int code, double price){
		dishName.add(name);
		dishCode.add(code);
		dishPrice.add(price);
	}
/**
* 	This void Method setMenu - updates Menu to Specific Restaurant 
*	@param code of the menu
*	@param name of the menu
*	@param price of the menu
*/
	public void setMenu(int code, String name, double price){
		boolean found = false;
		int i=0;
		do{
			if(code == dishCode.get(i)){
				dishName.set(i, name);
				dishPrice.set(i, price);
				found = true;
			}
			i++;
		}while(i<dishCode.size());
		if (found==false)
			System.out.println("Invalid Dish Code");
	}
/**
* 	This void Method deleteMenu - deletes Menu of Specific Restaurant 
*	@param code of the menu
*/
	public void deleteMenu(int code){
		int i=0;
		do{
			if(code == dishCode.get(i)){
				dishName.remove(i);
				dishCode.remove(i);
				dishPrice.remove(i);
			}
			i++;
		}while(i<dishCode.size());
	}
}
/**
 *Foodeliver Class - (child class of Restaurant) - it holds all order information 
 */
class Foodeliver extends Restaurant{
/**
* 	Declared orderName Arraylist of String data type, to hold the Name of the OrderedDish 
*/
/**
* 	Declared orderCode Arraylist of Integer data type, to hold the Code of the OrderedDish 
*/
/**
* 	Declared orderPrice Arraylist of Double data type, to hold the Price of the OrderedDish 
*/
/**
* 	Declared orderStatus Arraylist of String data type, to hold the Status of the Order 
*/
/**
* 	Declared cstmrName Arraylist of String data type, to hold the Name who ordered 
*/
/**
* 	Declared rstrntName Arraylist of String data type, to hold the Name of the Restaurant from which order is placed 
*/
/**
* 	Declared deliveryMethod Arraylist of String data type, to hold the way of collecting the order 
*/
/**
* 	Declared handedTo Arraylist of String data type, to hold the name who will recieve the order from restaurant 
*/
	public static List <String> orderName = new ArrayList<>();
	public static List <Integer> orderCode = new ArrayList<>();
	public static List <Double> orderPrice = new ArrayList<>();
	public static List <String> orderStatus = new ArrayList<>();
	public static List <String> cstmrName = new ArrayList<>();
	public static List <String> rstrntName = new ArrayList<>();
	public static List <String> deliveryMethod = new ArrayList<>();
	public static List <String> handedTo = new ArrayList<>();
/**
* 	This void Method preAddOrder - adds order at the start of Program 
*	@param code of the menu
*	@param r is a Object of Restaurant
*	@param cname holds who ordered the food
*	@param rname holds from which restaurant order is made
*	@param s is a rider who delivered the order
*/
	public void preAddOrder(int code, Restaurant r, String cname, String rname, Rider s){
		int i=0;
		do{
			if(code == r.dishCode.get(i)){
				orderCode.add(code);
				orderName.add(r.dishName.get(i));
				orderPrice.add(r.dishPrice.get(i));
				orderStatus.add("Delivered");
				cstmrName.add(cname);
				rstrntName.add(rname);
				deliveryMethod.add("Rider");
				if(i%2==1)
					handedTo.add(s.riderName.get(0));
				else
					handedTo.add(s.riderName.get(1));
			}
			i++;
		}while(i<r.dishCode.size());
	}
/**
* 	This void Method addOrder - places order for customer 
*	@param code of the menu
*	@param r is a Object of Restaurant
*	@param cname holds who ordered the food
*	@param rname holds from which restaurant order is made
*	@param s is a rider who delivered the order
*/
	public void addOrder(int code, Restaurant r, String cname, String rname, int collect){
		int i=0;
		do{
			if(code == r.dishCode.get(i)){
				orderCode.add(code);
				orderName.add(r.dishName.get(i));
				orderPrice.add(r.dishPrice.get(i));
				orderStatus.add("Pending ");
				cstmrName.add(cname);
				rstrntName.add(rname);
				handedTo.add("Pending");
				if(collect==1)
					deliveryMethod.add("Collect");
				else if(collect==2)
					deliveryMethod.add("Rider");
			}
			i++;
		}while(i<r.dishCode.size());
	}
/**
* 	This void Method viewAllOrder - views all order histories 
*/
	public void viewAllOrder(){
		int i=0;
		do{
			System.out.print(orderName.get(i)  + "\t");
			System.out.print(orderCode.get(i)  + "\t");
			System.out.print(orderPrice.get(i) + "\t");
			System.out.print(orderStatus.get(i) + "\t");
			System.out.print(rstrntName.get(i) + "\t");
			System.out.print(cstmrName.get(i) + "\t");
			System.out.print(handedTo.get(i) + "\t");
			System.out.println(deliveryMethod.get(i) + "\t");
			i++;
		}while(i<orderName.size());
	}
/**
* 	This void Method viewOrder - views order for a selected customer 
*	@param cname holds who ordered the food
*/
	public void viewOrder(String cname){
		int i=0;
		do{
			if(cstmrName.get(i) == cname){
				System.out.print(orderName.get(i)  + "\t");
				System.out.print(orderCode.get(i)  + "\t");
				System.out.print(orderPrice.get(i) + "\t");
				System.out.print(orderStatus.get(i) + "\t");
				System.out.print(rstrntName.get(i) + "\t");
				System.out.print(handedTo.get(i) + "\t");
				System.out.print(deliveryMethod.get(i) + "\t");
				System.out.println();
			}
			i++;
		}while(i<cstmrName.size());
	}
/**
* 	This void Method viewOrder - views order for a selected customer 
*	@param rname holds from which restaurant food is ordered
*/
	public void viewOrderForRestaurant(String rname){
		int i=0;
		do{
			if(rstrntName.get(i) == rname){
				System.out.print(orderName.get(i)  + "\t");
				System.out.print(orderCode.get(i)  + "\t");
				System.out.print(orderPrice.get(i) + "\t");
				System.out.print(orderStatus.get(i) + "\t");
				System.out.print(cstmrName.get(i) + "\t");
				System.out.print(handedTo.get(i) + "\t");
				System.out.print(deliveryMethod.get(i) + "\t");
				System.out.println();
			}
			i++;
		}while(i<rstrntName.size());
	}
/**
* 	This void Method setStatusByRestaurant - updates the status of current order by restaurant owner 
*	@param code holds code of the food
*	@param status holds the new of the food
*/
	public void setStatusByRestaurant(int code, int status){
		int i=0;
		do{
			if(code == orderCode.get(i) && orderStatus.get(i) != "Delivered"){
				if(status == 1){
					orderStatus.set(i, "Preparing");
				}
				else if(status == 2){
					orderStatus.set(i, "Ready\t");
				}
			}
			i++;
		}while(i<orderCode.size());
	}
/**
* 	This void Method setStatusByRider - updates the status of order by rider who is assigned for the particular delivery 
*	@param j holds index of the ridername
*	@param s holds the driver object
*	@param code holds code of the food
*/
	public void setStatusByRider(int j,  Rider s, int code){
		int i=0;
		do{
			if(code == orderCode.get(i) && orderStatus.get(i) == "Ready\t" && s.riderName.get(j) == handedTo.get(i)){
				orderStatus.set(i, "Delivered");
				s.queue.enqueue(s.riderName.get(j));
			}
			i++;
		}while(i<handedTo.size());
	}
/**
* 	This void Method selfCollectFromRestaurant - lets the Customer to collect the code 
*	@param code holds code of the food
*/
	public void selfCollectFromRestaurant(int code){
		int i=0;
		do{
			if(code==orderCode.get(i) && orderStatus.get(i) == "Ready\t" && deliveryMethod.get(i) == "Collect"){
				orderStatus.set(i, "Delivered");
				handedTo.set(i, cstmrName.get(i));
			}
			i++;
		}while(i<orderCode.size());
	}
/**
* 	This void Method assignRiderFromQueue - assigns the rider from the queue for the order which is ready to serve 
*	@param code holds code of the food
*	@param s holds the driver object
*/
	public void assignRiderFromQueue(int code, Rider s){
		int i=0;
		do{
			if(code==orderCode.get(i) && deliveryMethod.get(i) == "Rider" && orderStatus.get(i) != "Delivered"){
				handedTo.set(i, s.queue.dequeue());
			}
			i++;
		}while(i<orderCode.size());
	}
/**
* 	This void Method viewStatisticsByRider - shows the statistics of all orders delivered by riders 
*	@param s holds the driver object
*/
	public void viewStatisticsByRider(Rider s){
		
		int count;
		int i=0;
		System.out.println("Rider Name\tOrder Delivered");
		do{
			count=0;
			int j=0;
			do{
				if(s.riderName.get(i) == handedTo.get(j) && orderStatus.get(j) == "Delivered")
					count++;
				j++;
			}while(j<handedTo.size());
			
			System.out.println(s.riderName.get(i) + "   \t\t" + count);
			i++;
		}while(i<s.riderName.size());
	}
}
/**
 *Customer Class child class of Foodeliver - it holds customerName 
 */
class Customer extends Foodeliver{
/**
* 	Declared customerName of String data type, to hold the Name of the customer 
*/
	public String customerName ;
}
/**
 *Rider Class - (child class of Foodeliver) - it holds rider name and Queue 
 */
class Rider extends Foodeliver{
/**
* 	Declared riderName Arraylist of String data type, to hold the Name of the Rider 
*/
/**
* 	Declared CustomGEnericqueue of String data type, to hold the Name of the Rider in the queue 
*/
	public List <String> riderName = new ArrayList<>();
	public GenericQueue<String> queue = new GenericQueue<>();
}
class main{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		Rider driver = new Rider();
		driver.riderName.add("Sumaya");
		driver.riderName.add("Sunbeam");
		driver.queue.enqueue(driver.riderName.get(0));
		driver.queue.enqueue(driver.riderName.get(1));
		//driver.queue.dequeue();
		
		
		Restaurant mamak = new Restaurant();
		Restaurant mcd = new Restaurant();
		Restaurant arab = new Restaurant();
		mamak.restaurantName= "Mamak";
		mcd.restaurantName="Mcd";
		arab.restaurantName="Arab";
		
		Foodeliver order1 = new Foodeliver();
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		c1.customerName="Alex";
		c2.customerName="Mahi";
		c3.customerName="Eco";
		
		mamak.addMenu("Nasi Goreng", 101, 10.5);
		mamak.addMenu("Nasi Lemak", 102, 8.5);
		mamak.addMenu("Nasi Kandar", 103, 7.0);
		
		mcd.addMenu("Chicken Burger", 201, 8.5);
		mcd.addMenu("Cheese Burger", 202, 9.5);
		mcd.addMenu("Beef Burger", 203, 11.0);
		
		arab.addMenu("Lamb Kabsa", 301, 11.0);
		arab.addMenu("Chicken Kabsa", 302, 9.5);
		arab.addMenu("Mundi Chicken", 303, 12.5);
		
		order1.preAddOrder(101, mamak, c1.customerName, mamak.restaurantName, driver);
		order1.preAddOrder(102, mamak, c1.customerName, mamak.restaurantName, driver);
		
		order1.preAddOrder(301, arab, c2.customerName, arab.restaurantName, driver);
		order1.preAddOrder(302, arab, c2.customerName, arab.restaurantName, driver);
		
		order1.preAddOrder(201, mcd, c3.customerName, mcd.restaurantName, driver);
		order1.preAddOrder(202, mcd, c3.customerName, mcd.restaurantName, driver);
		
		int i;
		int user;
		do{
			System.out.println("Log in as ");
		System.out.println("_____________");
		System.out.println("1) Customer");
		System.out.println("2) Restaurant");
		System.out.println("3) Admin");
		System.out.println("4) Rider");
		System.out.println("5) Exit the program");
		System.out.print(">");
		user = input.nextInt();
		
		if(user == 1){
			int cstmr;
			System.out.println("Choose your name");
			System.out.println("1) "+c1.customerName+" 2) " + c2.customerName+" 3) " + c3.customerName);
			cstmr = input.nextInt();
			if(cstmr==1){
				int option;
				System.out.print("Logged in as Customer ");
				System.out.println(c1.customerName);
				System.out.println("______________________");
				System.out.print("1) Purchase Food\n2) View Order Status & History\n3) Collect Food from Restaurant\n4) Sign Out\n");
				System.out.print("\nInput ('1', '2','3' or '4')\n>");
				option = input.nextInt();
				if(option == 1){
					c1.viewMenu(mamak);
					c1.viewMenu(mcd);
					c1.viewMenu(arab);
					
					System.out.println("___________________");
					System.out.print("A) Restaurant MAMAK\nB) Restaurant MCD\nC) Restaurant ARAB");
					System.out.print("\nFirst Choose a Restaurant (Input 'A', 'B'or 'C' ) \n>");
					char choice = input.next().charAt(0);
					
					if(choice == 'a'|| choice =='A'){
						c1.viewMenu(mamak);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c1.addOrder(pCode, mamak, c1.customerName, mamak.restaurantName, method);
					}
					else if(choice == 'b' || choice == 'B'){
						c1.viewMenu(mcd);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c1.addOrder(pCode, mcd, c1.customerName, mcd.restaurantName, method);
					}
					else if(choice == 'c' || choice == 'C'){
						c1.viewMenu(arab);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c1.addOrder(pCode,arab, c1.customerName, arab.restaurantName, method);
					}
				}
				else if(option ==2){
					order1.viewOrder(c1.customerName);
				}
				else if(option==3){
					order1.viewOrder(c1.customerName);
					System.out.print("\n\nEnter the code of the food to collect >");
					int code = input.nextInt();
					c1.selfCollectFromRestaurant(code);
				}
			}
			else if(cstmr==2){
				int option;
				System.out.print("Logged in as Customer ");
				System.out.println(c2.customerName);
				System.out.println("______________________");
				System.out.print("1) Purchase Food\n2) View Order Status & History\n3) Collect Food from Restaurant\n4) Sign Out\n");
				System.out.print("\nInput ('1', '2','3' or '4')\n>");
				option = input.nextInt();
				if(option == 1){
					c2.viewMenu(mamak);
					c2.viewMenu(mcd);
					c2.viewMenu(arab);
					
					System.out.println("___________________");
					System.out.print("A) Restaurant MAMAK\nB) Restaurant MCD\nC) Restaurant ARAB");
					System.out.print("\nFirst Choose a Restaurant (Input 'A', 'B'or 'C' ) \n>");
					char choice = input.next().charAt(0);
					if(choice == 'a'|| choice =='A'){
						c2.viewMenu(mamak);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c2.addOrder(pCode, mamak, c2.customerName, mamak.restaurantName, method);
					}
					else if(choice == 'b' || choice == 'B'){
						c2.viewMenu(mcd);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c2.addOrder(pCode, mcd, c2.customerName, mcd.restaurantName, method);
					}
					else if(choice == 'c' || choice == 'C'){
						c2.viewMenu(arab);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c2.addOrder(pCode, arab, c2.customerName, arab.restaurantName, method);
					}
				}
				else if (option ==2){
					c2.viewOrder(c2.customerName);
				}
				else if(option==3){
					order1.viewOrder(c2.customerName);
					System.out.print("\n\nEnter the code of the food to collect >");
					int code = input.nextInt();
					c2.selfCollectFromRestaurant(code);
				}
			}
			else if(cstmr==3){
				int option;
				System.out.print("Logged in as Customer ");
				System.out.println(c3.customerName);
				System.out.println("______________________");
				System.out.print("1) Purchase Food\n2) View Order Status & History\n3) Collect Food from Restaurant\n4) Sign Out\n");
				System.out.print("\nInput ('1', '2','3' or '4')\n>");
				option = input.nextInt();
				if(option == 1){
					c3.viewMenu(mamak);
					c3.viewMenu(mcd);
					c3.viewMenu(arab);
					
					System.out.println("___________________");
					System.out.print("A) Restaurant MAMAK\nB) Restaurant MCD\nC) Restaurant ARAB");
					System.out.print("\nFirst Choose a Restaurant (Input 'A', 'B'or 'C' ) \n>");
					char choice = input.next().charAt(0);
					if(choice == 'a'|| choice =='A'){
						c3.viewMenu(mamak);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c3.addOrder(pCode, mamak, c3.customerName, mamak.restaurantName, method);
					}
					else if(choice == 'b' || choice == 'B'){
						c3.viewMenu(mcd);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c3.addOrder(pCode, mcd, c3.customerName, mcd.restaurantName, method);
					}
					else if(choice == 'c' || choice == 'C'){
						c3.viewMenu(arab);
						System.out.print("Choose the code to purchase: ");
						int pCode = input.nextInt();
						System.out.print("Choose \n1) Self Collect from Restaurant \n2) Get Delivered\n> ");
						int method = input.nextInt();
						c3.addOrder(pCode, arab, c3.customerName, arab.restaurantName, method);
					}
				}
				else if (option ==2){
					c3.viewOrder(c3.customerName);
				}
				else if(option==3){
					order1.viewOrder(c3.customerName);
					System.out.print("\n\nEnter the code of the food to collect >");
					int code = input.nextInt();
					c3.selfCollectFromRestaurant(code);
				}
			}
		}
		else if (user ==2){
			int rstrnt;
			System.out.println("Choose your restaurant");
			System.out.println(mamak.restaurantName + " " +mcd.restaurantName + " " + arab.restaurantName + " ");
			rstrnt = input.nextInt();
			if(rstrnt ==1){
				int option;
				System.out.println("Logged in as Restaurant " + mamak.restaurantName);
				System.out.println("______________________");
				mamak.viewMenu(mamak);
				
				System.out.println("1) Add menu\n2) Update Menu\n3) Delete Menu\n4) View Order History\n5) Update Order Status");
				option = input.nextInt();
				if(option ==1){
					System.out.print("Enter the name of the food > ");
					input.nextLine();
					String menuName = input.nextLine();
					
					System.out.print("Enter new Code of the food > ");
					int menuCode = input.nextInt();
					
					System.out.print("Enter new Price of the food > ");
					double menuPrice = input.nextDouble();
					mamak.addMenu(menuName,menuCode,menuPrice);
				}
				else if(option ==2){
					System.out.print("Enter the code of the food to update > ");
					int menuCode = input.nextInt();
					System.out.print("Enter new name of the food > ");
					input.nextLine();
					String menuName = input.nextLine();
					System.out.print("Enter new price of the food > ");
					double menuPrice = input.nextDouble();
					mamak.setMenu(menuCode, menuName, menuPrice);
				}
				else if(option == 3){
					System.out.print("Enter the code of the food to delete > ");
					int menuCode = input.nextInt();
					mamak.deleteMenu(menuCode);
				}
				else if (option ==4){
					order1.viewOrderForRestaurant(mamak.restaurantName);
				}
				else if(option ==5){
					order1.viewOrderForRestaurant(mamak.restaurantName);
					System.out.print("Enter the code of the food to update status > ");
					int menuCode = input.nextInt();
					System.out.print("Enter 1) Preparing \n2) Ready > ");
					int status = input.nextInt();
					order1.setStatusByRestaurant(menuCode, status);
					if(status ==2){
						order1.assignRiderFromQueue(menuCode, driver);
					}
				}
			}
			else if(rstrnt ==2){
				int option;
				System.out.println("Logged in as Restaurant " + mcd.restaurantName);
				System.out.println("______________________");
				mcd.viewMenu(mcd);
				System.out.println("1) Add menu\n2) Update Menu\n3) Delete Menu\n4) View Order History\n5)Update Order Status");
				option = input.nextInt();
				if(option ==1){
					System.out.print("Enter the name of the food > ");
					input.nextLine();
					String menuName = input.nextLine();
					
					System.out.print("Enter new Code of the food > ");
					int menuCode = input.nextInt();
					
					System.out.print("Enter new Price of the food > ");
					double menuPrice = input.nextDouble();
					mcd.addMenu(menuName,menuCode,menuPrice);
				}
				else if(option ==2){
					System.out.print("Enter the code of the food to update > ");
					int menuCode = input.nextInt();
					System.out.print("Enter new name of the food > ");
					input.nextLine();
					String menuName = input.nextLine();
					System.out.print("Enter new price of the food > ");
					double menuPrice = input.nextDouble();
					mcd.setMenu(menuCode, menuName, menuPrice);
				}
				else if(option == 3){
					System.out.print("Enter the code of the food to delete > ");
					int menuCode = input.nextInt();
					mcd.deleteMenu(menuCode);
				}
				else if (option ==4){
					order1.viewOrderForRestaurant(mcd.restaurantName);
				}
				else if(option ==5){
					order1.viewOrderForRestaurant(mcd.restaurantName);
					System.out.print("Enter the code of the food to update status > ");
					int menuCode = input.nextInt();
					System.out.print("Enter 1) Preparing \n2) Ready > ");
					int status = input.nextInt();
					order1.setStatusByRestaurant(menuCode, status);
				}
			}
			else if(rstrnt ==3){
				int option;
				System.out.println("Logged in as Restaurant " + arab.restaurantName);
				System.out.println("______________________");
				arab.viewMenu(arab);
				System.out.println("1) Add menu\n2) Update Menu\n3) Delete Menu\n4) View Order History\n5)Update Order Status");
				option = input.nextInt();
				if(option ==1){
					System.out.print("Enter the name of the food > ");
					input.nextLine();
					String menuName = input.nextLine();
					
					System.out.print("Enter new Code of the food > ");
					int menuCode = input.nextInt();
					
					System.out.print("Enter new Price of the food > ");
					double menuPrice = input.nextDouble();
					arab.addMenu(menuName,menuCode,menuPrice);
				}
				else if(option ==2){
					System.out.print("Enter the code of the food to update > ");
					int menuCode = input.nextInt();
					System.out.print("Enter new name of the food > ");
					input.nextLine();
					String menuName = input.nextLine();
					System.out.print("Enter new price of the food > ");
					double menuPrice = input.nextDouble();
					arab.setMenu(menuCode, menuName, menuPrice);
				}
				else if(option == 3){
					System.out.print("Enter the code of the food to delete > ");
					int menuCode = input.nextInt();
					arab.deleteMenu(menuCode);
				}
				else if (option ==4){
					order1.viewOrderForRestaurant(arab.restaurantName);
				}
				else if(option ==5){
					order1.viewOrderForRestaurant(arab.restaurantName);
					System.out.print("Enter the code of the food to update status > ");
					int menuCode = input.nextInt();
					System.out.print("Enter 1) Preparing \n2) Ready > ");
					int status = input.nextInt();
					order1.setStatusByRestaurant(menuCode, status);
				}
			}
		}
		else if(user == 3){
			System.out.println("Logged in as Admin");
			System.out.print("1) Add Riders to the system\n2) View Rider Queue\n3) All Order Histories\n4) Order Statistics\n>");
			int option = input.nextInt();
			if(option==1){
				System.out.print("Enter the name of the rider to add > ");
				String newRider = input.next();
				driver.riderName.add(newRider);
				driver.queue.enqueue(newRider);
			}
			else if(option==2){
				System.out.println(driver.queue);
			}
			else if(option ==3){
				order1.viewAllOrder();
			}
			else if(option==4){
				System.out.print("Show statistics by \n1) By Rider \n2) By Customer\n");
				option = input.nextInt();
				if(option==1)
					order1.viewStatisticsByRider(driver);
				//else if(option==2)
					
			}
		}
		else if(user ==4){
			i=0;
			System.out.println("Logged in as Rider");
			System.out.println("Choose your identity");
			do{
				System.out.println(i + ") " +driver.riderName.get(i));
				i++;
			}while(i<driver.riderName.size());
			i=input.nextInt();
			System.out.println("1) Deliver an Order \n2) View OrderStatus & History \n3) Check my turn");
			int option=input.nextInt();
			if(option==1){
				driver.viewAllOrder();
				System.out.print("Enter the code to deliver the order > ");
				int deliver = input.nextInt();
				driver.setStatusByRider(i, driver, deliver);
			}
			else if(option ==2){
				driver.viewAllOrder();
			}
			else if(option ==3){
				System.out.println(driver.queue);
				System.out.print("Choose your name (Index starts from 0)> ");
				i = input.nextInt();
				if(i==0)
				System.out.println("Your turn next");	
				else
				System.out.println("Your turn is after '" + i + "' riders");
			}
		}
		}while(user != 5);
	}
}