package command.main.java;

interface Command {
    void execute();

    void undo();
}

class NoCommand implements Command {
    public void execute() {
        System.out.println("No action assigned.");
    }

    public void undo() {
        System.out.println("No action assigned.");
    }
}

class Light {
    public void on() {
        System.out.println("Light is turned on.");
    }

    public void off() {
        System.out.println("Light is turned off.");
    }
}

class CeilingFan {
    public void on() {
        System.out.println("Ceiling fan is turned on.");
    }

    public void off() {
        System.out.println("Ceiling fan is turned off.");
    }
}

class GarageDoor {
    public void open() {
        System.out.println("Garage door is opened.");
    }

    public void close() {
        System.out.println("Garage door is closed.");
    }
}

class Stereo {
    public void on() {
        System.out.println("Stereo is turned on.");
    }

    public void off() {
        System.out.println("Stereo is turned off.");
    }
}

class Computer {
    public void on() {
        System.out.println("Computer is turned on.");
    }

    public void off() {
        System.out.println("Computer is turned off.");
    }
}

class TV {
    public void on() {
        System.out.println("TV is turned on.");
    }

    public void off() {
        System.out.println("TV is turned off.");
    }
}

class Xbox {
    public void on() {
        System.out.println("Xbox is turned on.");
    }

    public void off() {
        System.out.println("Xbox is turned off.");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

class CeilingFanOnCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.on();
    }

    public void undo() {
        ceilingFan.off();
    }
}

class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.off();
    }

    public void undo() {
        ceilingFan.on();
    }
}

class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.open();
    }

    public void undo() {
        garageDoor.close();
    }
}

class GarageDoorCloseCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.close();
    }

    public void undo() {
        garageDoor.open();
    }
}

class StereoOnCommand implements Command {
    private Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
    }

    public void undo() {
        stereo.off();
    }
}

class StereoOffCommand implements Command {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
    }

    public void undo() {
        stereo.on();
    }
}

class ComputerOnCommand implements Command {
    private Computer computer;

    public ComputerOnCommand(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        computer.on();
    }

    public void undo() {
        computer.off();
    }
}

class ComputerOffCommand implements Command {
    private Computer computer;

    public ComputerOffCommand(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        computer.off();
    }

    public void undo() {
        computer.on();
    }
}

class TVOnCommand implements Command {
    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }

    public void undo() {
        tv.off();
    }
}

class TVOffCommand implements Command {
    private TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }

    public void undo() {
        tv.on();
    }
}

class XboxOnCommand implements Command {
    private Xbox xbox;

    public XboxOnCommand(Xbox xbox) {
        this.xbox = xbox;
    }

    public void execute() {
        xbox.on();
    }

    public void undo() {
        xbox.off();
    }
}

class XboxOffCommand implements Command {
    private Xbox xbox;

    public XboxOffCommand(Xbox xbox) {
        this.xbox = xbox;
    }

    public void execute() {
        xbox.off();
    }

    public void undo() {
        xbox.on();
    }
}

/** Macro commands */
class AllLightsOnCommand implements Command {
    private Light[] lights;

    public AllLightsOnCommand(Light[] lights) {
        this.lights = lights;
    }

    public void execute() {
        System.out.println("Turning on all lights");
        for (Light light : lights) {
            light.on();
        }
    }

    public void undo() {
        for (Light light : lights) {
            light.off();
        }
    }
}

class AllLightsOffCommand implements Command {
    private Light[] lights;

    public AllLightsOffCommand(Light[] lights) {
        this.lights = lights;
    }

    public void execute() {
        for (Light light : lights) {
            light.off();
        }
    }

    public void undo() {
        for (Light light : lights) {
            light.on();
        }
    }
}

/** Macro commands */
class PartyModeOnCommand implements Command {
    private Command[] commands;

    public PartyModeOnCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}

class PartyModeOffCommand implements Command {
    private Command[] commands;

    public PartyModeOffCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command command : commands) {
            command.undo();
        }
    }

    public void undo() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

class RemoteControl {
    public final int COMMANDS_LENGTH = 10;

    Command[] onCommands;
    Command[] offCommands;
    Command prevCommand;

    public RemoteControl() {
        onCommands = new Command[COMMANDS_LENGTH];
        offCommands = new Command[COMMANDS_LENGTH];

        prevCommand = new NoCommand();

        // Initialize with NoCommand initially
        Command noCommand = new NoCommand();
        for (int i = 0; i < COMMANDS_LENGTH; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();

        prevCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();

        prevCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        prevCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuff = new StringBuilder();
        stringBuff.append("\n---- Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot ").append(i).append("] ")
                    .append(onCommands[i].getClass().getName())
                    .append("   ")
                    .append(offCommands[i].getClass().getName())
                    .append("\n");
        }
        return stringBuff.toString();
    }

    public static void main(String[] args) {
        // Create devices
        Light livingRoomLight = new Light();
        Light kitchenLight = new Light();
        Light bedroomLight = new Light();
        CeilingFan livingRoomFan = new CeilingFan();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();
        Computer computer = new Computer();
        TV tv = new TV();
        Xbox xbox = new Xbox();

        // Lights
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        Command bedroomLightOn = new LightOnCommand(bedroomLight);
        Command bedroomLightOff = new LightOffCommand(bedroomLight);

        Command livingRoomFanOn = new CeilingFanOnCommand(livingRoomFan);
        Command livingRoomFanOff = new CeilingFanOffCommand(livingRoomFan);

        Command garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        Command garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        Command stereoOn = new StereoOnCommand(stereo);
        Command stereoOff = new StereoOffCommand(stereo);

        Command computerOn = new ComputerOnCommand(computer);
        Command computerOff = new ComputerOffCommand(computer);

        Command tvOn = new TVOnCommand(tv);
        Command tvOff = new TVOffCommand(tv);

        Command xboxOn = new XboxOnCommand(xbox);
        Command xboxOff = new XboxOffCommand(xbox);

        // Set commands to remote control slots
        RemoteControl remote = new RemoteControl();

        System.out.println(remote);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, bedroomLightOn, bedroomLightOff);

        remote.setCommand(3, livingRoomFanOn, livingRoomFanOff);

        remote.setCommand(4, garageDoorOpen, garageDoorClose);
        remote.setCommand(5, stereoOn, stereoOff);
        remote.setCommand(6, computerOn, computerOff);
        remote.setCommand(7, tvOn, tvOff);
        remote.setCommand(8, xboxOn, xboxOff);

        /** Macro commands */
        Light[] allLights = new Light[] { livingRoomLight, kitchenLight, bedroomLight };
        remote.setCommand(9, new AllLightsOnCommand(allLights), new AllLightsOffCommand(allLights));

        // Push buttons
        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        remote.onButtonWasPushed(1);
        remote.offButtonWasPushed(1);
        remote.onButtonWasPushed(2);
        remote.offButtonWasPushed(2);
        remote.onButtonWasPushed(3);
        remote.offButtonWasPushed(3);
        remote.onButtonWasPushed(4);
        remote.offButtonWasPushed(4);
        remote.onButtonWasPushed(5);
        remote.offButtonWasPushed(5);
        remote.onButtonWasPushed(6);
        remote.offButtonWasPushed(6);

        remote.onButtonWasPushed(9);

        remote.undoButtonWasPushed();

        System.out.println(remote);
    }
}
