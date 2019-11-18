package cc.antho.abstractwindow.event.window.resize;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.EventWindow;

public abstract class EventWindowAbstractResize extends EventWindow {

	public final int w, h;

	public EventWindowAbstractResize(Window window, int w, int h) {

		super(window);
		this.w = w;
		this.h = h;

	}

}
