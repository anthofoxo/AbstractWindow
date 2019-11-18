package cc.antho.abstractwindow.event.window.input.keyboard;

import cc.antho.abstractwindow.Window;

public class EventWindowKeyboardChar extends EventWindowKeyboard {

	public final int codepoint;

	public EventWindowKeyboardChar(Window window, int codepoint) {

		super(window);
		this.codepoint = codepoint;

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "('" + (char) codepoint + "'(" + codepoint + "))";

	}

}
