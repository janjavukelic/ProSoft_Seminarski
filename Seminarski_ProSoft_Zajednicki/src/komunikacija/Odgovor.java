/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author janja
 */
public class Odgovor implements Serializable{
    private Object argument;
    private Exception exception;

    public Odgovor() {
    }

    public Odgovor(Object argument, Exception exception) {
        this.argument = argument;
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
    
    
    
}
