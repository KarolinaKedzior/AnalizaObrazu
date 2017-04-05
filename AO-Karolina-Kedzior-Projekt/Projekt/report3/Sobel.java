
package kimage.sample.report3;

import kimage.image.Image;
import kimage.plugin.Plugin;
import kimage.sample.masks.SE;
import kimage.utils.gui.ImageFrame;

/**
 * 
 * @author 4Kedzior
 * 
 */
public class Sobel extends Plugin {

    private SE kernel1;
    private SE kernel2;
     int pixelValue(int i, int j,  Image imgIn)
    {
        int value = 0;
        for(int a = i, k = 0; a < i + 3; a++, k++){
            for(int b = j, l = 0; b < j + 3; b++, l++){ 
                int colour = imgIn.getRed(a, b);
                
                value += colour*kernel1.valueOf(k, l);
                value += colour*kernel2.valueOf(k, l);
            }
        }
        return value;
    }
      
    public Sobel(){
        
        int tab[][] = { 
             {-1,0,1},
             {-2,0,2},
             {-1,0,1}};
        
        int tab2[][] =  { 
             {0,2,1},
             {-2,0,2},
             {-1,-2,0}};
        
        this.kernel1 = new SE(3); 
        kernel1.setMask(tab);
         
        this.kernel2 = new SE(3); 
        kernel2.setMask(tab2);
        
    }
    
 
    @Override
    public void process(Image imgIn, Image imgOut) {
      
       Image img;
       Image img2 = imgIn.copy();

       foo(imgIn,imgIn); // poczatkowe krawedzie 1 i 2
       
       int i=3;
       while(i-->0){    
       img = img2.copy();
       this.kernel1.rotate();
       this.kernel2.rotate();
       foo(img,img);
       add(imgIn,img);
       }

       
    }
    void foo(Image imgIn, Image imgOut){
          Image img = Resize.Enlarge(3, imgIn);
        for(int i = 0; i < imgIn.getWidth(); i++){
            for(int j = 0; j < imgIn.getHeight(); j++) {
                 
                int t = pixelValue(i, j ,img);
                if(t < 0){
                    t = 0;
                }
                 if(t > 255){ t = 255;}      
                imgOut.setRGB(i, j, t, t, t);}
            }
    }
    
    private void add(Image originalImage, Image solution){
        
         for(int i = 0; i < originalImage.getWidth(); i++){
            for(int j = 0; j < originalImage.getHeight(); j++){
                int t = originalImage.getRed(i, j) + solution.getRed(i, j);
               if(t < 0){
                    t = 0;
                }
                 if(t > 255){ t = 255;}   
               
                    originalImage.setRGB(i, j, t, t, t);
            }
         }
    
    }
    
   
    
    public static void main(String args[]){
        
        Image img = new Image("./res/in.jpg");
   
        Plugin sobel = new Sobel();
        sobel.process(img, img);
      ImageFrame frame5 = new ImageFrame(img);
      frame5.display();
      
    }
    
    

}
