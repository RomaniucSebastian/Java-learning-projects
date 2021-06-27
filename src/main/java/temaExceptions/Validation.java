package temaExceptions;

import java.util.logging.Logger;

public class Validation extends Exception {

    public Validation(String msg){
        super(msg);
    }
}