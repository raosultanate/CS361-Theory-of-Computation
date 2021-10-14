# Project 1: DFA Machine

* Author: Landon Curtis & Daniel
* Class: CS361 0012
* Semester: Fall 2021

## Overview

This program simulates a Deterministic Finite Autonoma.
It uses a specifically formatted input file to test strings
and determine if they are accepted by the machine.


## Compiling and Using

You will need to compile all java files using javac on each java file.
In each folder, you can use "javac *.java" to compile every java file in that folder.
Once all of the .class files have been created you must run the DFADriver file.
"java fa.dfa.DFADriver $" is how you run the program where the '$' must be replaced
by a specifically formatted test file. The fa.dfa.DFADriver is how it traverses throgh
the folders if ran from the P1 folder. Three tests can be found in the ./tests/
folder so an example to run would be: "java fa.dfa.DFADriver ./tests/p1tc3.txt"

## Discussion

We experienced a few problems while creating this program. The biggest problem we faced was a
.equals method. At many places in our code, we used == to compare
to strings. This caused a large number of bugs that were hard to chase down including states
not matching and transitions not going to the correct states. After debugging for a long time,
we found that the .equals() method is the correct way to compare two strings. Ultimately,
conceptualizing this project was the longest part. After reading through the requirements
and thinking about how to implement them for a couple of weeks. Once we sat down to start 
doing it, we understood the material so much that knowing what to do was not a difficult part.
Just not making mistakes while trying to do it was the difficult part. 

## Testing

This project has built-in testing. In the documentation provided for this project,
it shows the correct outputs to the three test files we were given. When running our program,
one can easily see that all of our outputs match exactly to what is expected.

This can also be tested by creating a new test file. If you design a DFA, and follow the
instructions on how to format the test file, it will show you if certain strings are accepted
or not. You can compare your own results to what the program says.



----------
This README template is using Markdown. To preview your README output, you can copy your file contents to a Markdown editor/previewer such as [https://stackedit.io/editor](https://stackedit.io/editor).