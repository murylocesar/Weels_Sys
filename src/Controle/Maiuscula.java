/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Murylo César Souza
 */
public class Maiuscula extends PlainDocument {

    private int quantidadeMax;

    public Maiuscula(int maxlen) {

        super();
        if (maxlen <= 0) {
            throw new IllegalArgumentException("especifique a quantidade");
        }

        quantidadeMax = maxlen;

    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

        if (str == null || getLength() == quantidadeMax) {
            return;
        }

        int totalquantia = (getLength() + str.length());
        if (totalquantia <= quantidadeMax) {
            char[] upper = str.toCharArray();
            for (int i = 0; i < upper.length; i++) {
                upper[i] = Character.toUpperCase(upper[i]);
            }
            super.insertString(offset, new String(upper), attr);
        }

    }
}
