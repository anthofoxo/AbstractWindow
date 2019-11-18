package cc.antho.abstractwindow.event.window;

import cc.antho.abstractwindow.Window;

public class EventWindowRefresh extends EventWindow {

	public EventWindowRefresh(Window window) {

		super(window);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
