/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionHandling;

/**
 *
 * @author BILGIISLEM
 */
public class BalanceInSufficientException extends Exception{
    String message;
    public BalanceInSufficientException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
    
}
