package cc.antho.abstractwindow.event.window.iconify;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.EventWindow;

public abstract class EventWindowIconify extends EventWindow {

	public final boolean iconified;

	public EventWindowIconify(Window window, boolean iconified) {

		super(window);
		this.iconified = iconified;

	}

}
