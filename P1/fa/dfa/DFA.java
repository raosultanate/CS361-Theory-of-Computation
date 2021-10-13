package fa.dfa;

import java.util.Set;

import fa.State;
import fa.FAInterface;

import java.util.Set;
import java.util.LinkedHashSet;

public class DFA implements fa.dfa.DFAInterface {

    // Set of Final States. (F)
    private Set<DFAState> finalStateSet;
    // Start state of DFA. (q0)
    // Not a Set because there can be only 1 initial State in a FA.
    private DFAState initialState;
    // Set of Rest of the states (Q)
    private Set<DFAState> stateSet;
    // Set of all the characters. (Sigma)
    private Set<Character> alphabetSet;

    // Constructor for DFA
    public DFA() {
        // There can be more than one final states.
        finalStateSet = new LinkedHashSet<>();
        // There can only be one initial states.
        // However, initlally there will be no state at all when first constructed.
        initialState = null;
        // This list keeps track of all the states.
        stateSet = new LinkedHashSet<>();
        // these are all the input characters.
        alphabetSet = new LinkedHashSet<>();

    }

    @Override
    public void addStartState(String name) {
        // Check if the initial state has already been added to the list of all states.
        // The reason we check to make sure is because there can only be 1 initial state
        // present.
        for (DFAState s : stateSet) {
            if (s.getName() == name) {
                initialState = s;
                return;
            }
        }

        // If initlial state not preseent in the list of state's than this code is run
        // We create a new state and than add it to the list of states.
        initialState = new DFAState(name);
        // finally add it to the list of all the states.
        stateSet.add(initialState);

    }

    @Override
    public void addState(String name) {
        // Create a new state and add it to the set of states.
        DFAState newState = new DFAState(name);
        stateSet.add(newState);

    }

    @Override
    public void addFinalState(String name) {
        // There is no need to check here because we can have multiple final states.
        // Create the new final state here and than add it to the list of all the
        // states.
        DFAState finalState = new DFAState(name);
        // Once created add it to the list of all the states and also add it to the list
        // of final States.
        // Adding to the list of all the states.
        stateSet.add(finalState);
        // Adding to the list of finalState.
        finalStateSet.add(finalState);

    }

    // Returns the state if it exists in the stateSet
    public DFAState get_DFAState(String name) {
        for (DFAState s : stateSet) {
            if (s.getName() == name) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        // Right away add the onSymb to the set of characters
        alphabetSet.add(onSymb);

        // Now we iterate over the set of states to build the hashMap
        // This is equivalent to building transition table.

        for (DFAState s : stateSet) {
            if (s.getName() == fromState) {
                // Set the transition here. From this state to the other state.
                s.toNextState(onSymb, get_DFAState(toState));

            }
        }

    }

    @Override
    public Set<? extends State> getStates() {
        // Return the list of all states as set.
        return stateSet;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        // Return the list of all the final states as set.
        return finalStateSet;
    }

    @Override
    public State getStartState() {
        // return the initial state as a DSAState.
        return initialState;
    }

    @Override
    public Set<Character> getABC() {
        // returns the list of all characters as a set.
        return alphabetSet;
    }

    @Override
    public boolean accepts(String s) {
        // We need to check if the string is accepted or not as completely or rejected.
        // We need a pointer which will start from current state, and will move on from
        // there as we iterate over the string.
        int stringLength = s.length();
        DFAState currentState = initialState;
        boolean stringAccepted = false;

        int i = 0;
        while (i < stringLength) {
            // keeps going to next state as it iterates over the string.
            currentState = getToState(currentState, s.charAt(i));
            i++;
        }
        // check after iteration if currentState is in the set of final state.
        if (finalStateSet.contains(currentState)) {
            stringAccepted = true;
        }

        return stringAccepted;
    }

    @Override
    public DFAState getToState(DFAState from, char onSymb) {
        // Used during transition. If transition exists on that symbol than state is
        // returned else returns null.
        return from.getNextState(onSymb);
    }

    @Override
    public String toString() {
        return null;
    }

}
