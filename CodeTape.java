/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachine;

/**
 *
 * @author darnesey
 */
public class CodeTape {
    
    /**
     * This class will call different logic states depending on the input
     * These will be in the form of methods that are recursively called
     * The methods will include a caller method that the HumanInput class
     * will call and the caller method will execute the state logic
     */
    
    public CodeTape(){
        //Assume code inserted into machine
    }
    
    public boolean checkMod3(Tape data) {
        //call starting state method
        return mod0(data);
    }
    
        private boolean mod0(Tape data){
            char input = data.read();
            if (input == 'B') {
                data.moveRight(true);
                return mod0(data);
            }else if (input == '0') {
                data.moveRight(true);
                return mod0(data);
            } else if (input == '1') {
                data.moveRight(true);
                return mod1(data);
            } else {
                data.moveRight(false); //move left
                return halt(data, true);
            }
        }

        private boolean mod1(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(true);
                return mod2(data);
            } else if (input == '1') {
                data.moveRight(true);
                return mod0(data);
            } else { //end of data or 'U'
                data.moveRight(false); //move left
                return halt(data, false);
            }
        }

        private boolean mod2(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(true);
                return mod1(data);
            } else if (input == '1') {
                data.moveRight(true);
                return mod2(data);
            } else { //end of data or 'U'
                data.moveRight(false); //move left
                return halt(data, false);
            }
        }

        private boolean halt(Tape data, boolean truth) {
            char input = data.read();
            if (input == 'B') {
                return truth; 
            } else if (input == '0') {
                data.moveRight(false);
                halt(data, truth);
            } else if (input == '1') {
                data.moveRight(false);
                halt(data, truth);
            } else { //end of data or 'U'
                data.moveRight(false); //move left
                halt(data, truth);
            }
            //for recursion bounce back
            return truth;
        }
    
    
    
    //Arithmetic Expressions
    public Tape addition(Tape tape1, Tape tape2) {
        
        //tape1 will be the value that increases.
        
        //tape2 will be the value that decreases.
        tape2.moveRight(true);
        
        //increment tape1 as long as tape two isn't zero
        while(decZ(tape2)) {
           tape1.moveRight(true);
           r(tape1);
           tape2.moveRight(true);
        }
        
        return tape1;
    } 
    //Subtraction
    public Tape subtraction(Tape tape1, Tape tape2) {
        
        //tape1 will be the value that decreases and returns.
        //tape2 will be the value that decreases to zero.
        tape2.moveRight(true);
        
        //increment tape1 as long as tape two isn't zero
        while(decZ(tape2)) {
           tape1.moveRight(true);
           decZ(tape1);
           tape2.moveRight(true);
        }
        
        return tape1;
    }
    
        private void r(Tape data) {
            //move head to the end of the data
            char input = data.read();
            if (input == '0') {
                data.moveRight(true);
                r(data);
            } else if (input == '1') {
                data.moveRight(true);
                r(data);
            } else { //end of data or 'U'
                data.moveRight(false); //move left
                l(data);
            }
        }
        private void l(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.write('1');
                data.moveRight(false);
                t(data);
            } else if (input == '1') {
                data.write('0');
                data.moveRight(false);
                l(data);
            } else { //beginning of data or 'B'
                prependS(data);
            }
        }
        private void t(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(false);
                t(data);
            } else if (input == '1') {
                data.moveRight(false);
                t(data);
            } else { //beginning of data or 'B'
                //halt
            }
        }
        private void prependS(Tape data) {
            char input = data.read();
            if (input == 'B') {
                data.moveRight(true);
                prependS(data);
            } else if (input == '0') {
                data.write('1');
                data.moveRight(true);
                prependR(data);
            }
        }
        private void prependR(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(true);
                prependR(data);
            } else if (input == 'U') {
                data.write('0');
                data.moveRight(false);
                t(data);
            }
        }
    //    Don't need it
    //    private void prependL(Tape data) {
    //        char input = data.read();
    //        if (input == '0') {
    //            data.moveRight(false);
    //            prependL(data);
    //        } else if (input == '1') {
    //            data.moveRight(false);
    //            prependL(data);
    //        } else { //end of data or 'U'
    //            data.moveRight(false); //move left
    //        }
    //    }

        //decrement algorithm
        private boolean decZ(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(true);
                return decZ(data);
            } else if (input == '1') {
                data.moveRight(true);
                return decR(data);
            } else { //end of data or 'U'
                //check for zero
                data.moveRight(false); //move left
                return falseT(data);
            }
        }
        private boolean decR(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(true);
                return decR(data);
            } else if (input == '1') {
                data.moveRight(true);
                return decR(data);
            } else { //end of data or 'U'
                data.moveRight(false); //move left
                return decL(data);
            }
        }
        private boolean decL(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.write('1');
                data.moveRight(false);
                return decL(data);
            } else if (input == '1') {
                data.write('0');
                data.moveRight(false);
                return decT(data);
            }
            return true;
        }
        private boolean decT(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(false);
                return decT(data);
            } else if (input == '1') {
                data.moveRight(false);
                return decT(data);
            } else { //beginning of data or 'B'
                return true;
            }
        }
        private boolean falseT(Tape data) {
            char input = data.read();
            if (input == '0') {
                data.moveRight(false);
                return falseT(data);
            } else { //beginning of data or 'B'
                return false;
            }
        }
    
    
}
