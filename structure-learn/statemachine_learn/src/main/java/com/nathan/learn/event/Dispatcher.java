package com.nathan.learn.event;



/**
 * Event Dispatcher interface. It dispatches events to registered
 * event handlers based on event types.
 */
public interface Dispatcher {

    EventHandler<Event> getEventHandler();

    void register(Class<? extends Enum> eventType, EventHandler handler);

}

