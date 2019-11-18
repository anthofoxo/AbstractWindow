package cc.antho.abstractwindow.event.window.input.mouse;

import cc.antho.abstractwindow.Window;

public class EventWindowMouseScrolled extends EventWindowMouse {

	public final float x, y;

	public EventWindowMouseScrolled(Window window, float x, float y) {

		super(window);
		this.x = x;
		this.y = y;

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + x + ", " + y + ")";

	}

}
