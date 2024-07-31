/*FactoryMethodPatternExample.java

Step 2: Define Document Classes

Define an interface for different document types*/
interface Document {
    void open();
    void close();
}

// Step 3: Create Concrete Document Classes

// Implement concrete class for WordDocument
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }
}

// Implement concrete class for PdfDocument
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }
}

// Implement concrete class for ExcelDocument
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document.");
    }
}

// Step 4: Implement the Factory Method

// Create an abstract class DocumentFactory with a method createDocument()
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Create concrete factory class for WordDocument
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// Create concrete factory class for PdfDocument
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Create concrete factory class for ExcelDocument
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Step 5: Test the Factory Method Implementation

// Test class to demonstrate the creation of different document types using the factory method
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Create a Word document using the factory method
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        // Create a PDF document using the factory method
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        // Create an Excel document using the factory method
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
