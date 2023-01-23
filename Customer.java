package bikehire;

import java.io.Serializable;


public class Customer implements Serializable {
 
  private String custName;
  private long custNumber;
  private int custId;
  static int nextID = 100;
  
  public Customer () {
  }
  
  public Customer (String custName) {
    this.custName = custName;
  }
  
   public Customer (String custName, long custNumber) {
    this.custName = custName;
    this.custNumber = custNumber;
    custId = nextID++;
  }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public long getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(long custNumber) {
        this.custNumber = custNumber;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "Customer{" + "custName=" + custName + ", custNumber=" + custNumber + ", custId=" + custId + '}';
    }

   

 
  
}