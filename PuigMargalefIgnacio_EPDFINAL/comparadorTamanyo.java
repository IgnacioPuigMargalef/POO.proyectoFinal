/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import java.util.Comparator;

/**
 *
 * @author nacho
 */
public class comparadorTamanyo implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        autoCaravana a1 = (autoCaravana) o1;
        autoCaravana a2 = (autoCaravana) o2;
        if (a1.getTamanyoEnM2() < a2.getTamanyoEnM2()) {
            return -1;
        } else if (a1.getTamanyoEnM2() == a2.getTamanyoEnM2()) {
            return 0;
        } else {
            return 1;
        }
    }

}
