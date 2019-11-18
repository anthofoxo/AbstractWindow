package cc.antho.abstractwindow.event.window.maximize;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.EventWindow;

public abstract class EventWindowMaximize extends EventWindow {

	public final boolean maximized;

	public EventWindowMaximize(Window window, boolean maximized) {

		super(window);
		this.maximized = maximized;

	}

}
