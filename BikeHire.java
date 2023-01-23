
package bikehire;



import java.io.*;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;



 
public class BikeHire {

  private FileInputStream fis;
  private ObjectInputStream ois;
  private FileOutputStream fos;
  private ObjectOutputStream oos; 
    
    
  private ArrayList<Bike> bikes; 
  private ArrayList<Customer> customers; 
  private ArrayList<Rent> rents;
  
  public BikeHire(){
      bikes = new ArrayList<Bike>();
       customers = new ArrayList<Customer>();   
       rents = new ArrayList<Rent>();
   
  }
  
    public void populateLists(){
    bikes.clear();
    customers.clear();
    rents.clear();
      Bike[] arrOfBikes = {new Bike(74.5, true, "mountain"), new Bike(61.5, true, "road"),
          new Bike(35, true, "bmx"), new Bike(90, true, "city"), new Bike(86.5, true, "city"), new Bike(43.5, true, "bmx"),
           new EBike(83.5, true, "ebike", 20.5, "Full power"),new EBike(95.5, true, "ebike", 25, "Full power"),
           new EBike(77.5, true, "ebike", 14.5, "Power assist"),new EBike(80, true, "ebike", 19, "Power assist"),
           new EBike(65, true, "ebike", 6.5, "Power assist"),new EBike(120.5, true, "ebike", 30, "Full power")};  
      
      Customer[] arrOfCustomers = {new Customer("Alex", 04534534543), 
           new Customer("Jack", 04534534543), new Customer("Sam", 04577777543)};
      
     Rent[] arrOfRents = {new Rent(115, 3555, 21), new Rent(132, 6485, 29), new Rent(126, 9964, 13)}; 
   
      
     
     for(int i = 0; i < arrOfBikes.length; i++)
       bikes.add(arrOfBikes[i]);
     for(int i = 0; i < arrOfCustomers.length; i++)
       customers.add(arrOfCustomers[i]);
     for(int i = 0; i < arrOfRents.length; i++)
       rents.add(arrOfRents[i]);
     
     
     
 
 }
  
    public static void main(String[] args) {
    BikeHire bh = new BikeHire();
    bh.populateLists();
    bh.run();
    }
    
 public void run() {
    boolean flag = true;
    Scanner userInput = new Scanner(System.in);
    while (flag) {
      System.out.println("Welcome to Matthew's Bike Shop!\n------------------------\n"+
      "1: Display all available bikes\n" +    
      "2: Add bike\n"+              
      "3: List all customers\n"+    
      "4: Search for a customer by id and display all details for that customer\n"+          
      "5: Add new customer\n" +        
      "6: List all rents\n"+   
      "7: Add rent, user selecting an available bike, customer and duration (max 30 days).\n"+            
      "8: Return a rented bike\n"+           
      "9: Display all overdue rents\n"+  
      "10: Save all data in files as appropriate\n"+  
      "11: Read data from files\n"+     
      "12: Exit\n");
      
      System.out.print("Choose an option: ");
      int option = userInput.nextInt();
      userInput.nextLine();
      switch (option) {
        case 1:
          displayAllAvailableBikes();
          break;
        case 2:
          addBike();
          break;
        case 3:
          listAllCustomers();
          break;
        case 4: 
          searchCustomerById();
        break;
        case 5:
          addCustomer();
          break;
        case 6:
          listRents();
          break;
        case 7:
          addRent();
          break;
        case 8:         
          ReturnBike();
        break;
        case 9:
          displayOverdueRents();
        break;
        case 10:
          saveAllData();
        break;
        case 11:
          readAllData();
          break;
        case 12:
          flag = false;
          break;
        default:
          System.out.println("Please choose one of the above options");
        }
    
    }
    
  }   

 
 //option 1
 public void displayAllAvailableBikes() {
      for (Bike b:bikes) {
       if (b.getBikeAvailability())
          System.out.println(b);
       else
           System.out.println("No available bikes");
    }
      
  } 
 
 
 //option 2
public void addBike() {
 
    Scanner userInput = new Scanner(System.in);
    System.out.print("What is the hire price per day? ");
    double pricerPerDay = userInput.nextDouble();     
    System.out.print("What is the bike type? (road/mountain/bmx/city/ebike) ");
    String bikeType = userInput.nextLine();
    boolean bikeAvailability = false;
    
//    if ("ebike".equals(bikeType)){
//       System.out.print("What is the maximum distance of the ebike? (in km) ");  
//       double maxDistance = userInput.nextDouble();
//       System.out.print("What is the motor strength of the ebike? (full power or power assist) ");  
//       String motorStrength = userInput.nextLine(); 
//       Bike newBike = new EBike(pricerPerDay, bikeAvailability, bikeType, maxDistance, motorStrength); 
//       
//       bikes.add(newBike);
//    }
//    
//  if ("road".equals(bikeType)){
//    Bike newBike = new Bike(pricerPerDay, bikeAvailability, bikeType);     
//    bikes.add(newBike);
//  }
//   if ("mountain".equals(bikeType)){
//    Bike newBike = new Bike(pricerPerDay, bikeAvailability, bikeType); 
//    bikes.add(newBike);
//  }
   
   switch (bikeType) {
        case "ebike":
          System.out.print("What is the maximum distance of the ebike? (in km) ");  
       double maxDistance = userInput.nextDouble();
       System.out.print("What is the motor strength of the ebike? (full power or power assist) ");  
       String motorStrength = userInput.nextLine(); 
       Bike newEBike = new EBike(pricerPerDay, bikeAvailability, bikeType, maxDistance, motorStrength); 
       bikes.add(newEBike);
         break;
        case "road":
          Bike newRoadBike = new Bike(pricerPerDay, bikeAvailability, bikeType);     
          bikes.add(newRoadBike);
          break;
        case "mountain":
          Bike newMountainBike = new Bike(pricerPerDay, bikeAvailability, bikeType);     
          bikes.add(newMountainBike);
          break;
        case "bmx": 
          Bike newBmxBike = new Bike(pricerPerDay, bikeAvailability, bikeType);     
          bikes.add(newBmxBike);
        break;
        case "city":
          Bike newCityBike = new Bike(pricerPerDay, bikeAvailability, bikeType);     
          bikes.add(newCityBike);
          break;
 default:
          System.out.println("Please choose one of the above options");
        }
        
    
}


//option 3
 public void listAllCustomers() {
      for (Customer c:customers) {
      System.out.println(c);
    }
}
 
 
//option 4 
  public Customer searchCustomerById() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("What is the customer's id? ");
    int custId = userInput.nextInt();
    for (Customer c:customers) {
      if (c.getCustId() == custId)
          System.out.println(c);
//      return c;
//      
//     else
//      System.out.println("Invalid Customer Id ");
    }
    return null;
  }


//option 5  
public void addCustomer() {
    Scanner userInput = new Scanner(System.in);
    System.out.print("What is the Customer's name? ");
    String custName = userInput.nextLine();     
    System.out.print("What is the Customer's Phone Number? ");
    int custNumber = userInput.nextInt();
    
    Customer newCustomer = new Customer(custName, custNumber);        
     
    customers.add(newCustomer);
}


//option 6
 public void listRents() {
      for (Rent r:rents) {
      System.out.println(r);
    }
  }
 
 
 //option 7
   public void addRent() {
    Scanner userInput = new Scanner(System.in);
    int bikeId = 0;   
    
    System.out.print("What bike type is being rented? (road/mountain/bmx/city/ebike): ");
    String bikeType = userInput.nextLine();  
    
    boolean match = false;
     while(true) {
    
    if ("ebike".equals(bikeType))
        System.out.print("What motor strength? (full power or power assist): ");
        String motorStrength = userInput.nextLine();  
        for (Bike b:bikes){
            if (b.getMotorStrength() == motorStrength)
                System.out.println(b);
                System.out.print("What is the id of the bike you would like? ");
                bikeId = userInput.nextInt(); 
     
                if (b.getBikeId()== bikeId && b.getBikeAvailability() ){
                    b.setBikeAvailability(false);
                    match = true;
                   break;
                }     
        }

    for (Bike b:bikes) {
      if (b.getBikeType().equals(bikeType) )
          System.out.println(b);
      displayAllAvailableBikes();
          System.out.print("What is the id of the bike you would like? ");
          bikeId = userInput.nextInt(); 
           if (b.getBikeId()== bikeId ){
                    b.setBikeAvailability(false);
                    match = true;
                   break;
                }   
    }
     if (match)
          break;
          System.out.println("Did not find a match.");
        
    }
   // displayAllAvailableBikes();
    
    
    System.out.print("What is your customer id? ");
    int custId = userInput.nextInt();
    System.out.print("What is the duration of the rent (max 30 days)? ");
    int bikeRentDuration = userInput.nextInt();
    
    LocalDate rentStartDate = LocalDate.now();
    
     Rent newRent = new Rent(bikeId, custId, bikeRentDuration, rentStartDate);  
     
     
     //makes rented bike not availabile
     //therefore they won't appear under "available bikes" for new rents
    // for (Bike b: bikes){
  //       if (b.getBikeAvailability())
   //      b.setBikeAvailability(false);    
   //  }
     
    //bike id calculations
    //for (int i = 0; i < bikes.size(); i++) {
    //  Bike r = bikes.get(i);
     // if (r.getBikeId() == bikeId){
 
    //  }
   // }
    
    //   for (int i = 0; i < rents.size(); i++) {
    //  Rent r = rents.get(i);
    //  if (r.getRentId() == bikeId){
     //   rents.add(r);
    //  }
   // }

     
    rents.add(newRent);
 
   }
 
  //option 8 
  public void ReturnBike(){
      Scanner userInput = new Scanner(System.in);
      
      System.out.println("Customer ID? ");
      int custId = userInput.nextInt();
      

        Rent r = searchCustomerByIdForRent(custId);      
        int bikeId = r.getBikeId();
        rents.remove(r);
              
    
        //sets bike to available
        Bike b = searchBikeByBikeId(bikeId);
     //   b.setBikeAvailability(true);   
        
        System.out.print("Bike " + bikeId + " Is now removed ");
      
 
  }  
 

//option 9
  public void displayOverdueRents(){
    
    for (Rent r: rents) {
     int bikeDuration = r.getBikeRentDuration();
     LocalDate rentDate = r.getRentStartDate();
     
     LocalDate currentDate = LocalDate.now();
    
     long noOfDatsBetween = ChronoUnit.DAYS.between(rentDate, currentDate);
   
     if (noOfDatsBetween > bikeDuration)
         System.out.print(r);
     
  }
  }
    
    
 //option 10  
 public void saveAllData() {
     
     /////////////////////////////////////////////bikes
    try {
      fos = new FileOutputStream("bikes.dat");
      oos = new ObjectOutputStream(fos);
      for (Bike b:bikes) {
        oos.writeObject(b);
      }
      fos.close();
      oos.close();
      
    } 
    
    catch (Exception e) {
      e.printStackTrace();
    }
    
    /////////////////////////////////////////////customers
     try {
      fos = new FileOutputStream("customers.dat");
      oos = new ObjectOutputStream(fos);
      for (Customer c:customers) {
        oos.writeObject(c);
      }
      fos.close();
      oos.close();
      
    } 
    
    catch (Exception e) {
      e.printStackTrace();
    }
     
     /////////////////////////////////////////////rents
      try {
      fos = new FileOutputStream("rents.dat");
      oos = new ObjectOutputStream(fos);
      for (Rent r:rents) {
        oos.writeObject(r);
      }
      fos.close();
      oos.close();
      
    } 
    
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
 //option 11
  public void readAllData() {
   bikes.clear();
   customers.clear();
   rents.clear();
   
   /////////////////////////////////////////////bikes
    try {
      fis = new FileInputStream("bikes.dat");
      ois = new ObjectInputStream(fis);
      
      while (true) {
        try {
        Object obj = ois.readObject();
        //cast to Bike
        Bike b = (Bike)obj;
         //add to list
        bikes.add(b);
          
        } catch (EOFException eof) {
          fis.close();
          ois.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  
    /////////////////////////////////////////////customers
    try {
      fis = new FileInputStream("customers.dat");
      ois = new ObjectInputStream(fis);
      
      while (true) {
        try {
        Object obj = ois.readObject();
        //cast to Customer
        Customer c = (Customer)obj;
         //add to list
        customers.add(c);
          
        } catch (EOFException eof) {
          fis.close();
          ois.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    ///////////////////////////////////////////rents
    try {
      fis = new FileInputStream("rents.dat");
      ois = new ObjectInputStream(fis);
      
      while (true) {
        try {
        Object obj = ois.readObject();
        //cast to Bike
        Rent r = (Rent)obj;
         //add to list
        rents.add(r);
          
        } catch (EOFException eof) {
          fis.close();
          ois.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  


//calculations 
public Rent searchCustomerByIdForRent(int custId) {
    for (Rent r:rents) {
      if (r.getCustId() == custId)
      return r;
    }
    return null;
  }  

public Bike searchBikeByBikeId(int bikeId) {
    for (Bike b:bikes) {
      if (b.getBikeId() == bikeId)
      return b;
    }
    return null;
  }  
  
  
//end  
}
