package cc.antho.abstractwindow.event.window.iconify;

import cc.antho.abstractwindow.Window;

public class EventWindowDeiconified extends EventWindowIconify {

	public EventWindowDeiconified(Window window) {

		super(window, false);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
