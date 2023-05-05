/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphism;

/**
 *
 * @author BILGIISLEM
 */
public class ConsoleLogger extends BaseLogger {
    public void log(String message) {
        System.out.println("Logged to console : " + message);
    }
}
