package todolist.fxui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import todolist.model.TodoEntry;
import todolist.model.TodoList;

public class TodoController {

	private final TodoSettings todoSettings = new TodoSettings();

	public TodoSettings getTodoSettings() {
		return todoSettings;
	}

	private TodoList todoList;

	public void setTodoList(final TodoList todoList) {
		this.todoList = todoList;
		updateTodoListView();
	}

	private final ITodoFileReading fileSupport = new TodoFileSupport();

	@FXML
	private String sampleTodoListResource;

	@FXML
	private Text todoListNameView;

	@FXML
	private ListView<String> todoListEntriesView;

	@FXML
	private TextField todoEntryTextField;

	@FXML
	private TextField fileLocationNameField;

	@FXML
	private Button todoEntryButton;

	@FXML
	private Text statusText;
	private String defaultStatusText;

	@FXML
	void initialize() {
		final var todoList = new TodoList();
		todoList.setName("todo list");
		setTodoList(todoList);
		todoListEntriesView.getSelectionModel().selectedItemProperty().addListener((prop, oldValue, newValue) -> {
			handleTodoListEntriesViewSelectedItemChanged();
		});
		handleTodoListEntriesViewSelectedItemChanged();
		defaultStatusText = statusText.getText();
	}

	private void updateTodoListView() {
		todoListNameView.setText(todoList.getName());
		todoListEntriesView.getItems().setAll(getOrderedTodoListItems());
	}

	protected List<String> getOrderedTodoListItems() {
		final List<String> listItems = new ArrayList<>();
		for (final var entry : todoList) {
			listItems.add(entry.getText());
		}
		switch (todoSettings.getTodoListOrder()) {
		case ADD_ORDER_REVERSED: {
			Collections.reverse(listItems);
			break;
		}
		case LEXICOGRAPHIC_ORDER: {
			Collections.sort(listItems);
			break;
		}
		default:
		}
		return listItems;
	}

	private void handleTodoListEntriesViewSelectedItemChanged() {
		todoEntryTextField.setText(todoListEntriesView.getSelectionModel().getSelectedItem());
	}

	@FXML
	private void handleTodoEntryTextFieldChange(final StringProperty prop, final String oldValue, final String newValue) {
		if (todoList.hasEntry(newValue)) {
			todoEntryButton.setText("Remove");
		} else {
			todoEntryButton.setText("Add");
		}
		todoEntryButton.setDisable(newValue == null || newValue.isBlank());
	}

	private FileChooser fileChooser;

	private String getFileLocationName(final boolean isSave) {
		if (fileChooser == null) {
			fileChooser = new FileChooser();
		}
		final Window window = fileLocationNameField.getScene().getWindow();
		File file = null;
		if (isSave) {
			file = fileChooser.showSaveDialog(window);
		} else {
			file = fileChooser.showOpenDialog(window);
		}
		if (file != null) {
			String name = file.getName();
			final int pos = name.lastIndexOf('.');
			if (pos >= 0) {
				name = name.substring(0, pos);
			}
			if (! name.isBlank()) {
				return file.getParent() + File.separator + name;
			}
		}
		return null;
	}

	@FXML
	private void handleBrowseButtonAction() {
		final String name = getFileLocationName(false);
		if (name != null) {
			fileLocationNameField.setText(name);
		}
	}

	private String ensureFileLocation(final boolean isSave) {
		String name = fileLocationNameField.getText();
		if (name.isBlank()) {
			name = getFileLocationName(false);
			if (name != null) {
				fileLocationNameField.setText(name);
			}
		}
		return name;
	}

	@FXML
	private void handleLoadButtonAction() {
		final String name = ensureFileLocation(false);
		if (! name.isBlank()) {
			try {
				setTodoList(fileSupport.readTodoList(name));
				statusText.setText(defaultStatusText);
			} catch (final IOException e) {
				statusText.setText(e.getMessage());
			}
		}
	}

	@FXML
	private void handleSaveButtonAction() {
		final String name = ensureFileLocation(true);
		if (! name.isBlank()) {
			try {
				todoList.setName(name);
				fileSupport.writeTodoList(todoList);
				todoListNameView.setText(todoList.getName());
				statusText.setText(defaultStatusText);
			} catch (final IOException e) {
				statusText.setText(e.getMessage());
			}
		}
	}

	@FXML
	private void handleTodoEntryButtonAction() {
		final var text = todoEntryTextField.getText();
		final var entry = todoList.findEntry(text);
		if (entry != null) {
			todoList.removeEntry(entry);
		} else {
			todoList.addEntry(new TodoEntry(text));
		}
		todoEntryTextField.clear();
		updateTodoListView();
	}

	private TodoSettingsController settingsController;

	private Scene scene;
	private Parent oldSceneRoot, settingsSceneRoot;

	@FXML
	private void handleSettingsAction() {
		// check if we need to load settings ui from fxml
		if (settingsController == null) {
			final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TodoSettings.fxml"));
			try {
				// load settings ui
				settingsSceneRoot = fxmlLoader.load();
				// remember old ui
				scene = todoListEntriesView.getScene();
				oldSceneRoot = scene.getRoot();
				// get the settings controller, so we can set its todoSettings property
				settingsController = fxmlLoader.getController();
				settingsController.setTodoController(this);
			} catch (final IOException e) {
			}
		}
		if (settingsController != null) {
			todoListEntriesView.getScene().setRoot(settingsSceneRoot);
			settingsController.setTodoSettings(todoSettings);
		}
	}

	void applyTodoSettings(final TodoSettings settings) {
		if (settings != null) {
			settings.copyInto(this.todoSettings);
		}
		scene.setRoot(oldSceneRoot);
		if (settings != null) {
			updateTodoListView();
		}
	}
}
