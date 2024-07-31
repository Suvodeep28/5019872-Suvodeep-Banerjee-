// CommandPatternExample.java

// Step 2: Define Command Interface

// Create an interface Command with a method execute()
interface Command {
    void execute();
}

// Step 3: Implement Concrete Commands

// Create a class LightOnCommand that implements Command
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Create a class LightOffCommand that implements Command
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Step 5: Implement Receiver Class

// Create a class Light with methods to turn on and off
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// Step 4: Implement Invoker Class

// Create a class RemoteControl that holds a reference to a Command and a method to execute the command
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Step 6: Test the Command Implementation

// Test class to demonstrate issuing commands using the RemoteControl
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create a Light object
        Light light = new Light();

        // Create command objects for turning the light on and off
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create a RemoteControl object
        RemoteControl remote = new RemoteControl();

        // Test turning the light on
        remote.setCommand(lightOn);
        System.out.println("Pressing button to turn light on:");
        remote.pressButton();

        // Test turning the light off
        remote.setCommand(lightOff);
        System.out.println("Pressing button to turn light off:");
        remote.pressButton();
    }
}
