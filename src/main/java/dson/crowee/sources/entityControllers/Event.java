package dson.crowee.sources.entityControllers;

import dson.crowee.obj.objects.Entity;

public class Event {
    private EventCode eventCode;
    private Entity eventEmitter;

    public EventCode getEventCode() {
        return eventCode;
    }

    public void setEventCode(EventCode eventCode) {
        this.eventCode = eventCode;
    }

    public Entity getEventEmitter() {
        return eventEmitter;
    }

    public void setEventEmitter(Entity eventEmitter) {
        this.eventEmitter = eventEmitter;
    }

    public Event(Entity eventEmitter, EventCode eventCode){
        this.eventCode = eventCode;
        this.eventEmitter = eventEmitter;


    }
}
