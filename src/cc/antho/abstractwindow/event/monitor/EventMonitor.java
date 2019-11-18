package cc.antho.abstractwindow.event.monitor;

import cc.antho.eventsystem.Event;

public abstract class EventMonitor extends Event {

	public final long monitor;
	public final boolean connected;

	public EventMonitor(long monitor, boolean connected) {

		this.monitor = monitor;
		this.connected = connected;

	}

}
