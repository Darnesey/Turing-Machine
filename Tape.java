
package turingmachine;

import java.util.ArrayList;

/**
 *
 * @author Ryan Darnell
 */
public class Tape {
    
    int head;
    ArrayList<Character> tape = new ArrayList<>();
    
    public Tape(String data) {
        tape.add('B');
        for (int i = 0; i < data.length(); i++) {
            tape.add(data.charAt(i));
        }
        tape.add('U');
        tape.add('U');
        head = 0;
    }
    
    public char read() {
        return tape.get(head);
    }
    
    public void write(char value) {
        tape.remove(head);
        tape.add(head, value);
        //rather than manually enter U's for the whole array...
        if (head == tape.size() - 1)
            tape.add('U');
    }
    
    public void moveRight(boolean right) {
        if (right) {
            head++;
        } else {
            head--;
        }
    }
    
    public String printData() {
        String strip = "";
        for (int i = 0; i < tape.size(); i++) {
            strip += tape.get(i) + " ";
        }
        return strip;
    }
    
    public String printValue() {
        String binary = "";
        for (int i = 0; i < tape.size(); i++) {
            if (tape.get(i) == '1' || tape.get(i) == '0')
                binary += tape.get(i);
        }
        return binary;
    }
}
