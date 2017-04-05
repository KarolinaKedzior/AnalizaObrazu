/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kimage.sample.report3;

import kimage.sample.masks.SE;
import kimage.image.Image;
import kimage.plugin.Plugin;
import kimage.utils.gui.ImageFrame;


public class Thining extends Plugin{
    private SE se1 ;
    private SE se2 ;     
     int i;
        /**
         * konstruktor inicjalicujacy wartosci masek wewnatrz se1 i se2
         */
     public Thining(int k)
     {
         int tab[][] = { 
             {0,0,0},
             {-1,1,-1},
             {1,1,1}};
        
        int tab2[][] =  { 
             {-1,0,0},
             {1,1,0},
             {-1,1,-1}};
        
        this.i = k;
        this.se1 = new SE(3); 
        this.se1.setMask(tab);
         
        this.se2 = new SE(3); 
        se2.setMask(tab2);
         
     }
     //dokonuje i-krotnego wykonania operacji pocieniania
     public void repeatedProcess(Image imgIn, Image imgOut, int i)
     {
         while( i-- > 0){
             process(imgIn, imgOut);
         }
     }
   /**
     * 
     * @param imgIn przetwarzany obraz
     * @param imgOut 
     * dokonuje operacji HitOrMiss dla kazdego elementu SE osobno czterokrotnie
     *  dla masek obroconych o kolejno 0,90, 180,270 stopni
     */
     public void process(Image imgIn, Image imgOut) {
        int p = i;
         while( p-- > 0){
         
        SubtractHitOrMiss pl = new SubtractHitOrMiss(se1);
        SubtractHitOrMiss pl2 = new SubtractHitOrMiss(se2);
        int d = 4;
       while(--d>0){
        pl.process(imgIn, imgOut);
        this.se1.rotate();
       }
        d=4;
        while(--d > 0){
        pl2.process(imgIn, imgOut);
        this.se2.rotate();
        }
         }
    }

     public static  void  main(String args[])
     {
      Image img = new Image("./res/labirynt.png");
      
      Thining thin = new Thining(1);
      thin.repeatedProcess(img, img,12);
  
      ImageFrame frame3 = new ImageFrame(img);
      frame3.display();
     }
    
}
