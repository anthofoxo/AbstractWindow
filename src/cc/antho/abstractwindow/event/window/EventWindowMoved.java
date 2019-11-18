package cc.antho.abstractwindow.event.window;

import cc.antho.abstractwindow.Window;

public class EventWindowMoved extends EventWindow {

	public final int x, y;

	public EventWindowMoved(Window window, int x, int y) {

		super(window);
		this.x = x;
		this.y = y;

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + x + ", " + y + ")";

	}

}