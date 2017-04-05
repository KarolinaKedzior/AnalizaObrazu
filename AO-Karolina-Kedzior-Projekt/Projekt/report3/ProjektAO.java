
package kimage.sample.report3;

import kimage.image.Image;
import kimage.plugin.Plugin;
import kimage.plugins.component.ConnectedComponent;
import kimage.plugins.thresholding.ImagePartByRange;
import kimage.sample.masks.CircularSE;
import kimage.sample.masks.CrossSE;

import kimage.tools.executors.Executor;
import kimage.tools.executors.gui.StepHandlerExecutor;
import kimage.utils.gui.ImageFrame;



public class ProjektAO {
    public static void main(String[] args){
         Image img = new Image("./res/in.jpg");

         
         String imageName = "./res/in.jpg";
        Executor exec = new StepHandlerExecutor(imageName);
        Executor exec2 = new StepHandlerExecutor(imageName);
       
       
        /**
         * wyodrebnienie zarysu kosci
         */
         exec.add(new Erosion2(new CrossSE(3)));
         exec.add(new Erosion2(new CrossSE(3)));
         exec.add(new Sobel());
         
         exec.add(new ImagePartByRange(),"min",0,"max",123 );
         exec.add(new Dylation2(new CrossSE(3)));
         exec.add(new Dylation2(new CrossSE(3)));
         exec.add(new Erosion2(new CrossSE(3)));
         
         exec.add(new Thining(3));
         exec.add(new Dylation2(new CrossSE(3)));
         exec.add(new Dylation2(new CrossSE(3)));
           
         exec.add(new Thining(3));
         exec.add(new Dylation2(new CrossSE(3)));
         
         exec.add(new Thining(1));
         exec.add(new Dylation2(new CrossSE(3)));
         exec.add(new Dylation2(new CrossSE(3)));
         exec.add(new Erosion2(new CrossSE(3)));
         
         exec.add(new Thining(7));
         exec.add(new Prunning(10));
         exec.add(new Dylation2(new CrossSE(5))); 
         exec.add(new Dylation2(new CrossSE(5))); 
         exec.execute();
        /*
         koniec wyodrebniania zarysu
         */
         
        /**
         * przygotowanie tla na ktroe bedzie nakladany zarys krawedzi kosci
         * 
         */
         exec2.add(new ImagePartByRange(),"min",125,"max",220); 
         exec2.add(new Erosion2(new CircularSE(3)));
         /**
          * nalozenie zarysu na tlo
          */
         exec2.add(new AddToImage(exec.getResultImage()));
         exec2.execute();
        
         Image i = exec2.getResultImage().copy();
         /**
          * wyszukanie i kolorowanie spojnych czesci 
          */
        
        Plugin com = new ConnectedComponent();
        com.process(i, i);
        
        ImageFrame frame = new ImageFrame(i);
        frame.display();
        
        /*
         dodanie kolorowych fragmentow do obrazu wejsiowego
        */
        AddToImage a = new AddToImage();
        a.AddColoredPicture(img,i);
        ImageFrame frame2 = new ImageFrame(img);
        frame2.display();
        
        
    }
}
