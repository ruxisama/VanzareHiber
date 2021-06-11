package model;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Customer {

    private  String firstName;
    private String lastName ;
    private String  address; ;
    private String viteza; //"2MB, 5MB, 10MB, 20MB, 50MB, 100MB");
    private String trafic;  //"1GB, 5GB, 10GB, 100GB, nelimitat");
    private String durata; // "durata", "1an, 2ani");
    private int id;

    public Customer(int id, String firstName, String lastName, String address, String viteza, String trafic, String durata) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.viteza = viteza;
        this.trafic = trafic;
        this.durata = durata;

    }
    public Customer(String firstName, String lastName, String address, String viteza, String trafic, String durata) {
      
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.viteza = viteza;
        this.trafic = trafic;
        this.durata = durata;

    }

    public int getId() {
        return id;
    }
     public void setId(int id) {
        this.id = id;
    }
    
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getViteza() {
        return viteza;
    }

    public void setViteza(String viteza) {
        this.viteza = viteza;
    }
     public String getTrafic() {
        return trafic;
    }

    public void setTrafic(String trafic) {
        this.trafic = trafic;
    }
 public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty() {
        return errorList;
    }

    /*public boolean isValid() {

        boolean isValid = true;

        if (firstName.get() != null && firstName.get().equals("")) {
            errorList.getValue().add("First name can't be empty!");
            isValid = false;
        }
        if (lastName.get().equals("")) {
            errorList.getValue().add("Last name can't be empty!");
            isValid = false;
        }
        if (address.get().equals("")) {
            errorList.getValue().add("Address can't be empty!");
            isValid = false;
        }

        return isValid;
    }

    public boolean save() {

        if (isValid()) {
            System.out.println("Person with details: \n" + this + "\nsaved!");
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "First name: " + firstName.get() + "\n" + "Last name: " + lastName.get() + "\n" + "Email: " + address.get();
    }*/
}
