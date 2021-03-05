package com.nathan.learn.state;

public interface StateMachine
        <STATE extends Enum<STATE>,
                EVENTTYPE extends Enum<EVENTTYPE>, EVENT> {
    public STATE getCurrentState();

    public STATE doTransition(EVENTTYPE eventType, EVENT event)
            throws InvalidStateTransitionException;
}