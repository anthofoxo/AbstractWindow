package cc.antho.abstractwindow.event.window.focus;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.EventWindow;

public abstract class EventWindowFocus extends EventWindow {

	public final boolean focused;

	public EventWindowFocus(Window window, boolean focused) {

		super(window);
		this.focused = focused;

	}

}
