package cc.antho.abstractwindow.event.window.maximize;

import cc.antho.abstractwindow.Window;

public class EventWindowUnmaximized extends EventWindowMaximize {

	public EventWindowUnmaximized(Window window) {

		super(window, false);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
