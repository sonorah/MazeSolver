# Authors 
This assignment was completed by Sonora Halili and Frankie Fan. The work spanned thoughout the week. We weren't able to do in-class code-review, but we talked to a few of our classmates outside of the classroom. 

# Process & Structure 

We tried to follow the recommended progress phases, but essentially got stuck on phase 1 for three days before we realized it was meant to be the foundation for phase 2 and 3. 

* ** Phase 1: Basic Maze Class**

We weren't sure how to hard code the maze while also storing it in a 2D Array. We did try drawing every single square individually, but then realized (after a few too many days) that hard coding it wouldn't be useful later on in the assignment, given that we had to import the maze from a file. For this reason we skipped to step 3, and then back to step2. 

* ** Phase 2: Recursion **

We were clear about the idea of recursion, but we hadn't realized that we could use the enums from MazeDirection in our recursive function, therefore trying to come up with our one coordinates. (It was something like `recursivesolver((x+1),y)`). We ran into a multitude of errors, which we tried to fix for hours. After Monday's class, building the solver was easier. The only thing that we hadn't quite figured out yet was converting each square into a MazeContent Type, which we managed to fix via setter method. Due to another error we faced with our stop condition, we made a new instance of MazeContents named `FINISH`, at which the recursion would stop and return true. 


* ** Phase 2: Recursion **

While we were working on phase two, we placed a temporary file reader that included filename `maze1` in the maze constructor. This gave us a standard maze to work on and check the recursion as it produced errors. Once we got the recursion part figured out, we moved the scanner into the main method of `Maze` class, and created an `if/else` condition that checked for args. In the case of args, they are read by the scanner directrly, otherwise if no args are provided the program defaults to input redirection. A good portion of this phase was inspired by A3 and A4, due to the double-mode nature of the program. 


# Classmates & Office Hours: 

We weren't able to have code review in class due to the snow day on Friday, but we still contacted many of our classmates throughout the weekend and talked about errors we were facing. Here are a few of our notes. 


* **Sophia Dai**: We met with Sophia at the Sunday night TA hours. Upon looking at her code, we were inspired to potentially make modifications in my `MazeContents` class as well. She added a new parameter to her MazeContents constructor that indicated the status of the content. This, of course, could be redundant and easily replacable by a setter method, but it nonetheless inspired us and provided a new perspective. 


* **Kristina Ngema**: We met with Kris at the Monday night TA hours, and she was stuck where we intially were as well. She was unsure on how to hard code her maze and couldn't get past phase 1. We showed her what we did and reccomended the same steps. 


* **TA Hours**: 
We attended TA hours botth on Sunday and Monday night and they were extremely helpful. Amanda recommended that we make a setter method and get rid of all the new instances of MazeContents that we were creating to avoid confusing errors.


* **Office Hours**: 
Finally, Sonora attended office hours on Tuesday morning to get help with our last bug: the program not being able to recognize reaching the finish line, thus marking the maze as unsolvable. The fix was easy and it included getting rid of the infamous `==` sign that indicated the `new MazeLocation getFinish()` equaled the current location. We replaced that by an instance of `MazeContents.FINISH`and got rid of redundant code. 


# Resource Exploration 

Besides advice from TAs, professors, and classmates, we used the following resources to help with our assignment: 


* [This explanation of the Maze Solving Algorithm]([https://www.geeksforgeeks.org/java-program-to-implement-shunting-yard-algorithm/](https://en.wikipedia.org/wiki/Maze-solving_algorithm)) : lines  130 and 173. 
* [Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) : used all throughout the assignment
* [2D Arrays Java]([https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html](https://docs.oracle.com/cd/E19253-01/817-6223/chp-pointers-7/index.html)) : used all throughout the assignment


# Final Reflection 

This time around we exhausted every single one of the resources available to us: class notes, classmates, TA Hours, Office Hours. We needed a little more guidance than usual, but we also learned that sometimes communicating and trying to problem-solve in a group setting lifts a lot of that stress and frustration that we'd otherwise be experiencing alone. It was an extremely satisfying assignment to watch come together, especially when it finally started to find its path to the finish line. We noticed that instructions are getting shorter and shorter after each assignment, leaving lots of space for versatile solutions. Overall, so much learning happened here. 