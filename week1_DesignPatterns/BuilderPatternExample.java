// BuilderPatternExample.java

// Step 1: Create a New Java Project
// Create a new Java project named BuilderPatternExample

// Step 2: Define a Product Class

// Define a class Computer with attributes like CPU, RAM, Storage, etc.
class Computer {
    // Attributes
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String powerSupply;
    private String motherboard;

    // Private constructor to take the Builder as a parameter
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.powerSupply = builder.powerSupply;
        this.motherboard = builder.motherboard;
    }

    // Getters for the attributes (optional, for demonstration purposes)
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public String getMotherboard() {
        return motherboard;
    }

    // Step 3: Implement the Builder Class

    // Static nested Builder class inside Computer with methods to set each attribute
    public static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String powerSupply;
        private String motherboard;

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public ComputerBuilder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        // Provide a build() method that returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Step 5: Test the Builder Implementation

// Test class to demonstrate the creation of different configurations of Computer using the Builder pattern
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Create a Computer with specific configurations using the Builder pattern
        Computer gamingPC = new Computer.ComputerBuilder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .build();

        // Display the configurations of the created Computer
        System.out.println("Gaming PC Configurations:");
        System.out.println("CPU: " + gamingPC.getCPU());
        System.out.println("RAM: " + gamingPC.getRAM());
        System.out.println("Storage: " + gamingPC.getStorage());
        System.out.println("GPU: " + gamingPC.getGPU());
        System.out.println("Power Supply: " + gamingPC.getPowerSupply());
        System.out.println("Motherboard: " + gamingPC.getMotherboard());

        // Create another Computer with different configurations using the Builder pattern
        Computer officePC = new Computer.ComputerBuilder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        // Display the configurations of the created Computer
        System.out.println("Office PC Configurations:");
        System.out.println("CPU: " + officePC.getCPU());
        System.out.println("RAM: " + officePC.getRAM());
        System.out.println("Storage: " + officePC.getStorage());
        System.out.println("GPU: " + officePC.getGPU());
        System.out.println("Power Supply: " + officePC.getPowerSupply());
        System.out.println("Motherboard: " + officePC.getMotherboard());
    }
}
