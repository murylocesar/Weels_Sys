package Controle;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Murylo César Souza
 */
public class Numeric extends PlainDocument {

    private int quantidadeMax;

    public Numeric(int maxlen) {

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
            super.insertString(offset, str.replaceAll("[^0-9|.|,]", ""), attr);

            return;
        }
        String nova = str.substring(0, getLength() - quantidadeMax);
        super.insertString(offset, nova, attr);
    }
}
