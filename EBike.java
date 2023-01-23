package bikehire;


public class EBike extends Bike {
 
 private double maxDistance;
 private String motorStrength;
 private int bikeId;
 static int nextID = 100;
 
  
  public EBike () {
  }

  public EBike (double pricePerDay, boolean bikeAvailability) {
      super(pricePerDay, bikeAvailability); 
  }  

  public EBike (double pricePerDay, boolean bikeAvailability, String bikeType) {
      super(pricePerDay, bikeAvailability, bikeType); 
  }  
  
  public EBike (double pricePerDay, boolean bikeAvailability, String bikeType, double maxDistance, String motorStrength) {
      super(pricePerDay, bikeAvailability, bikeType); 
      this.maxDistance = maxDistance;
      this.motorStrength = motorStrength;
      bikeId = nextID++;
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

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    public String toString() {
        return "EBike{" + "maxDistance=" + maxDistance + ", motorStrength=" + motorStrength + ", bikeId=" + bikeId + '}';
    }

    
    


  
}
