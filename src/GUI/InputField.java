package GUI;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


/**
 * @author Seth Roper
 * @version 1/12/2022
 * 
 * Contains information for an inputfield for users to input integers. integers
 * are limited to 4 digits and only integers are valid inputs.  
 *
 */
public class InputField {
  private static boolean exists = false;
  // filters the Jtext area for correct input.
  private InputFieldDocumentFilter filter;
  // contains the text area the user will type in.
  private JTextPane field;
  // the document this input field contains
  private Document document;

  private AbstractDocument abstractDocument;

  private final String i = "i";

  private InputField()
  {
    // creates a formattedinput field with one column,
    this.field = new JTextPane();
    document = this.field.getDocument();
    this.filter = new InputFieldDocumentFilter();
    this.abstractDocument = (AbstractDocument) this.document;
    this.abstractDocument.setDocumentFilter(filter);
    this.field.setBackground(new Color(199, 238, 255));
  }

  /**
   * Method which creates the InputField object.
   * 
   * @return an inputfield object.
   */
  public static InputField createInstance()
  {
      
      return new InputField();
    }

   
  

  /**
   * @return the text field this input field contains.
   */
  public JTextPane getTextField()
  {
    return this.field;
  }

 

  
}
