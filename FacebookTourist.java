/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//KOUSHIK_RAMAN
package facebooktourist;
import java.util.Scanner;
/**
 *
 * @author rkous
 */
public class FacebookTourist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kbd=new Scanner(System.in);
        int T=kbd.nextInt();
        long N,K,V;
        String places[];
        long refPlaces[][];
        String result[][];
        String[][] finalResult=new String[(int)T][];
        String temp3,temp4;
        boolean flag=true;
        long temp1,temp2;
        for(int i=1;i<=T;i++){
            N=kbd.nextInt();
            K=kbd.nextInt();
            V=kbd.nextLong();
            result=new String[(int)K][2];
            finalResult[i-1]=new String[(int)K];
            places=new String[(int)N];
            for(int x=0;x<(int)N;x++){
                places[x]=kbd.next();
            }
            refPlaces=new long[(int)N][(int)2];
            for(int x=0;x<(int)N;x++){
                refPlaces[x][0]=x+1;
                refPlaces[x][1]=0;
            }
            
            for(long x=1;x<=V;x++){
                for(int y=0;y<(int)K;y++){
                    result[y][0]=places[(int)refPlaces[y][0]-1];
                    result[y][1]=Integer.toString((int)refPlaces[y][0]);
                    refPlaces[y][1]++;
                }
                
                for(int q=(int)N-1;q>0;q--){
                for(int z=q-1;z>=0;z--){
                    if(refPlaces[q][1]<refPlaces[z][1]){
                        temp1=refPlaces[z][0];
                        refPlaces[z][0]=refPlaces[q][0];
                        refPlaces[q][0]=temp1;
                            
                        temp2=refPlaces[z][1];
                        refPlaces[z][1]=refPlaces[q][1];
                        refPlaces[q][1]=temp2;
                    }
                    else if(refPlaces[q][1]==refPlaces[z][1] && refPlaces[q][0]<refPlaces[z][0]){
                        temp1=refPlaces[z][0];
                        refPlaces[z][0]=refPlaces[q][0];
                        refPlaces[q][0]=temp1;
                            
                        temp2=refPlaces[z][1];
                        refPlaces[z][1]=refPlaces[q][1];
                        refPlaces[q][1]=temp2;
                    }
                }
                }
                
            }
            for(int n=0;n<(int)K-1;n++){
            for(int m=n+1;m<(int)K;m++){
                if(Integer.parseInt(result[n][1])>Integer.parseInt(result[m][1])){
                    temp3=result[n][0];
                    result[n][0]=result[m][0];
                    result[m][0]=temp3;
                    
                    temp4=result[n][1];
                    result[n][1]=result[m][1];
                    result[m][1]=temp4;
                }
            }
            }
            
            for(int p=0;p<(int)K;p++){
                finalResult[i-1][p]=result[p][0];
            }
            
        }
        
        for(int i=0;i<(int)T;i++){
            System.out.print("Case #"+i+": ");
            for(int j=0;j<finalResult[i].length;j++){
                System.out.print(finalResult[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
}
