/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import javax.swing.JOptionPane;

/**
 *
 * @author roshann
 */
public class GuiOutput implements OutputStrategy {

    @Override
    public void outPut(String outPut) {
        JOptionPane.showMessageDialog(null, outPut);
        
    }
    
}
