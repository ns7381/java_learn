package com.nathan.learn.state;

/**
 * Hook for Transition.
 * Post state is decided by Transition hook. Post state must be one of the
 * valid post states registered in StateMachine.
 */
public interface MultipleArcTransition
        <OPERAND, EVENT, STATE extends Enum<STATE>> {

    /**
     * Transition hook.
     *
     * @param operand the entity attached to the FSM, whose internal
     *                state may change.
     * @param event   causal event
     * @return the postState. Post state must be one of the
     * valid post states registered in StateMachine.
     */
    public STATE transition(OPERAND operand, EVENT event);

}
