/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contol;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author maula
 */
public class Teclado implements KeyListener{

    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean mas;
    public boolean menos;
    public boolean seleccionar;
    public boolean a;
    public boolean salir;
    
    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        mas = teclas[KeyEvent.VK_E];
        menos = teclas[KeyEvent.VK_Q];
        a = teclas[KeyEvent.VK_SHIFT];
        salir = teclas[KeyEvent.VK_ESCAPE];
    }
    
    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
    
}
