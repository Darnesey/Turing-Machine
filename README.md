# Turing-Machine

/**
* Conceptualized in Alan Turing's 1936 paper on Computational Numbers, the Turing Machine 
* was designed as a state logic machine that can do any calculation a computer today can. My
* code is designed to emulate the standard process a TM works with a read and write head and 
* tape that holds the data and can be whatever size necessary. I use four symbols in for the 
* machine to read/write: B, 0, 1, and U. The B marks the left-most side of the tape while the 
* U represents the end of the data. After that, the machine simply reads and interprets binary
* numbers for whatever state logic table is used. For the state logic itself, I placed the start
* state inside a public method which will call private methods for states depending on the value 
* the r/w head has read. No values are return to the driver class; simply a boolean value to 
* determine when the process is complete for a specified algorithm.
*/
