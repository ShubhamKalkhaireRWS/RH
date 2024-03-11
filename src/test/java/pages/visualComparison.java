package pages;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class visualComparison {

    public static void main(String[] args) {
        // Paths to the PDF files to be compared
        String pdfFile1 = "path/to/first/file.pdf";
        String pdfFile2 = "path/to/second/file.pdf";

        // Output directory for saving the visual comparison result
        String outputDir = "path/to/output/directory";

        try {
            // Convert PDFs to images
            BufferedImage image1 = convertPDFToImage(pdfFile1);
            BufferedImage image2 = convertPDFToImage(pdfFile2);

            // Compare images
            ImageDiff diff = new ImageDiffer().makeDiff(image1, image2);

            // Save the visual comparison result
            saveDiffImage(diff, outputDir + File.separator + "visual_comparison.png");

            // Display whether the PDFs are visually identical or not
            if (diff.hasDiff()) {
                System.out.println("PDFs are visually different.");
            } else {
                System.out.println("PDFs are visually identical.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage convertPDFToImage(String pdfFilePath) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilePath));
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        // Choose a page index (0-based) to convert
        int pageIndex = 0;
        BufferedImage image = pdfRenderer.renderImage(pageIndex);

        document.close();
        return image;
    }

    private static void saveDiffImage(ImageDiff diff, String outputPath) throws IOException {
        File diffImageFile = new File(outputPath);
        ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
    }
}
