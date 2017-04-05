
package kimage.sample.masks;
public class SE {
     /**
      * size - rozmiar maski
      * mask - tablica wartosci maski (-1,0 lub 1)
      */
     public int mask[][];
     protected int size;
     
     /**
      * 
      * @param maskIn 
      * inicjalizuje maske przeslana tablica maskIn
      */
     public void setMask(int[][] maskIn)
     {
         for(int i=0;i<3;i++)
         {for(int j =0 ; j < 3; j++)
            this.mask[i][j] = maskIn[i][j];
             }
     }
    
     public SE(int SEsize){
         mask = new int[SEsize][SEsize];
         this.size = SEsize;
         for(int i =0;i < SEsize; i++){
             for(int j = 0; j < SEsize; j++){
                 mask[i][j] = 0;
             }
         }
     }
     
     public int getSize(){
         return size;
     }
     public int valueOf(int i, int j)
     {
         return mask[i][j];
     }
     
     /**
      * obraca tablice mask o 90 stopni
      */
    public void rotate()
    {
        int tmpMask[][] = new int[size][size];
        for(int i =0;i < size; i++){
             for(int j = 0; j < size; j++){
                 tmpMask[j][size - i - 1] = mask[i][j];   
             }
        }
        mask = tmpMask;
    }
     
             
    public void println()
    {
        for(int i = 0 ; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                System.out.print(mask[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }

      /* public int indication(){
           int tab[][] = new int[size][size];
           int indication  = 1;
           for (int k=0; k < size; k++)
            {
                    for (int i=k+1; i<size; i++)
                    for (int j=size-1; j>=k; j--)
                    tab[i][j] = mask[i][j] - mask[i][k]*mask[k][j]/mask[k][k];
                }   
           
           for(int l =0; l < size; l++){
               indication *= tab[l][l];
                   
               }
           return indication;
       }*/
       
       public int magnitude(){
           int indication;
                 indication = Math.abs( (mask[0][0]+ 2*mask[0][1]+ mask[0][2])-
                         (mask[2][0]+ 2*mask[2][1] + mask[2][2])) +
                         Math.abs( (mask[0][2] + 2* mask[1][2] + mask[2][2]) - 
                                 (mask[0][0] + 2*mask[1][0]+ mask[2][0]) );
               
           return indication;
       }
       
     public static  void  main(String args[])
     {
         int tab[][] = { 
             {0,0,0},
             {-1,1,-1},
             {1,1,1}};
        SE k = new SE(3);
        k.setMask(tab);
        k.rotate();
        k.rotate();
        k.println();
        
   
        
     
     }
};

