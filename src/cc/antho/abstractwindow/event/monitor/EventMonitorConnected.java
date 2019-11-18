package cc.antho.abstractwindow.event.monitor;

public class EventMonitorConnected extends EventMonitor {

	public EventMonitorConnected(long monitor) {

		super(monitor, true);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + monitor;

	}

}
