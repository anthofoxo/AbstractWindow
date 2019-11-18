package cc.antho.abstractwindow;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.*;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import cc.antho.abstractwindow.event.EventWindowTrigger;
import cc.antho.abstractwindow.event.joystick.EventJoystickConnected;
import cc.antho.abstractwindow.event.joystick.EventJoystickDisconnected;
import cc.antho.abstractwindow.event.monitor.EventMonitorConnected;
import cc.antho.abstractwindow.event.monitor.EventMonitorDisconnected;
import cc.antho.abstractwindow.event.window.EventWindowClose;
import cc.antho.abstractwindow.event.window.EventWindowContentScale;
import cc.antho.abstractwindow.event.window.EventWindowMoved;
import cc.antho.abstractwindow.event.window.EventWindowRefresh;
import cc.antho.abstractwindow.event.window.focus.EventWindowFocusGained;
import cc.antho.abstractwindow.event.window.focus.EventWindowFocusLost;
import cc.antho.abstractwindow.event.window.iconify.EventWindowDeiconified;
import cc.antho.abstractwindow.event.window.iconify.EventWindowIconified;
import cc.antho.abstractwindow.event.window.input.EventWindowDrop;
import cc.antho.abstractwindow.event.window.input.keyboard.EventWindowKeyboardChar;
import cc.antho.abstractwindow.event.window.input.keyboard.key.EventWindowKeyboardKeyPressed;
import cc.antho.abstractwindow.event.window.input.keyboard.key.EventWindowKeyboardKeyReleased;
import cc.antho.abstractwindow.event.window.input.keyboard.key.EventWindowKeyboardKeyRepeated;
import cc.antho.abstractwindow.event.window.input.mouse.EventWindowMouseMoved;
import cc.antho.abstractwindow.event.window.input.mouse.EventWindowMouseScrolled;
import cc.antho.abstractwindow.event.window.input.mouse.button.EventWindowMouseButtonPressed;
import cc.antho.abstractwindow.event.window.input.mouse.button.EventWindowMouseButtonReleased;
import cc.antho.abstractwindow.event.window.input.mouse.enterleave.EventWindowMouseEnterLeaveEntered;
import cc.antho.abstractwindow.event.window.input.mouse.enterleave.EventWindowMouseEnterLeaveLeft;
import cc.antho.abstractwindow.event.window.maximize.EventWindowMaximized;
import cc.antho.abstractwindow.event.window.maximize.EventWindowUnmaximized;
import cc.antho.abstractwindow.event.window.resize.EventWindowFramebufferResized;
import cc.antho.abstractwindow.event.window.resize.EventWindowResized;
import cc.antho.eventsystem.EventHandler;
import cc.antho.eventsystem.EventLayer;
import lombok.Getter;

public class GlfwWindow extends Window {

	@Getter private long handle;
	private int width, height;

	public GlfwWindow(GLContext context, EventLayer layer, int width, int height, String title) {

		super(layer);

		glfwDefaultWindowHints();
		context.set();

		handle = glfwCreateWindow(width, height, title, 0L, 0L);

		if (handle == 0) throw new RuntimeException("Failed to create window");

		this.width = width;
		this.height = height;

		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(handle, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

		glfwSetWindowPosCallback(handle, (long window, int x, int y) -> {

			layer.dispatch(new EventWindowMoved(this, x, y));

		});

		glfwSetWindowSizeCallback(handle, (long window, int w, int h) -> {

			layer.dispatch(new EventWindowResized(this, w, h));

		});

		glfwSetWindowCloseCallback(handle, (long window) -> {

			layer.dispatch(new EventWindowClose(this));

		});

		glfwSetWindowRefreshCallback(handle, (long window) -> {

			layer.dispatch(new EventWindowRefresh(this));

		});

		glfwSetWindowFocusCallback(handle, (long window, boolean focused) -> {

			if (focused) layer.dispatch(new EventWindowFocusGained(this));
			else layer.dispatch(new EventWindowFocusLost(this));

		});

		glfwSetWindowIconifyCallback(handle, (long window, boolean iconified) -> {

			if (iconified) layer.dispatch(new EventWindowIconified(this));
			else layer.dispatch(new EventWindowDeiconified(this));

		});

		glfwSetWindowMaximizeCallback(handle, (long window, boolean maximized) -> {

			if (maximized) layer.dispatch(new EventWindowMaximized(this));
			else layer.dispatch(new EventWindowUnmaximized(this));

		});

		glfwSetFramebufferSizeCallback(handle, (long window, int w, int h) -> {

			layer.dispatch(new EventWindowFramebufferResized(this, w, h));

			this.width = w;
			this.height = h;

		});

		glfwSetWindowContentScaleCallback(handle, (long window, float x, float y) -> {

			layer.dispatch(new EventWindowContentScale(this, x, y));

		});

		glfwSetKeyCallback(handle, (long window, int key, int scancode, int action, int mods) -> {

			switch (action) {

				case GLFW_PRESS:
					layer.dispatch(new EventWindowKeyboardKeyPressed(this, key, scancode, mods));
					break;
				case GLFW_REPEAT:
					layer.dispatch(new EventWindowKeyboardKeyRepeated(this, key, scancode, mods));
					break;
				case GLFW_RELEASE:
					layer.dispatch(new EventWindowKeyboardKeyReleased(this, key, scancode, mods));
					break;

			}

		});

		glfwSetCharCallback(handle, (long window, int codepoint) -> {

			layer.dispatch(new EventWindowKeyboardChar(this, codepoint));

		});

		glfwSetMouseButtonCallback(handle, (long window, int button, int action, int mods) -> {

			switch (action) {

				case GLFW_PRESS:
					layer.dispatch(new EventWindowMouseButtonPressed(this, button, mods));
					break;
				case GLFW_RELEASE:
					layer.dispatch(new EventWindowMouseButtonReleased(this, button, mods));
					break;

			}

		});

		glfwSetCursorPosCallback(handle, (long window, double x, double y) -> {

			layer.dispatch(new EventWindowMouseMoved(this, (float) x, (float) y));

		});

		glfwSetCursorEnterCallback(handle, (long window, boolean entered) -> {

			if (entered) layer.dispatch(new EventWindowMouseEnterLeaveEntered(this));
			else layer.dispatch(new EventWindowMouseEnterLeaveLeft(this));

		});

		glfwSetScrollCallback(handle, (long window, double x, double y) -> {

			layer.dispatch(new EventWindowMouseScrolled(this, (float) x, (float) y));

		});

		glfwSetDropCallback(handle, (long window, int count, long names) -> {

			String[] array = new String[count];

			for (int i = 0; i < count; i++)
				array[i] = GLFWDropCallback.getName(names, i);

			layer.dispatch(new EventWindowDrop(this, array));

		});

		glfwMakeContextCurrent(handle);
		glfwSwapInterval(1);

	}

	@EventHandler
	private void onEventWindowTrigger(EventWindowTrigger event) {

		try (MemoryStack stack = stackPush()) {

			IntBuffer xi = stack.mallocInt(1);
			IntBuffer yi = stack.mallocInt(1);

			FloatBuffer xf = stack.mallocFloat(1);
			FloatBuffer yf = stack.mallocFloat(1);

			DoubleBuffer xd = stack.mallocDouble(1);
			DoubleBuffer yd = stack.mallocDouble(1);

			glfwGetWindowPos(handle, xi, yi);
			layer.dispatch(new EventWindowMoved(this, xi.get(0), yi.get(0)));

			glfwGetWindowSize(handle, xi, yi);
			layer.dispatch(new EventWindowResized(this, xi.get(0), yi.get(0)));

			if (glfwGetWindowAttrib(handle, GLFW_FOCUSED) == GLFW_TRUE) layer.dispatch(new EventWindowFocusGained(this));
			else layer.dispatch(new EventWindowFocusLost(this));

			if (glfwGetWindowAttrib(handle, GLFW_ICONIFIED) == GLFW_TRUE) layer.dispatch(new EventWindowIconified(this));
			else layer.dispatch(new EventWindowDeiconified(this));

			if (glfwGetWindowAttrib(handle, GLFW_MAXIMIZED) == GLFW_TRUE) layer.dispatch(new EventWindowMaximized(this));
			else layer.dispatch(new EventWindowUnmaximized(this));

			glfwGetFramebufferSize(handle, xi, yi);
			layer.dispatch(new EventWindowFramebufferResized(this, xi.get(0), yi.get(0)));

			glfwGetWindowContentScale(handle, xf, yf);
			layer.dispatch(new EventWindowContentScale(this, xf.get(0), yf.get(0)));

			glfwGetCursorPos(handle, xd, yd);
			layer.dispatch(new EventWindowMouseMoved(this, (float) xd.get(0), (float) yd.get(0)));

			if (glfwGetWindowAttrib(handle, GLFW_HOVERED) == GLFW_TRUE) layer.dispatch(new EventWindowMouseEnterLeaveEntered(this));
			else layer.dispatch(new EventWindowMouseEnterLeaveLeft(this));

		}

	}

	@Override
	public void destroy() {

		glfwFreeCallbacks(handle);
		glfwDestroyWindow(handle);

	}

	@Override
	public void swapBuffers() {

		glfwSwapBuffers(handle);

	}

	public static final void initGlfw(EventLayer layer) {

		GLFWErrorCallback.createPrint(System.err).set();
		if (!glfwInit()) throw new IllegalStateException("Failed to create glfw");

		glfwSetJoystickCallback((int jid, int event) -> {

			switch (event) {

				case GLFW_CONNECTED:
					layer.dispatch(new EventJoystickConnected(jid));
					break;
				case GLFW_DISCONNECTED:
					layer.dispatch(new EventJoystickDisconnected(jid));
					break;
				default:
					throw new UnsupportedOperationException();

			}

		});

		glfwSetMonitorCallback((long monitor, int event) -> {

			switch (event) {

				case GLFW_CONNECTED:
					layer.dispatch(new EventMonitorConnected(monitor));
					break;
				case GLFW_DISCONNECTED:
					layer.dispatch(new EventMonitorDisconnected(monitor));
					break;
				default:
					throw new UnsupportedOperationException();

			}

		});

	}

	public static final void destroyGlfw() {

		glfwSetJoystickCallback(null);
		glfwSetMonitorCallback(null);

		glfwTerminate();
		glfwSetErrorCallback(null).free();

	}

	@Override
	public String toString() {

		return handle + "";

	}

	public static void poll() {

		glfwPollEvents();

	}

	@Override
	public int getWidth() {

		return width;

	}

	@Override
	public int getHeight() {

		return height;

	}

	public void focus() {

		glfwFocusWindow(handle);

	}

	public void focusHack() {

		glfwHideWindow(handle);
		glfwShowWindow(handle);

	}

	public void show() {

		glfwShowWindow(handle);
		focus();

	}

}
