package cc.antho.abstractwindow.event.window.input.mouse.enterleave;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.input.mouse.EventWindowMouse;

public abstract class EventWindowMouseEnterLeave extends EventWindowMouse {

	public final boolean entered;

	public EventWindowMouseEnterLeave(Window window, boolean entered) {

		super(window);
		this.entered = entered;

	}

}
