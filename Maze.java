import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 


/** 
 *  Reads and solves 2D Maze.
 *  @author Sonora Halili & Frankie Fan
 *  @version February 2022
*/
public class Maze implements DisplayableMaze {

  //height of maze
  int height;
  //width of maze
  int width;


  //2D array to store maze contents
  public MazeContents [][] maze;
  //Location where path should start
  MazeLocation startPoint;
  //Location where path should end
  MazeLocation finishPoint;
  
  

  /** @return height of maze grid */
  public int getHeight() {
    return height;
  }

  /** @return width of maze grid */
  public int getWidth() {
    return width;
  }

  
  
  /** @return contents of maze grid at row j, column i */
  public MazeContents getContents(int j, int i) {
    return maze [j][i];      
  }

  /** @return contents of maze grid at given location currentloc */
  public MazeContents getContentsLoc (MazeLocation currentloc){
    //gets row of location
    int j = currentloc.getRow();
    //gets column of location
    int i = currentloc.getCol();
    //returns MazeContent
    return maze [j][i];
  }


  
  /** @return location of maze start point */
  public MazeLocation getStart() {
    return  startPoint;
  }

  /** @return location of maze finish point */
  public MazeLocation getFinish() {
    return  finishPoint;      
  }
  

  /** Sets square at given location to desired type*/
  public void setContents (MazeLocation currentloc, MazeContents desiredType) {
    int j = currentloc.getRow();
    int i = currentloc.getCol();
    //converts square into desired type of MazeContents
    maze [j][i] = desiredType;   
  }



  /** Constructor for maze object 
  *. @param ArrayList source that stores strings from files.
  */
  public Maze( ArrayList<String> source) { 

    //sets height (# of rows) equal to the size of array
    this.height = source.size();
    //sets width (# of columns) equal to the length of each row
    this.width = source.get(0).length();


    //creates instance of 2d array maze with said height and width
    maze = new MazeContents[height][width]; 
    
    //reads through file and converts chars to MazeContents
    for (int j = 0; j < height; j++) {
      for (int i = 0; i < width; i++){
        
        //stores each element of array (by row and column)
        char element = source.get(j).charAt(i);

        if (element == '#') {
          maze [j][i] = MazeContents.WALL;
        
        } else if (element == '.' || element == ' ') {
          maze [j][i] = MazeContents.OPEN;

        } else if (element == 'S') {
          maze [j][i] = MazeContents.OPEN;
          //records S point as startpoint location
          this.startPoint = new MazeLocation(j,i);
          
        } else if (element == 'F') {
          maze [j][i] = MazeContents.FINISH;
          //records F point as finishpoint location
          this.finishPoint = new MazeLocation(j,i);

        } else {
          maze [j][i] = MazeContents.WALL;
        }
      }
    }
  }



  
  /** Solves maze recursively. 
  *. @param Current Location (starts at startpoint) 
  *. @return Boolean (true/false) depending on if maze is solvable. 
  */
  public boolean solver (MazeLocation currentloc) {
    //boolean success = false;
    MazeContents square = getContentsLoc(currentloc);

    //delay display for 10 miliseconds
    try { Thread.sleep(10);	} catch (InterruptedException e) {};
    

    //Stop condition: we're at the finish point
    if (square == MazeContents.FINISH) {
      //adds location to path
      setContents(currentloc, MazeContents.PATH);
      return true;
      //returns false if it hits a wall, dead end, or a visited square
    } else if (square == MazeContents.WALL ||
               square == MazeContents.VISITED ||
               square == MazeContents.DEAD_END) {
      return false;
    }


    //if square is open or path  
    else {
      //mark square as visited
      setContents(currentloc, MazeContents.VISITED);
      //check for solutions in all 4 directions recursively
      if (square == MazeContents.OPEN) {
        if (solver(currentloc.neighbor(MazeDirection.NORTH)) || 
            solver(currentloc.neighbor(MazeDirection.EAST)) || 
            solver(currentloc.neighbor(MazeDirection.WEST)) || 
            solver(currentloc.neighbor(MazeDirection.SOUTH))) {
              //mark square as visited  
              setContents(currentloc, MazeContents.PATH);
              return true;         
        } else {

          //if no solution can be found, mark as dead end  
          setContents(currentloc, MazeContents.DEAD_END);
          return false;
        }   
      }   
    }
    return false;
  } 
    
  
    
  /** Main method to read in files from console
  *. @param String[] args from console 
  *. @return void
  */  
  public static void main (String [] args) throws Exception {
    
    //arraylist to store each line of file in
    ArrayList<String> source = new ArrayList<>(); 

    //if no args provided, default to input redirection
    if (args.length == 0) {
      //get file name from console
      Scanner input = new Scanner(System.in); 
      //read into arraylist
      while (input.hasNextLine()) {
        String text = input.nextLine();
        source.add(text);
        System.out.println(text);
      }
      input.close();

     //if args are provided, read in args and load said file 
    } else {
      //get filename from args
      Scanner input = new Scanner(new File(args[0]));
      //read into arraylist
      while (input.hasNextLine()) {
        //converts each line to string
        String text = input.nextLine();
        source.add(text);
        System.out.println(text);
      }
      input.close();
    } 


    //create instance of maze using the arryalist we just created
    Maze maze = new Maze(source);
    //display maze
    MazeViewer viewer = new MazeViewer(maze);
    //Solve Maze and print out result
    System.out.println("Solution found: " +maze.solver(maze.getStart()));
      
  }
}

  


