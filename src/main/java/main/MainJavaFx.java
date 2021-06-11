package main;

import static antlr.build.ANTLR.root;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Arrays;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Customer;

import model.TableHelper;
import sun.security.tools.keytool.Main;

public class MainJavaFx extends Application {

    private final TextField firstNameField = new TextField();
    private final TextField lastNameField = new TextField();
    private final TextField addressField = new TextField();
    private final TextField vitezaField = new TextField();
    private final TextField traficField = new TextField();
    private final TextField durataField = new TextField();

    TableView<Customer> table = new TableView<>();

   

    public static void main(String[] args) {
        Application.launch(args);
    }

    @SuppressWarnings("unchecked")

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableViewSelectionModel tsm = table.getSelectionModel();
        tsm.setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(TableHelper.getIdColumn(), TableHelper.getFirstNameColumn(),
                TableHelper.getLastNameColumn(), TableHelper.getAddressColumn(),
                TableHelper.getVitezaColumn(), TableHelper.getTraficColumn(), TableHelper.getDurataColumn());

        // Set the column resize policy to constrained resize policy
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Set the Placeholder for an empty table
        table.setPlaceholder(new Label("No visible columns and/or data exist."));

        GridPane gpane = this.getNewCustomerDataPane();
        Button deleteButton = new Button("Delete Selected Rows");
        deleteButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event e) {
                deleteCustomer();
            }

        });

        // Create the VBox
        VBox root = new VBox();
        // Add the GridPane and the Delete Button to the VBox
        root.getChildren().addAll(gpane, deleteButton, table);

        // Set the Padding and Border for the VBox
        root.setSpacing(5);
        // Set the Spacing and Border for the VBox
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Set the Title of the Stage
        primaryStage.setTitle("Adding/Deleting Rows in Internet Table");
        // Display the Stage
        primaryStage.show();
    }

    public GridPane getNewCustomerDataPane() {
        // Create the GridPane
        GridPane pane = new GridPane();

        // Set the hgap and vgap properties
        pane.setHgap(10);
        pane.setVgap(5);

        // Add the TextFields to the Pane
        pane.addRow(0, new Label("First Name:"), firstNameField);
        pane.addRow(1, new Label("Last Name:"), lastNameField);
        pane.addRow(2, new Label("Address:"), addressField);
        pane.addRow(3, new Label("Viteza:"), vitezaField);
        pane.addRow(4, new Label("Trafic:"), traficField);
        pane.addRow(5, new Label("Durata:"), durataField);

        Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent eh) -> {
            addCustomer();
        });

        // Add the Add Button to the GridPane
        pane.add(addButton, 2, 0);

        return pane;
    }

    public void addCustomer() {
        Integer currentId = 0;

        // Get the next ID
        for (Customer c : table.getItems()) {
            if (c.getId() > currentId) {
                currentId = c.getId();
            }
        }

        // Create a new Customer Object
        Customer customer = new Customer(currentId + 1, firstNameField.getText(), lastNameField.getText(), addressField.getText(),
                vitezaField.getText(), traficField.getText(), durataField.getText());

        // Add the new Customer to the table
        table.getItems().add(customer);

        // Clear the Input Fields
        firstNameField.setText(null);
        lastNameField.setText(null);
        addressField.setText(null);
        vitezaField.setText(null);
        traficField.setText(null);
        durataField.setText(null);
    }

    public void deleteCustomer() {
        TableViewSelectionModel tsm = table.getSelectionModel();

        // Check, if any rows are selected
        if (tsm.isEmpty()) {
            System.out.println("Please select a row to delete.");
            return;
        }

        // Get all selected row indices in an array
        ObservableList list = tsm.getSelectedIndices();

        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = (Integer[]) list.toArray(selectedIndices);

        // Sort the array
        Arrays.sort(selectedIndices);

        // Delete rows (last to first)
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            tsm.clearSelection(selectedIndices[i].intValue());
            table.getItems().remove(selectedIndices[i].intValue());
        }
    }

}
