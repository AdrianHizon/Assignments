To compile all the classes, first place all the class files into the same directory.
Then, enter the directory and copy and paste the following into the command line:
clang++ *.cpp -std=c++11 -o Main

To run the program, place the input file in the same directory as the classes.
Then copy and paste the following into the command line:
Main (fileName) (simulationType)
with fileName being the name of the input file, and simulationType being either 1, 2, or 3 to determine which of the simulations to run.