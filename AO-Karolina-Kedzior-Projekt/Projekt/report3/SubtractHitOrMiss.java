
package kimage.sample.report3;

import kimage.sample.masks.SquareSE;
import kimage.sample.masks.SE;
import kimage.image.Image;
import kimage.plugin.Plugin;
import kimage.utils.gui.ImageFrame;


public class SubtractHitOrMiss extends Plugin{
   //element strukturalny/maska
    private SE se;
    
    public SubtractHitOrMiss(SE se){
        this.se = se;
    }
    
    /**
     * 
     * @param i indeks poczatu macierzy do przegladniecia
     * @param j
     * @param imgIn zbinaryzowany obraz do przetworzenia
     * @return  true jesli wartosci pikseli w sasiedztwie odpowiadaja wartosciom
     * w masce se
     */
    private boolean CheckMask(int i, int j, Image imgIn)
    {
        for(int a = i, k = 0; a < i + se.getSize(); a++, k++){
            for(int b = j, l = 0; b < j + se.getSize(); b++, l++){ 
                int colour = imgIn.getRed(a, b);
                
                if(se.valueOf(k, l) == -1){
                continue;}

                if(colour == 255 && se.valueOf(k, l) == 0 
                        || colour == 0 && se.valueOf(k, l) == 1){
                    return false;}}
        }
        return true;
    }
    
    public void process(Image imgIn, Image imgOut) {
         /* powiekszienie obrazu o rozmiar maski -1 pikseli dla pozniejszego 
      sprawdzenia  sasiedztwa pikseli orginalnego obrazu*/
        Image img = Resize.Enlarge(se.getSize(), imgIn);
        for(int i = 0; i < imgIn.getWidth(); i++){
            for(int j = 0; j < imgIn.getHeight(); j++) {
                
                if(CheckMask(i,j,img)){
                    imgOut.setRGB(i, j, 0, 0, 0);}
                }
                
            }
        }
        
    
    
    public static  void  main(String args[])
     {
      Image img = new Image("./res/cross.png");
         
      SubtractHitOrMiss er = new SubtractHitOrMiss(new SquareSE(3));
      er.process(img, img);
      
     ImageFrame frame3 = new ImageFrame(img);
      frame3.display();
     }
}
