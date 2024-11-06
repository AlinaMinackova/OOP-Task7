package L7.Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException (String message){
        super(message);
    }
}
