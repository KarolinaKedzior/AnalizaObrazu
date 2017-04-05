
package kimage.sample.masks;


public class LineSE extends SE{
    
    public LineSE(int SEsize) {
        super(SEsize);
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                if( i == (size/2) )
                {mask[i][j] = 1;}
    }}
    }
     public static void main(String [] args) {
        
        SE line = new LineSE(7);
        line.println();
        line.rotate();

        line.println();
    }
}
