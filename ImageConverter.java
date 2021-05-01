
/**
 * Write a description of ImageConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class ImageConverter {
    public ImageResource makeGray(ImageResource inImage)
    {
        ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel:outImage.pixels())
        {
            Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
            int avg=(inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);

        }
        return outImage;
    }
    public void testGray()
    {
        ImageResource ir=new ImageResource();
        ImageResource gray=makeGray(ir);    
        gray.draw();
        
    }
    public void selectAndConvert()
    {
        DirectoryResource dr=new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource inFile=new ImageResource(f);
            ImageResource gray=makeGray(inFile);
            gray.draw();    
            
        }
    }
    public void doSave()
    {
        DirectoryResource dr=new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource image=new ImageResource(f);
            String name=image.getFileName();
            String newName="copy"+name;
            image.setFileName(newName);
            image.draw();
            image.save();
            
        
        }
    }
    public void saveToGray()
    {
        DirectoryResource dr=new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource img=new ImageResource(f);
            ImageResource gray=makeGray(img);
            //gray.draw();
            String name=img.getFileName();
            String newName="gray-"+name;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
            
            
        
        
        }
    }

}
