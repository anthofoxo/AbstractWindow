package cc.antho.abstractwindow.event.window.input;

import cc.antho.abstractwindow.Window;

public class EventWindowDrop extends EventWindowInput {

	public final String[] names;

	public EventWindowDrop(Window window, String[] names) {

		super(window);
		this.names = names;

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "[" + String.join(", ", names) + "]";

	}

}
