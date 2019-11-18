package cc.antho.abstractwindow.event.joystick;

public class EventJoystickDisconnected extends EventJoystick {

	public EventJoystickDisconnected(int jid) {

		super(jid, false);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + jid;

	}

}
