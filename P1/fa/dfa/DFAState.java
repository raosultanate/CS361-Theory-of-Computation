package fa.dfa;

import java.util.HashMap;

public class DFAState extends fa.State {

    // HashMap will hold all the transitions
    private HashMap<Character, DFAState> transitions;


    // Each DFAState will keep track of the next DFAState with the help of the character (as key) in its hashMap.
    public DFAState(String name) {
        //name variable was present in the fa.State.
        this.name = name;
        // initializing the dataStructure to hold all the transitions
        transitions = new HashMap<Character, DFAState>();
    }

    // record data about Cuttent State to the certain state using a
    // character/Symbol.
    public void toNextState(char character, DFAState state) {
        // officially adding the state to the hashMap,
        // each DFA state keeps track of the next state using the character.
        transitions.put(character, state);
    }

    // Returns the next state if the mapping is present to that state in the HashMap. If
    // not than returns a null.
    public DFAState getNextState(char character) {
        return transitions.get(character);
    }

}
