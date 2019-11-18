package cc.antho.abstractwindow.event.window;

import cc.antho.abstractwindow.Window;

public class EventWindowContentScale extends EventWindow {

	public final float x, y;

	public EventWindowContentScale(Window window, float x, float y) {

		super(window);
		this.x = x;
		this.y = y;

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + x + ", " + y + ")";

	}

}
