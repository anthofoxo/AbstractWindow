package cc.antho.abstractwindow.event.window.focus;

import cc.antho.abstractwindow.Window;

public class EventWindowFocusLost extends EventWindowFocus {

	public EventWindowFocusLost(Window window) {

		super(window, false);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
