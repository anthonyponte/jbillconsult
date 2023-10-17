package com.anthonyponte.jbillconsult.filter;

import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LetterNumberFilter extends DocumentFilter {
  private final Pattern regexCheck = Pattern.compile("[a-zA-Z0-9 ]+");

  @Override
  public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
      throws BadLocationException {
    if (regexCheck.matcher(string).matches()) super.insertString(fb, offset, string, attr);
  }

  @Override
  public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
      throws BadLocationException {
    if (regexCheck.matcher(text).matches()) super.replace(fb, offset, length, text, attrs);
  }
}
