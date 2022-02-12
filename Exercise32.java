/*Tian Xiaoyang
* 26001904581
* face detection and face capture display
*/

import java.awt.*; 
import java.awt.image.*;
import javax.swing.*;
import org.opencv.core.*;
import org.opencv.objdetect.*;
import org.opencv.imgcodecs.*;

public class Exercise32 extends JFrame {
    BufferedImage bimage1;
    BufferedImage bimage[];
    Mat src, part;
    String filename = "imageL3.jpeg";
    String path = "/usr/local/Cellar/opencv/4.5.4_3/share/opencv4/haarcascades/";
    String cascade = "haarcascade_frontalface_alt.xml";
    Rect[] faceArea = null;
    int count = 0;
    double ratio = 0.5;

    public Exercise32() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        setSize(560, 510);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        detect();
        repaint();
    }

    public void paint(Graphics g) {
        if (bimage1 != null) {
            g.drawImage(bimage1, 10, 30, (int)(bimage1.getWidth()*ratio), (int)(bimage1.getHeight()*ratio), this);
        }
        if (faceArea != null) {
            g.setColor(Color.yellow);
            for (Rect rect : faceArea) {
                g.drawRect(rect.x + 10, rect.y + 30, rect.width, rect.height);
            }
            for (int i = 0; i < count; i++) {
                g.drawImage(bimage[i], 10 + 150 * i, 400, 100, 100, this);
            }
        }
    }

    void detect() {
        src = new Mat();
        src = Imgcodecs.imread(filename);
        bimage1 = matToBufferedImage(src);
        faceArea = getArea(cascade);
        if (faceArea != null) {
            count = faceArea.length;
            if (count > 5) {
                count = 5;
            }
            bimage = new BufferedImage[count];
            for (int i = 0; i < count; i++) {
                part = new Mat(src, faceArea[i]);
                bimage[i] = matToBufferedImage(part);
            }
        }
    }

    Rect[] getArea(String str) {
        Rect[] area = null;
        CascadeClassifier faceDetector = new CascadeClassifier(path + str);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(src, faceDetections);
        System.out.println("detected " + faceDetections.toArray().length + " faces using " + str);
        area = faceDetections.toArray();
        return area;
    }

    public static void main(String[] args) {
        new Exercise32();
    }

    public static BufferedImage matToBufferedImage(Mat matrix) {
        int cols = matrix.cols();
        int rows = matrix.rows();
        int elemSize = (int) matrix.elemSize();
        byte[] data = new byte[cols * rows * elemSize];
        int type;
        matrix.get(0, 0, data);
        switch (matrix.channels()) {
            case 1:
                type = BufferedImage.TYPE_BYTE_GRAY;
                break;
            case 3:
                type = BufferedImage.TYPE_3BYTE_BGR;
                byte b;
                for (int i = 0; i < data.length; i = i + 3) {
                    b = data[i];
                    data[i] = data[i + 2];
                    data[i + 2] = b;
                }
                break;
            default:
                return null;
        }
        BufferedImage out = new BufferedImage(cols, rows, type);
        out.getRaster().setDataElements(0, 0, cols, rows, data);
        return out;
    }
}