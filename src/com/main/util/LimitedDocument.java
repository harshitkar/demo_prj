package com.main.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitedDocument extends PlainDocument {

    private int maxLength;

    public LimitedDocument(int maxLength) {
        this.maxLength = maxLength;
    }

    // This method is overriden from the super class. It will be called when
    // you are trying to insert text in your text component (by typing
    // or pasting).
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        int currentLength = getLength();
        if( currentLength >= maxLength ) {
            // There's not room for more characters. Return.
            return;
        }
        if( currentLength + str.length() > maxLength ) {
            // All of the characters we are trying to insert will not fit.
            // We must trim the string.
            str = str.substring(0, maxLength - currentLength);
        }
        // Insert the text:
        super.insertString(offs, str, a);
    }
}
