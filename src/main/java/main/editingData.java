package main;

import static com.sun.xml.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;
import model.TableHelper;

public class editingData extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        TableView<Customer> table = new TableView<>(TableHelper.getCustomerList());
        // Set the column resize policy to constrained resize policy
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Set the Placeholder for an empty table
        table.setPlaceholder(new Label("No visible columns and/or data exist."));
        // Make the TableView editable
        table.setEditable(true);

        // Add columns 
        addIdColumn(table);
        addFirstNameColumn(table);
        addLastNameColumn(table);
        addAddressColumn(table);
        addVitezaColumn(table);
        addTraficColumn(table);
        addDurataColumn(table);

        // Create the HBox
        HBox root = new HBox();
        // Add the Table to the BBox
        root.getChildren().add(table);
        // Set the Padding and Border for the HBox
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.setTitle("Internet Table");

        stage.show();
    }

    public void addIdColumn(TableView<Customer> table) {
        // Id column is non-editable
        table.getColumns().add(TableHelper.getIdColumn());
    }

    public void addFirstNameColumn(TableView<Customer> table) {
        // First Name is a String, editable column
        TableColumn<Customer, String> firstNameCol = TableHelper.getFirstNameColumn();
        // Use a TextFieldTableCell, so it can be edited
        firstNameCol.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());

        // Set editing related event handlers (OnEditCommit)
        firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
            @Override
            public void handle(CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        });

        table.getColumns().add(firstNameCol);
    }

    public void addLastNameColumn(TableView<Customer> table) {
        // Last Name is a String, editable column
        TableColumn<Customer, String> lastNameCol = TableHelper.getLastNameColumn();
        // Use a TextFieldTableCell, so it can be edited
        lastNameCol.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());

        // Set editing related event handlers (OnEditCommit)
        lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
            @Override
            public void handle(CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setLastName(t.getNewValue());
            }
        });

        table.getColumns().add(lastNameCol);
    }

    public void addAddressColumn(TableView<Customer> table) {

        TableColumn<Customer, String> addressCol = TableHelper.getAddressColumn();

        addressCol.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());

        addressCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
            @Override
            public void handle(CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setAddress(t.getNewValue());
            }
        });

        table.getColumns().add(addressCol);
    }

    public void addVitezaColumn(TableView<Customer> table) {

        TableColumn<Customer, String> vitezaCol = TableHelper.getVitezaColumn();

        vitezaCol.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());

        vitezaCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
            @Override
            public void handle(CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setViteza(t.getNewValue());
            }
        });

        table.getColumns().add(vitezaCol);
    }

    public void addTraficColumn(TableView<Customer> table) {

        TableColumn<Customer, String> traficCol = TableHelper.getTraficColumn();

        traficCol.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());

        traficCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
            @Override
            public void handle(CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setTrafic(t.getNewValue());
            }
        });

        table.getColumns().add(traficCol);
    }

    public void addDurataColumn(TableView<Customer> table) {

        TableColumn<Customer, String> durataCol = TableHelper.getDurataColumn();

        durataCol.setCellFactory(TextFieldTableCell.<Customer>forTableColumn());

        durataCol.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
            @Override
            public void handle(CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setDurata(t.getNewValue());
            }
        });

        table.getColumns().add(durataCol);
    }
}
