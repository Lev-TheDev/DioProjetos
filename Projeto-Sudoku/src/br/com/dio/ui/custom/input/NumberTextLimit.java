package br.com.dio.ui.custom.input;

import javax.swing.text.PlainDocument;
import java.util.List;

import static java.util.Objects.isNull;

public class NumberTextLimit extends PlainDocument {

    private final List<String> NUMBERS = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {
        if (isNull(str) || (!NUMBERS.contains(str))) return;
        if (getLength() + str.length() <= 1) {
            super.insertString(offs, str, a);
        }
    }
}
