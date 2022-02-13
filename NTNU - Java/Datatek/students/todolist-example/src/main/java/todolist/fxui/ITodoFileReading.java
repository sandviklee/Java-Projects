package todolist.fxui;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import todolist.model.TodoList;

public interface ITodoFileReading {
	/**
	 * Read a TodoList from a given InputStream.
	 * @param ios The input stream to read from.
	 * @return The TodoList from the InputStream.
	 */
	TodoList readTodoList(InputStream is);
	/**
	 * Read a TodoList with a given name, from a default (implementation-specific) location.
	 * @param name The name of the TodoList
	 * @return The TodoList with the given name from the default location
	 * @throws IOException if the TodoList can't be found.
	 */
	TodoList readTodoList(String name) throws IOException;
	
	/**
	 * Write a TodoList to a given OutputStream
	 * @param todoList The list to write
	 * @param os The stream to write to
	 */
	void writeTodoList(TodoList todoList, OutputStream os);
	/**
	 * Write a TodoList to a file named after the list in a default (implementation specific) location.
	 * @param todoList The list to write
	 * @throws IOException If a file at the proper location can't be written to
	 */
	void writeTodoList(TodoList todoList) throws IOException;
}
