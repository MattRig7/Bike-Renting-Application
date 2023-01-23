package bikehire;


import java.io.Serializable;
import java.time.LocalDate;

public class Rent implements Serializable {
 
  private String custName;
  private int custNumber;  
  private int custId; 
  
  private int pricePerDay;
  private boolean bikeAvailability;
  private String bikeType;
  private int bikeId;
    
  private int bikeRentDuration;
  private LocalDate rentStartDate;
  
  private int rentId;
  static int nextID = 100;
 

  
  public Rent () {
  }
  
  
   public Rent (int bikeId) {
      this.bikeId = bikeId;
      rentId = nextID++;
  } 
   
    public Rent (int bikeId, int custId) {
      this.bikeId = bikeId;
      this.custId = custId;
      rentId = nextID++;
  } 
    
    public Rent (int bikeId, int custId, int bikeRentDuration) {
      this.bikeId = bikeId;
      this.custId = custId;
      this.bikeRentDuration = bikeRentDuration;
      rentId = nextID++;
  } 
    
    public Rent (int bikeId, int custId, int bikeRentDuration, LocalDate rentStartDate) {
      this.bikeId = bikeId;
      this.custId = custId;
      this.bikeRentDuration = bikeRentDuration;
      this.rentStartDate = rentStartDate;
      rentId = nextID++;
  } 

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(int custNumber) {
        this.custNumber = custNumber;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isBikeAvailability() {
        return bikeAvailability;
    }

    public void setBikeAvailability(boolean bikeAvailability) {
        this.bikeAvailability = bikeAvailability;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public int getBikeRentDuration() {
        return bikeRentDuration;
    }

    public void setBikeRentDuration(int bikeRentDuration) {
        this.bikeRentDuration = bikeRentDuration;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

   

    @Override
    public String toString() {
        return "Rent{" + "custName=" + custName + ", custNumber=" + custNumber + ", custId=" + custId + ", pricePerDay=" + pricePerDay + ", bikeAvailability=" + bikeAvailability + ", bikeType=" + bikeType + ", bikeRentDuration=" + bikeRentDuration + ", rentStartDate=" + rentStartDate + ", rentId=" + rentId + '}';
    }

    
   
}