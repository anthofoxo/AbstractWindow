package cc.antho.abstractwindow.event.window.input.mouse.enterleave;

import cc.antho.abstractwindow.Window;

public class EventWindowMouseEnterLeaveEntered extends EventWindowMouseEnterLeave {

	public EventWindowMouseEnterLeaveEntered(Window window) {

		super(window, true);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window;

	}

}
