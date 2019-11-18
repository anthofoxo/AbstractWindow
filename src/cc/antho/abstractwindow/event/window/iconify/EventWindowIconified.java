package cc.antho.abstractwindow.event.window.iconify;

import cc.antho.abstractwindow.Window;

public class EventWindowIconified extends EventWindowIconify {

	public EventWindowIconified(Window window) {

		super(window, true);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
