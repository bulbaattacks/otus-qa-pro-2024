package otus.exceptions;

public class DriverNotSupportedException extends Exception{
    public DriverNotSupportedException(String browserName) {
        "Browser %s is not supported".formatted(browserName);
    }
}
