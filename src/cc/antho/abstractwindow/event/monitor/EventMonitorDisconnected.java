package cc.antho.abstractwindow.event.monitor;

public class EventMonitorDisconnected extends EventMonitor {

	public EventMonitorDisconnected(long monitor) {

		super(monitor, false);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + monitor;

	}

}
