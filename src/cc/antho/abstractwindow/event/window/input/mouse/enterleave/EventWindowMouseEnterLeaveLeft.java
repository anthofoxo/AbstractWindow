package cc.antho.abstractwindow.event.window.input.mouse.enterleave;

import cc.antho.abstractwindow.Window;

public class EventWindowMouseEnterLeaveLeft extends EventWindowMouseEnterLeave {

	public EventWindowMouseEnterLeaveLeft(Window window) {

		super(window, false);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
