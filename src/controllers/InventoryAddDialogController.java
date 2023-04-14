package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sqlData.Product;

public class InventoryAddDialogController implements Initializable {
    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField stockLevelField;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;
    
    
    private Product product;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	
	
	public int getIdFieldValue() {
		return Integer.parseInt(idField.getText());
	}
	
	public String getNameFieldValue() {
	    return nameField.getText();
	}
	
	public double getPriceFieldValue() {
	    return Double.parseDouble(priceField.getText());
	}
	
	public int getStockLevelFieldValue() {
		return Integer.parseInt(stockLevelField.getText());
	}


	private void addProduct() {
		// Retrieve the data from the UI
	    int id = getIdFieldValue();
	    String name = getNameFieldValue();
	    double price = getPriceFieldValue();
	    int stockLevel = getStockLevelFieldValue();
		// Create a new Product object with the data
		Product newProduct = new Product(id, name, price, stockLevel);
	
		// Insert the new product into the database
		DBConnection.connectToDB();
		String sql = "INSERT INTO inventory (productid, product_name, price, stock) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = DBConnection.connection.prepareStatement(sql)) {
		    statement.setInt(1, newProduct.getId());
		    statement.setString(2, newProduct.getName());
		    statement.setDouble(3, newProduct.getPrice());
		    statement.setInt(4, newProduct.getStockLevel());
		    statement.executeUpdate();
		} catch (SQLException ex) {
		    // Handle any SQL exceptions that occur
		    ex.printStackTrace();
		} finally {
		    DBConnection.disconnectToDB();
		}
	
		JOptionPane.showMessageDialog(null, "The product ID: " + newProduct.getId() + " has been added successfully.");
	
		// TODO: Save the new product to the database
	
		// Close the dialog
		closeButtonDialog();
	
	}
	
	
	@FXML
	private void closeButtonDialog() {
	    // Retrieve the stage from the update button
	    Stage stage = (Stage) addButton.getScene().getWindow();
	
	    // Close the stage
	    stage.close();
	}
	
	@FXML
	private void handleAddBtnAction(ActionEvent event) {
	   addProduct();
	}
	
	@FXML
	private void handleCancelBtnAction(ActionEvent event) {
		closeButtonDialog();
	}


}