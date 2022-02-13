package todolist.fxui;

public class TodoSettings {

	public enum TodoListOrder {
		ADD_ORDER, ADD_ORDER_REVERSED, LEXICOGRAPHIC_ORDER;
	}

	private TodoListOrder todoListOrder = TodoListOrder.ADD_ORDER;

	public TodoSettings() {
	}

	/**
	 * Initialises this TodoSettings from the provided argument
	 * @param target the target TodoSettings
	 */
	public TodoSettings(final TodoSettings todoSettings) {
		todoSettings.copyInto(this);
	}

	/**
	 * Copies all properties in this TodoSettings into target
	 * @param target the target TodoSettings
	 */
	public void copyInto(final TodoSettings target) {
		target.setTodoListOrder(this.getTodoListOrder());
	}

	public TodoListOrder getTodoListOrder() {
		return todoListOrder;
	}

	public void setTodoListOrder(final TodoListOrder todoListOrder) {
		this.todoListOrder = todoListOrder;
	}
}
