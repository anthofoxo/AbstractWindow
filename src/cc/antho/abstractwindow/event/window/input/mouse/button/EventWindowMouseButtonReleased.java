package cc.antho.abstractwindow.event.window.input.mouse.button;

import cc.antho.abstractwindow.Window;

import static org.lwjgl.glfw.GLFW.*;

public class EventWindowMouseButtonReleased extends EventWindowMouseButton {

	public EventWindowMouseButtonReleased(Window window, int button, int mods) {

		super(window, button, GLFW_RELEASE, mods);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + window + "(" + button + ", " + mods + ")";

	}

}
