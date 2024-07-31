// ProxyPatternExample.java

// Step 2: Define Subject Interface

// Create an interface Image with a method display()
interface Image {
    void display();
}

// Step 3: Implement Real Subject Class

// Create a class RealImage that implements Image and loads an image from a remote server
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 4: Implement Proxy Class

// Create a class ProxyImage that implements Image and holds a reference to RealImage
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Step 5: Test the Proxy Implementation

// Test class to demonstrate the use of ProxyImage to load and display images
public class ProxyPatternExample {
    public static void main(String[] args) {
        // Create a ProxyImage instance
        Image image1 = new ProxyImage("image1.jpg");

        // Display the image
        // The image will be loaded from the server and displayed
        System.out.println("First display call:");
        image1.display();

        // Display the image again
        // The image will not be loaded from the server again, but directly displayed from cache
        System.out.println("\nSecond display call:");
        image1.display();
    }
}
