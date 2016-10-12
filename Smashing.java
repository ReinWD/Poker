import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * Created by 张巍 on 2016/10/12.
 */
public class Smashing{
    public static void main(String []args){
        String []poker=new String[54];
        String []suit={"Club   ","Spade  ","Diamond","Heart  "};
        String []point={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int i=0,n=0,m=0;
        for (i=0;i<52;i++){
            poker[i]=suit[n]+" "+point[m];
            n++;
            if(n==4){
                n=0;m++;
            }
        }
        poker[52]="joker";
        poker[53]="JOKER";

        String[]cache=new String[54];
        int[]temp=new int[54];
        int numCount=0;
        for(n=0;n<54;n++){
            temp[n]=200;
        }
        n=0;
        while(numCount!=54){
            double t= (Math.floor(100 *Math.random()));
            int w=(int)t;
            if(w>=54){
                continue;
            }
            if (w==temp[w]) {
                continue;
            }
                cache[n] = poker[w];
                temp[w] = w;
                numCount++;
                n++;
            }
        for(String out:cache){
            System.out.println(out);
        }
    }
}

