package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Seth Roper
 * 
 *         Encompasses the construction of the JFrame and contains the associated components. VisualizerFrame is a singleton Object.
 *
 */
public class VisualizerFrame {

  private JFrame frame;
  static boolean exists = false;
  private final int jframeWidth = 500;
  private final int jframeHeight = 500;
  private Container contentPane;
  private ArrayList<InputField> inputFields;
  private final String TimesNewRoman = "TimesNewRoman";
  static final int maxInputs = 8;
  ArrayList<InputField> inputs;


  /**
   * private constructor for the Jwindow used by the windowFactory.
   */
  private VisualizerFrame() {
    this.frame = new JFrame();
    this.frame.setLocationByPlatform(true);
    exists = true;
    this.inputFields = new ArrayList<InputField>();
    contentPane = frame.getContentPane();
    this.addPaneComponents();
    this.inputs = new ArrayList<InputField>();
    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
  }


  /**
   * factory method for creating visualizerWindow objects.
   * 
   * @return a visualizerWindow object built with the factory specs.
   */
  public static VisualizerFrame createInstance() {
    if (!exists) {
      exists = true;
      return new VisualizerFrame();
    } else {
      throw new IllegalStateException("Window already exists.");
    }
  }

  public JFrame getFrame() {
    return this.frame;
  }

  /**
   * @param visbile
   */
  public void showFrame(boolean visible) {
    /**
     * sets the gui to visible for display.
     */
    // frame
    frame.setMaximumSize(new Dimension(400, 1000));
    frame.setSize(this.jframeWidth, this.jframeHeight);
    frame.setVisible(visible);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocation(500, 200);


  }
  
  
  
  /**
   *  Adds all of the components to the visualizer frame content pane. these components include the input fields
   *  and 
   */
  private void addPaneComponents()
  {
    GridBagLayout gbl = new GridBagLayout();
    contentPane.setLayout(gbl);
    GridBagConstraints gbc = new GridBagConstraints();
    // JLabel
    JLabel label = new JLabel("            Enter the numbers to be sorted below.");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = gbc.REMAINDER;
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 0;
    gbc.weighty = 0.3;
    gbc.insets = new Insets(100, 100, 100, 100);
    gbl.setConstraints(label, gbc);
    contentPane.add(label);
    
    // InputFields.
    
    for(int i = 0; i < maxInputs; i++)
    {
      gbc = new GridBagConstraints();
      gbc.gridx = i;
      gbc.gridy = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      gbc.weightx = 0;
      gbc.weighty = 0.3;
      gbc.insets = new Insets(0, 10, 0, 10);
      InputField field = InputField.createInstance();
      JScrollPane inputScroll = field.getScrollPane();
      gbl.setConstraints(inputScroll, gbc);
      contentPane.add(inputScroll);
      this.inputFields.add(field);
    }
    
    // Sort button.
    JButton sortButton = new JButton("Sort");
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 0;
    gbc.weighty = 0.3;
    gbc.insets = new Insets(0, 0 , 0, 0 );
    gbl.setConstraints(sortButton, gbc);
    contentPane.add(sortButton);
    // put actionListener here.
    
  }
  
  /**
   * @param listener the component listener for the inputfield's textfield.
   */
  public void setComponentListener(ComponentListener listener)
  {
    this.frame.addComponentListener(listener);
  }
  
  /**
   * @return default width of jframe
   */
  public int getWidth()
  {
    return this.jframeWidth;
  }
  
  /**
   * @return the  default height of the jframe.
   */
  public int getHeight()
  {
    return this.jframeHeight;
  }

}
