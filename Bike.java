
package bikehire;

import java.io.Serializable;

public class Bike implements Serializable{
 
  private double pricePerDay;
  private boolean bikeAvailability = true;
  private String bikeType;
  private int bikeId;
  static int nextID = 100;
  
  //for ebikes
 private double maxDistance;
 private String motorStrength;
  
  public Bike () {
  }
  
  public Bike (double pricePerDay) {
    this.pricePerDay = pricePerDay;
  }
 
  public Bike (double pricePerDay, boolean bikeAvailability) {
    this.pricePerDay = pricePerDay;
    this.bikeAvailability = bikeAvailability;
  }  

  public Bike (double pricePerDay, boolean bikeAvailability, String bikeType) {
    this.pricePerDay = pricePerDay;
    this.bikeAvailability = bikeAvailability;
    this.bikeType = bikeType;
    bikeId = nextID++;
  }    

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean getBikeAvailability() {
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

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getMotorStrength() {
        return motorStrength;
    }

    public void setMotorStrength(String motorStrength) {
        this.motorStrength = motorStrength;
    }

    @Override
    public String toString() {
        return "Bike{" + "pricePerDay=" + pricePerDay + ", bikeAvailability=" + bikeAvailability + ", bikeType=" + bikeType + ", bikeId=" + bikeId + ", maxDistance=" + maxDistance + ", motorStrength=" + motorStrength + '}';
    }

    
    

    
    
    
    

  
 
  
  
}