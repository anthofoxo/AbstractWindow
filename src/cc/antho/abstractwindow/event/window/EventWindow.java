package cc.antho.abstractwindow.event.window;

import cc.antho.abstractwindow.Window;
import cc.antho.eventsystem.Event;

public abstract class EventWindow extends Event {

	public final Window window;

	public EventWindow(Window window) {

		this.window = window;

	}

}
