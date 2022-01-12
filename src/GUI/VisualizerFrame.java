package GUI;
import javax.swing.*;

/**
 * @author Seth Roper
 * 
 * Encompasses the construction of the JWindow.
 * A VisualizerWindow is a singleton Object (there can only be one Window.)
 *
 */
public class VisualizerFrame {
  
  private JFrame frame;
  static boolean exists = false;
  
  
  /**
   *  private constructor for the Jwindow used by the windowFactory.
   */
  private VisualizerFrame() 
  {
    this.frame = new JFrame();
    this.frame.setLocationByPlatform(true);
    this.exists = true;
    this.frame.setSize(600,600);
    this.frame.setResizable(false);
  }
  
  
  /**
   * factory method for creating visualizerWindow objects.
   * 
   * @return a visualizerWindow object built with the factory specs.
   */
  public static VisualizerFrame FrameFactory()
  {
    if(!exists)
    {
      exists = true;
      return new VisualizerFrame();
    } else 
    {
      throw new IllegalStateException("Window already exists.");
    }
  }
  
  public JFrame getFrame()
  {
    return this.frame;
  }
  
  /**
   * @param visbile
   */
  public void showFrame(boolean visbile)
  {
      this.frame.setVisible(visbile);
  }
  

}
