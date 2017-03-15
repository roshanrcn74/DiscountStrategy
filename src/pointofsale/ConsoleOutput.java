/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author roshann
 */
public class ConsoleOutput implements OutputStrategy {

    @Override
    public void outPut(String outPut) {
        System.out.println(outPut);
    }
    
}
