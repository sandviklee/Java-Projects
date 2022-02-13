package todolist.fxui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import todolist.model.TodoList;
import todolist.model.TodoEntry;

public class TodoFileSupport implements ITodoFileReading {

    public final static String TODO_EXTENSION = "todo";

    private Path getTodoUserFolderPath() {
        return Path.of(System.getProperty("user.home"), "tdt4100", "todo");
    }

    private boolean ensureTodoUserFolder() {
        try {
            Files.createDirectories(getTodoUserFolderPath());
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }


    private Path getTodoListPath(String name) {
        return getTodoUserFolderPath().resolve(name + "." + TODO_EXTENSION);
    }

    public TodoList readTodoList(InputStream input) {
        TodoList todoList = null;
        try (var scanner = new Scanner(input)) {
            todoList = new TodoList();
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine().stripTrailing();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                if (todoList.getName() == null) {
                    todoList.setName(line);
                } else {
                    todoList.addEntry(new TodoEntry(line));
                }
            }
        }
        return todoList;
    }

    public TodoList readTodoList(String name) throws IOException {
        var todoListPath = getTodoListPath(name);
        try (var input = new FileInputStream(todoListPath.toFile())) {
            return readTodoList(input);
        }
    }

    public void writeTodoList(TodoList todoList, OutputStream output) {
        try (var writer = new PrintWriter(output)) {
            writer.println("# name");
            writer.println(todoList.getName());
            writer.println("# entries");
            for (var entry : todoList) {
                writer.println(entry.getText());
            }
        }
    }

    public void writeTodoList(TodoList todoList) throws IOException {
        var todoListPath = getTodoListPath(todoList.getName());
        ensureTodoUserFolder();
        try (var output = new FileOutputStream(todoListPath.toFile())) {
            writeTodoList(todoList, output);
        }
    }
}