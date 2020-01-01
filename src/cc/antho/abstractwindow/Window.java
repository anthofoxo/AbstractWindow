package cc.antho.abstractwindow;

import cc.antho.eventsystem.EventLayer;
import cc.antho.eventsystem.EventListener;

public abstract class Window implements EventListener {

	protected final EventLayer layer;

	public Window(EventLayer layer) {

		this.layer = layer;
		layer.registerEventListener(this);

	}

	public void destroy() {

		layer.deregisterEventListener(this);

	}

	public abstract void swapBuffers();

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract long getHandle();

	public float getAspect() {

		return (float) getWidth() / (float) getHeight();

	}

}
