package cc.antho.abstractwindow.event.window.input.keyboard.key;

import static org.lwjgl.glfw.GLFW.*;

import cc.antho.abstractwindow.Window;

public class EventWindowKeyboardKeyRepeated extends EventWindowKeyboardKey {

	public EventWindowKeyboardKeyRepeated(Window window, int key, int scancode, int mods) {

		super(window, key, scancode, GLFW_REPEAT, mods);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + key + ", " + scancode + ", " + mods + ")";

	}

}
