package cc.antho.abstractwindow.event.window;

import cc.antho.abstractwindow.Window;

public class EventWindowClose extends EventWindow {

	public EventWindowClose(Window window) {

		super(window);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
