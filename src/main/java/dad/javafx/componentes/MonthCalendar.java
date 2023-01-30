package dad.javafx.componentes;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MonthCalendar extends GridPane implements Initializable {

	
	//View
	@FXML
	private GridPane root;

	@FXML
	private Label monthLabel;

	@FXML
	private Label unoLLabel;

	@FXML
	private Label unoMLabel;

	@FXML
	private Label unoXLabel;

	@FXML
	private Label unoJLabel;

	@FXML
	private Label unoVLabel;

	@FXML
	private Label unoSLabel;

	@FXML
	private Label unoDLabel;

	@FXML
	private Label dosLLabel;

	@FXML
	private Label dosMLabel;

	@FXML
	private Label dosXLabel;

	@FXML
	private Label dosJLabel;

	@FXML
	private Label dosVLabel;

	@FXML
	private Label dosSLabel;

	@FXML
	private Label dosDLabel;

	@FXML
	private Label tresLLabel;

	@FXML
	private Label tresMLabel;

	@FXML
	private Label tresXLabel;

	@FXML
	private Label tresJLabel;

	@FXML
	private Label tresVLabel;

	@FXML
	private Label tresSLabel;

	@FXML
	private Label tresDLabel;

	@FXML
	private Label cuatroLLabel;

	@FXML
	private Label cuatroMLabel;

	@FXML
	private Label cuatroXLabel;

	@FXML
	private Label cuatroJLabel;

	@FXML
	private Label cuatroVLabel;

	@FXML
	private Label cuatroSLabel;

	@FXML
	private Label cuatroDLabel;

	@FXML
	private Label cincoLLabel;

	@FXML
	private Label cincoMLabel;

	@FXML
	private Label cincoXLabel;

	@FXML
	private Label cincoJLabel;

	@FXML
	private Label cincoVLabel;

	@FXML
	private Label cincoDLabel;

	@FXML
	private Label cincoSLabel;

	@FXML
	private Label seisLLabel;

	@FXML
	private Label seisMLabel;

	@FXML
	private Label seisXLabel;

	@FXML
	private Label seisJLabel;

	@FXML
	private Label seisVLabel;

	@FXML
	private Label seisSLabel;

	@FXML
	private Label seisDLabel;
	
	//Model
	private IntegerProperty monthProperty = new SimpleIntegerProperty(1);
	private IntegerProperty yearProperty = new SimpleIntegerProperty(0);
	private String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
			"agosto", "septiembre",	"octubre", "noviembre", "diciembre" };

	
	private Label[] lista;

	public MonthCalendar() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MonthCalendarView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		lista = new Label[] { unoLLabel, unoMLabel, unoXLabel, unoJLabel, unoVLabel, unoSLabel, unoDLabel, dosLLabel,
				dosMLabel, dosXLabel, dosJLabel, dosVLabel, dosSLabel, dosDLabel, tresLLabel, tresMLabel, tresXLabel,
				tresJLabel, tresVLabel, tresSLabel, tresDLabel, cuatroLLabel, cuatroMLabel, cuatroXLabel, cuatroJLabel,
				cuatroVLabel, cuatroSLabel, cuatroDLabel, cincoLLabel, cincoMLabel, cincoXLabel, cincoJLabel,
				cincoVLabel, cincoSLabel, cincoDLabel, seisLLabel, seisMLabel, seisXLabel, seisJLabel, seisVLabel,
				seisSLabel, seisDLabel };

		rellenarDias();
		monthProperty.addListener((o, ov, nv) -> rellenarDias());
		yearProperty.addListener((o, ov, nv) -> rellenarDias());

	}

	public void rellenarDias() {
		monthLabel.setText(meses[monthProperty.get() - 1]);
		vaciarLabel();
		LocalDate d = LocalDate.of(yearProperty.get(), monthProperty.get(), 1);
		int start = d.getDayOfWeek().getValue();
		start--;
		int totalDias = YearMonth.of(yearProperty.get(), monthProperty.get()).lengthOfMonth();

		for (int i = 1; i <= totalDias; i++) {
			lista[start].setText("" + i);
			start++;
		}
		LocalDate todayDate = LocalDate.now();
			if (todayDate.getYear() == yearProperty.get() && todayDate.getMonth().getValue() == monthProperty.get()) {
				start = d.getDayOfWeek().getValue();
				lista[start + todayDate.getDayOfMonth() -2].getStyleClass().add("today");
			} else {
				start = d.getDayOfWeek().getValue();
				lista[start + todayDate.getDayOfMonth() - 2].getStyleClass().remove("today");
			}

	}

	private void vaciarLabel() {
		for (int j = 0; j < lista.length; j++) {
			lista[j].setText("");
		}

	}

	public final IntegerProperty monthPropertyProperty() {
		return this.monthProperty;
	}

	public final int getMonthProperty() {
		return this.monthPropertyProperty().get();
	}

	public final void setMonthProperty(final int monthProperty) {
		this.monthPropertyProperty().set(monthProperty);
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
