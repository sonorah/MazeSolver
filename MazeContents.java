import java.awt.Color;

/**
 *  Maze Contents represents the status of a square in a maze
 *
 *  @author  Nicholas R. Howe
 *  @version CSC 212, October 2021
 */
public enum MazeContents {
  
  WALL (false, Color.black),
  OPEN (true, Color.white),
  FINISH (true, Color.white),
  VISITED (false, new Color(200,255,200)),
  DEAD_END (false, new Color(255,200,200)),
  PATH (true, Color.green.darker());
  

  /** Can we visit this square? */
  public final boolean isExplorable;

  /** @return true when content is explorable */  
  public boolean getExplorability() {
    return (this.isExplorable);
  }
  
  /** How to display the square */
  public final Color color;

  /** Constructor */
  private MazeContents(boolean isExplorable, Color color) {
    this.isExplorable = isExplorable;
    this.color = color;
  }


}
