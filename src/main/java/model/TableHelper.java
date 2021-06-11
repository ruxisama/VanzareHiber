
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ruxi
 */
public class TableHelper {

    // Returns an observable list of customers
    public static ObservableList<Customer> getCustomerList() {
        Customer c1 = new Customer(1, "Mark", "Pearson", "First Avenue 2", "2MB", "1GB", "1an");
        Customer c2 = new Customer(2, "Tom", "Hoover", "Kings Cross 3", "2MB", "nelimitat", "2ani");
        Customer c3 = new Customer(3, "David", "Mason", "Bond Street 5", "10MB", "nelimitat", "2ani");
        Customer c4 = new Customer(4, "John", "Doe", "Alpha Street 1", "10MB", "nelimitat", "2ani");

        return FXCollections.<Customer>observableArrayList(c1, c2, c3);
    }

    // Returns Customer Id TableColumn
    public static TableColumn<Customer, Integer> getIdColumn() {
        TableColumn<Customer, Integer> idCol = new TableColumn<>("Id");
        PropertyValueFactory<Customer, Integer> idCellValueFactory = new PropertyValueFactory<>("id");
        idCol.setCellValueFactory(idCellValueFactory);
        return idCol;
    }

    // Returns First Name TableColumn
    public static TableColumn<Customer, String> getFirstNameColumn() {
        TableColumn<Customer, String> firstNameCol = new TableColumn<>("First Name");
        PropertyValueFactory<Customer, String> firstNameCellValueFactory = new PropertyValueFactory<>("firstName");
        firstNameCol.setCellValueFactory(firstNameCellValueFactory);
        return firstNameCol;
    }

    // Returns Last Name TableColumn
    public static TableColumn<Customer, String> getLastNameColumn() {
        TableColumn<Customer, String> lastNameCol = new TableColumn<>("Last Name");
        PropertyValueFactory<Customer, String> lastNameCellValueFactory = new PropertyValueFactory<>("lastName");
        lastNameCol.setCellValueFactory(lastNameCellValueFactory);
        return lastNameCol;
    }

    // Returns Address TableColumn 
    public static TableColumn<Customer, String> getAddressColumn() {
        TableColumn<Customer, String> streetCol = new TableColumn<>("Street");
        PropertyValueFactory<Customer, String> streetCellValueFactory = new PropertyValueFactory<>("street");
        streetCol.setCellValueFactory(streetCellValueFactory);
        return streetCol;
    }

    // Returns Product Id TableColumn
    public static TableColumn<Customer, Integer> getIdPColumn() {
        TableColumn<Customer, Integer> idpCol = new TableColumn<>("Idp");
        PropertyValueFactory<Customer, Integer> idpCellValueFactory = new PropertyValueFactory<>("idp");
        idpCol.setCellValueFactory(idpCellValueFactory);
        return idpCol;
    }

    // Returns viteza TableColumn
    public static TableColumn<Customer, String> getVitezaColumn() {
        TableColumn<Customer, String> vitezaCol = new TableColumn<>("Viteza");
        PropertyValueFactory<Customer, String> vitezaCellValueFactory = new PropertyValueFactory<>("viteza");
        vitezaCol.setCellValueFactory(vitezaCellValueFactory);
        return vitezaCol;
    }

    // Returns trafic TableColumn
    public static TableColumn<Customer, String> getTraficColumn() {
        TableColumn<Customer, String> traficCol = new TableColumn<>("Trafic");
        PropertyValueFactory<Customer, String> traficCellValueFactory = new PropertyValueFactory<>("trafic");
        traficCol.setCellValueFactory(traficCellValueFactory);
        return traficCol;
    }

    // Returns durata TableColumn 
    public static TableColumn<Customer, String> getDurataColumn() {
        TableColumn<Customer, String> durataCol = new TableColumn<>("Durata");
        PropertyValueFactory<Customer, String> durataCellValueFactory = new PropertyValueFactory<>("durata");
        durataCol.setCellValueFactory(durataCellValueFactory);
        return durataCol;
    }

}
