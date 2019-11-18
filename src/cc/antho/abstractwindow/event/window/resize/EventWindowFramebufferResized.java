package cc.antho.abstractwindow.event.window.resize;

import cc.antho.abstractwindow.Window;

public class EventWindowFramebufferResized extends EventWindowAbstractResize {

	public EventWindowFramebufferResized(Window window, int w, int h) {

		super(window, w, h);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + w + ", " + h + ")";

	}

}
