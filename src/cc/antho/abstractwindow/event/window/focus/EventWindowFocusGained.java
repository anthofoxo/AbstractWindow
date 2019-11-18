package cc.antho.abstractwindow.event.window.focus;

import cc.antho.abstractwindow.Window;

public class EventWindowFocusGained extends EventWindowFocus {

	public EventWindowFocusGained(Window window) {

		super(window, true);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
