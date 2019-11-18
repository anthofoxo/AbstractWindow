package cc.antho.abstractwindow.event.window.input.keyboard.key;

import cc.antho.abstractwindow.Window;
import cc.antho.abstractwindow.event.window.input.keyboard.EventWindowKeyboard;

public abstract class EventWindowKeyboardKey extends EventWindowKeyboard {

	public final int key, scancode, action, mods;

	public EventWindowKeyboardKey(Window window, int key, int scancode, int action, int mods) {

		super(window);
		this.key = key;
		this.scancode = scancode;
		this.action = action;
		this.mods = mods;

	}

}
