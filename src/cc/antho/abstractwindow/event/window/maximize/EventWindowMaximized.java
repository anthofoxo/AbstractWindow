package cc.antho.abstractwindow.event.window.maximize;

import cc.antho.abstractwindow.Window;

public class EventWindowMaximized extends EventWindowMaximize {

	public EventWindowMaximized(Window window) {

		super(window, true);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
