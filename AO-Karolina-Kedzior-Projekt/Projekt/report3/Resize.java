/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kimage.sample.report3;

import kimage.image.Image;
import kimage.utils.gui.ImageFrame;

/**
 *
 * @author 4kedzior
 * 
 */
public class Resize {
    /**
     * 
     * @param size szerokosc/wysokosc maski
     * @param imgIn przetwarzany obraz w odcieniach szarosci
     * @return powiekszony obraz imgIn o biala otoczke o szerokosci maski -1
     */
    public static Image Enlarge(int size, Image imgIn)
    {
        Image img = new Image(imgIn.getWidth() + (size-1), imgIn.getHeight()+(size-1));
        for(int i =0; i < img.getWidth(); i++){
            for(int j = 0 ; j < img.getHeight(); j++){   
                img.setRGB(i, j, 255, 255, 255);
            }
        }
        int mask_range = size/2;
        for(int i = mask_range; i < imgIn.getWidth()+mask_range; i++){
            for(int j = mask_range ; j < imgIn.getHeight() + mask_range; j++){   
                int c = imgIn.getRed(i-mask_range, j-mask_range);
                img.setRGB(i, j, c,c, c);
            }
        }
        return img;
    }
    /**
     * 
     * @param size
     * @param imgIn
     * @return pomniejszony obraz imgIn w odcieniach szarosci o wartosc szerokosci maski-1
     */
     public static Image Downscale(int size, Image imgIn)
    {
        Image img = new Image(imgIn.getWidth() - (size-1), imgIn.getHeight() - (size-1));
        for(int i =0; i < img.getWidth(); i++){
            for(int j = 0 ; j < img.getHeight(); j++){   
                img.setRGB(i, j, 255, 255, 255);
            }
        }
        int mask_range = size/2;
        for(int i = mask_range; i < imgIn.getWidth()- mask_range; i++){
            for(int j = mask_range ; j < imgIn.getHeight() - mask_range; j++){   
                int c = imgIn.getRed(i, j);
                img.setRGB(i-mask_range, j-mask_range, c,c, c);
            }
        }
        return img;
    }
     
     public static void Fill(Image imgIn,int color){
         for(int i =0; i < imgIn.getWidth(); i++){
            for(int j = 0 ; j < imgIn.getHeight(); j++){   
                imgIn.setRGB(i, j, color, color, color);
            }
        }
     }
    
    public static void main(String arg[])
    {
       Image im = new Image("./res/cross.png");
       
       ImageFrame frame1 = new ImageFrame(im);
       frame1.display();
       im = Resize.Enlarge(100, im);

       ImageFrame frame2 = new ImageFrame(im);
       frame2.display();
    }
    
    
    public void test1(){
      //  AssertionError
        
    }
}
