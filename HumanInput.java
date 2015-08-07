
package turingmachine;

import javax.swing.JOptionPane;

/**
 *
 * @author Ryan Darnell
 */
public class HumanInput {

    
    public static void main(String[] args) {
        
        /**
         * The main method class must simulate the human input to a
         * Turing Machine. The only thing that should occur inside this class
         * is the user input for the value entered,
         * the state logic function to be called,
         * and the value printed back out and its findings.
         */
    
        //insert code tape
        CodeTape run = new CodeTape();
        
        //Check for mod 3
        //insert tape
        JOptionPane.showMessageDialog(null, "Welcome to the Turing Machine Emulator!");
        JOptionPane.showMessageDialog(null, "First Code Tape: \nChecking for numbers divisible by 3");
        
        int mod = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer value to check:"));
        String mod2String = Integer.toBinaryString(mod);
        Tape data = new Tape(mod2String);
        
        //run code and store machine response
        boolean mod3 = run.checkMod3(data);
        
        //check machine's response
        if (mod3)
            JOptionPane.showMessageDialog(null, "Data divisible by 3");
        else
            JOptionPane.showMessageDialog(null, "Data NOT divisible by 3");
        
        //print tape roll
        String roll = data.printData();
        JOptionPane.showMessageDialog(null, "Tape roll: \n" + roll);
        
        //arithmetic Calculations
        JOptionPane.showMessageDialog(null, "Now inserting state logic tape for positive arithmetic expressions... "
                + "\nAddition first");
        
        int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first integer to add:"));
        int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second integer to add:"));
        
        String tapeOne = Integer.toBinaryString(number1);
        String tapeTwo = Integer.toBinaryString(number2);
        
        Tape tape1 = new Tape(tapeOne);
        Tape tape2 = new Tape(tapeTwo);
        
        tape1 = run.addition(tape1, tape2);
        String binary = tape1.printValue();
        int decimal = Integer.parseInt(binary, 2);
        JOptionPane.showMessageDialog(null, "Answer = " + decimal + "\nBinary: " + binary + "\nTape: " + tape1.printData());
        
        JOptionPane.showMessageDialog(null, "Now subtraction...");
        number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the larger integer:"));
        number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second integer to subtract from the larger value:"));
        
        tapeOne = Integer.toBinaryString(number1);
        tapeTwo = Integer.toBinaryString(number2);
        
        tape1 = new Tape(tapeOne);
        tape2 = new Tape(tapeTwo);
        
        tape1 = run.subtraction(tape1, tape2);
        binary = tape1.printValue();
        decimal = Integer.parseInt(binary, 2);
        JOptionPane.showMessageDialog(null, "Answer = " + decimal + "\nBinary: " + binary + "\nTape: " + tape1.printData());
        
        JOptionPane.showMessageDialog(null, "Thank you for trying out the Turing Machine Emulator!" 
                + "\nThere's more to come such as:" 
                + "\n- Signed value arithmetic using two's complementary and Turing-Machine-efficient signed values!"
                + "\n- Decimal Arithmetic!"
                + "\n- Multiplication and Division!"
                + "\n- Indeterminate Turing Machine Calculations!"
                + "\n- All new GUI system for visualization Effects!"
                + "\n\n Stay tuned by keeping up with our latest updates!"
                + "\n\n P.S. Denbigh Starkey, am I doing this right?");
    }
    
    
    
}
