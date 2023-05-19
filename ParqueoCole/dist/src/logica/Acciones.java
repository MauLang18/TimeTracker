/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author maula
 */
public class Acciones {

    public int x;
    public int y;

    public Acciones(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void actualizar(int x, int y) {
        int i = 0;

        do {
            if (x == 4 && y == 4) {
                System.out.println("a");
            }
            i++;
        } while (i == 1);
    }
}
