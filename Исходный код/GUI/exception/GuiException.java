package GUI.exception;

public class GuiException extends Exception {
    public GuiException() {
        super();
    }

    public GuiException(String message) {
        super(message);
    }

    public GuiException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuiException(Throwable cause) {
        super(cause);
    }
}
