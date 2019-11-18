package cc.antho.abstractwindow.event.joystick;

public class EventJoystickConnected extends EventJoystick {

	public EventJoystickConnected(int jid) {

		super(jid, true);

	}

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + jid;

	}

}
