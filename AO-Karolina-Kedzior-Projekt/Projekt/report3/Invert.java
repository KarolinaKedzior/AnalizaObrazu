/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kimage.sample.report3;

import kimage.image.Image;
import kimage.plugin.Plugin;

/**
 *
 * @author Gronka
 */
public class Invert extends Plugin{
    
     public void process(Image imgIn, Image imgOut) {
        for(int i = 0; i < imgIn.getWidth(); i++){
            for(int j = 0; j < imgIn.getHeight(); j++){
                int k = imgIn.getRed(i, j);
                if(k == 255){
                    imgIn.setRGB(i, j, 0, 0, 0);
                }
                else{
                    imgIn.setRGB(i, j, 255, 255,255);
                }
                
            }
    }
    }
}
