/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kimage.sample.report3;

import kimage.sample.masks.SE;
import kimage.image.Image;
import kimage.plugin.Plugin;

/**
 *
 * @author 4Kedzior
 */
public class Dylation2 extends Plugin {
      protected SE se;

    public Dylation2(SE seIn){
        this.se = seIn;
        seIn.println();
    }
    /**
     * 
     * @param i index poczatku macierzy sasiedztwa do przegladniecia
     * @param j
     * @param imgIn obraz przetwarzany
     * @return maksymalna wartosc piksela w sasiedztwie (i,j)
     */
    int findMax(int i, int j, Image imgIn){
        int maxValue = 0;
        for(int a = i, k = 0; a < i + se.getSize(); a++, k++){
            for(int b = j, l = 0; b < j + se.getSize(); b++, l++){ 
                int colour = imgIn.getRed(a, b);
                if(se.valueOf(k, l) == 1){
                    if(colour > maxValue){
                        maxValue = colour;}
                }}
        }
        return maxValue;
    }
    
      @Override
     public void process(Image imgIn, Image imgOut) {  
      /* powiekszienie obrazu o rozmiar maski -1 pikseli dla pozniejszego 
      sprawdzenia  sasiedztwa pikseli orginalnego obrazu*/
      Image img = Resize.Enlarge(se.getSize(), imgIn);

        for(int i = 0; i < imgIn.getWidth(); i++){
            for(int j = 0; j < imgIn.getHeight(); j++) {
                int maxValue = findMax(i,j,img);
                imgOut.setRGB(i, j, maxValue, maxValue, maxValue);}}
      
     }
     
    }
    

