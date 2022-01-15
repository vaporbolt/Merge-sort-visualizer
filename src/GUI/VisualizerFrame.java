package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
  ArrayList<InputField> inputs;


  /**
   * private constructor for the Jwindow used by the windowFactory.
   */
  private VisualizerFrame() {
    this.frame = new JFrame();
    this.frame.setLocationByPlatform(true);
    this.exists = true;
    contentPane = frame.getContentPane();
    this.addPaneComponents();
    this.inputs = new ArrayList<InputField>();
    frame.getContentPane().setBackground(Color.magenta);
  }


  /**
   * factory method for creating visualizerWindow objects.
   * 
   * @return a visualizerWindow object built with the factory specs.
   */
  public static VisualizerFrame FrameFactory() {
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
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = gbc.REMAINDER;
    gbc.gridheight = 1;
    // gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.insets = new Insets(0, 20, 0, 0);
    InputField fieldOne = InputField.createInstance();
    gbl.setConstraints(fieldOne.getTextField(), gbc);
    contentPane.add(fieldOne.getTextField());
    
  }
}
