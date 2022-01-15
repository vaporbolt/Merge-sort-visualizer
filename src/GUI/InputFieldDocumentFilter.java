package GUI;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * document filter for the input field. allows for only numbers of 4 digits to be inputted.
 * 
 * @author Seth Roper
 * @version 1/14/22
 *
 */
public class InputFieldDocumentFilter extends DocumentFilter
{
  
  static final int max_length = 4;
  /**
   * Constructs an InputFiledDocumentFIlter.
   */
  public InputFieldDocumentFilter()
  {
    super();
  }

  @Override
  public void insertString(final DocumentFilter.FilterBypass fb, final int offset,
      final String string, final AttributeSet attr) throws BadLocationException
  {
    if ((fb.getDocument().getLength()) + string.length() <= max_length)
    {
      {
        try {
          Integer.parseInt(string);
        }

        catch (NumberFormatException e) {
          Toolkit.getDefaultToolkit().beep();
          return;
        }
        super.insertString(fb, offset, string, null);
      }


    } else {
      Toolkit.getDefaultToolkit().beep();
      return;
    }
    
  }

  @Override
  public void replace(final DocumentFilter.FilterBypass fb, final int offset, final int length,
      final String string, final AttributeSet attr) throws BadLocationException
  {
    if ((fb.getDocument().getLength()) + string.length() <= max_length)
    {
      {
        try {
          Integer.parseInt(string);
        }

        catch (NumberFormatException e) {
          Toolkit.getDefaultToolkit().beep();
          return;
        }
        super.insertString(fb, offset, string, null);
      }


    } else {
      Toolkit.getDefaultToolkit().beep();
      return;
    }
    
  }

  /**
   * @param string
   *          the string whose valid input will be determined.
   * @return whether the character entered is a valid character of an imaginary number.
   * 
   */
  private boolean isValidInput(final String string)
  {
    
      try
      {
        Integer.parseInt(string);
      }
      catch(NumberFormatException e)
      {
        return false;
    }

    return true;
  }
}
