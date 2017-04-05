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
public class AddToImage extends Plugin{

    Image tmp;
    public AddToImage(Image imgIn){
        this.tmp = imgIn;
    }
    public AddToImage(){}
    
    
    @Override
    public void process(Image imgIn, Image imgOut) {
        
        for(int i = 0; i < imgIn.getWidth(); i++){
            for(int j = 0; j < imgIn.getHeight(); j++){
                int colour1 = imgIn.getRed(i, j);
                int colour2 = tmp.getRed(i, j);
                if( colour2 == 255)
                    imgIn.setRGB(i, j, 255,255, 255);
            }
         }
    }
    
    public void AddColoredPicture(Image imgIn, Image img2){
        for(int i = 0; i < imgIn.getWidth(); i++){
            for(int j = 0; j < imgIn.getHeight(); j++){
                int r = img2.getRed(i, j);
                 int g = img2.getGreen(i, j);
                 int b= img2.getBlue(i, j);
                if( !(r == 255 & g == 255 && b == 255 ) ){
                    imgIn.setRGB(i, j, r, g, b);
                }
                
            }
    }
    
}}
