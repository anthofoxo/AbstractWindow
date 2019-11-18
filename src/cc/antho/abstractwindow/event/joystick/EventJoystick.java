package cc.antho.abstractwindow.event.joystick;

import cc.antho.eventsystem.Event;

public abstract class EventJoystick extends Event {

	public final int jid;
	public final boolean connected;

	public EventJoystick(int jid, boolean connected) {

		this.jid = jid;
		this.connected = connected;

	}

}
