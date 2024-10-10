package otus.exceptions;

public class CourseDoesNotExistException extends Exception{
    public CourseDoesNotExistException(String courseName) {
        "Such course does not exist".formatted(courseName);
    }
}
