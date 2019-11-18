package cc.antho.abstractwindow.event.window.input.keyboard.key;

import static org.lwjgl.glfw.GLFW.*;

import cc.antho.abstractwindow.Window;

public class EventWindowKeyboardKeyPressed extends EventWindowKeyboardKey {

	public EventWindowKeyboardKeyPressed(Window window, int key, int scancode, int mods) {

		super(window, key, scancode, GLFW_PRESS, mods);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + key + ", " + scancode + ", " + mods + ")";

	}

}
