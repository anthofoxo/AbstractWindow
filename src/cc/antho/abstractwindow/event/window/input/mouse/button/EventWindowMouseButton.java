package cc.antho.abstractwindow.event.window.input.mouse.button;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.input.mouse.EventWindowMouse;

public abstract class EventWindowMouseButton extends EventWindowMouse {

	public final int button, action, mods;

	public EventWindowMouseButton(Window window, int button, int action, int mods) {

		super(window);
		this.button = button;
		this.action = action;
		this.mods = mods;

	}

}
