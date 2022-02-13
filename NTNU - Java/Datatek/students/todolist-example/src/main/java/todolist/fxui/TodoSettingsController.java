package todolist.fxui;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class TodoSettingsController {

	private TodoController todoController;

	// limit visibility
	void setTodoController(final TodoController todoController) {
		this.todoController = todoController;
	}

	private TodoSettings todoSettings = new TodoSettings();

	public void setTodoSettings(final TodoSettings todoSettings) {
		this.todoSettings = todoSettings;
		updateView();
	}

	@FXML
	private ChoiceBox<String> listOrderSelector;

	@FXML
	private void initialize() {
		// same order as TodoSettings.ListOrder
		listOrderSelector.getItems().setAll("Add order", "Add order reversed", "Alphabetic");
		updateView();
	}

	private void updateView() {
		listOrderSelector.getSelectionModel().select(todoSettings.getTodoListOrder().ordinal());
	}

	@FXML
	public void handleApplySettings() {
		todoController.applyTodoSettings(todoSettings);
	}

	@FXML
	public void handleCancelSettings() {
		todoController.applyTodoSettings(null);
	}

	@FXML public void handleListOrderSelection() {
		this.todoSettings.setTodoListOrder(TodoSettings.TodoListOrder.values()[listOrderSelector.getSelectionModel().getSelectedIndex()]);
	}
}
