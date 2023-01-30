package dad.javafx.calendario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dad.javafx.componentes.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class CalendarioController implements Initializable {
	// View
	@FXML
	private GridPane root;

	@FXML
	private Label yearLabel;

	@FXML
	private MonthCalendar eneroMonth;

	@FXML
	private MonthCalendar febreroMonth;

	@FXML
	private MonthCalendar marzoMonth;

	@FXML
	private MonthCalendar abrilMonth;

	@FXML
	private MonthCalendar mayoMonth;

	@FXML
	private MonthCalendar junioMonth;

	@FXML
	private MonthCalendar julioMonth;

	@FXML
	private MonthCalendar agostoMonth;

	@FXML
	private MonthCalendar septiembreMonth;

	@FXML
	private MonthCalendar octubeMonth;

	@FXML
	private MonthCalendar noviembreMonth;

	@FXML
	private MonthCalendar diciembreMonth;
	
	//Model
	private IntegerProperty yearProperty = new SimpleIntegerProperty(LocalDate.now().getYear());

	public CalendarioController() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Calendario.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cargamos css
		root.getStylesheets().add(getClass().getResource("/CSS/Calendario.css").toExternalForm());
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		yearLabel.textProperty().bindBidirectional(yearProperty, new NumberStringConverter("#"));
		
		eneroMonth.setMonthProperty(1);
		febreroMonth.setMonthProperty(2);
		marzoMonth.setMonthProperty(3);
		abrilMonth.setMonthProperty(4);
		mayoMonth.setMonthProperty(5);
		junioMonth.setMonthProperty(6);
		julioMonth.setMonthProperty(7);
		agostoMonth.setMonthProperty(8);
		septiembreMonth.setMonthProperty(9);
		octubeMonth.setMonthProperty(10);
		noviembreMonth.setMonthProperty(11);
		diciembreMonth.setMonthProperty(12);

		eneroMonth.yearPropertyProperty().bind(yearProperty);
		febreroMonth.yearPropertyProperty().bind(yearProperty);
		marzoMonth.yearPropertyProperty().bind(yearProperty);
		abrilMonth.yearPropertyProperty().bind(yearProperty);
		mayoMonth.yearPropertyProperty().bind(yearProperty);
		junioMonth.yearPropertyProperty().bind(yearProperty);
		julioMonth.yearPropertyProperty().bind(yearProperty);
		agostoMonth.yearPropertyProperty().bind(yearProperty);
		septiembreMonth.yearPropertyProperty().bind(yearProperty);
		octubeMonth.yearPropertyProperty().bind(yearProperty);
		noviembreMonth.yearPropertyProperty().bind(yearProperty);
		diciembreMonth.yearPropertyProperty().bind(yearProperty);
				
	}
	
	@FXML
	void onAnteriorButton(ActionEvent event) {
		yearProperty.set(yearProperty.get()-1);
	}
	
	@FXML
	void onPosteriorButton(ActionEvent event) {
		yearProperty.set(yearProperty.get()+1);
	}


	
	public GridPane getRoot() {
		return root;
	}

	public void setRoot(GridPane root) {
		this.root = root;
	}
	
	public final IntegerProperty yearPropertyProperty() {
		return this.yearProperty;
	}

	public final int getYearProperty() {
		return this.yearPropertyProperty().get();
	}

	public final void setYearProperty(final int yearProperty) {
		this.yearPropertyProperty().set(yearProperty);
	}



}
