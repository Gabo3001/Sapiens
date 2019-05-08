package tutorial1;

/**
 *
 * @author karymenahleacosta
 */

public class MetodosNumericos {

   
    //Declare score of every leven and quiz
    private int N1;
    private int N2;
    private int N3;
    private int N4;
    private int N5;
    private int N6;
    
    private int Q1;
    private int Q2;
    private int Q3;
    
    private int P1;
    private int P2;
    private int P3;
    
    private int sX;//Sum of X
    private int sY;//Sum of Y
    private int pX;//Sum of X^2
    private int sXY;//Sum of X*Y
    
    private int N;//number of data

    
    private int iCol; //Num of columns
    private int iRow; //Num of Rows
    private int PivoteAnterior;


    public static void Method(String args[]) {
        MetodosNumericos obj = new MetodosNumericos(1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 3, 2, 1);
        obj.montante();
      }

    public MetodosNumericos(int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8, int v9, int v10, int v11, int v12, int v13){
 

    this.N1=v1;//level1
    this.N2=v2;//level2
    this.N3=v3;//level3
    this.N4=v4;//level4
    this.N5=v5;//level5
    this.N6=v6;//level6
    
    this.Q1=v7;//quiz1
    this.Q2=v8;//quiz2
    this.Q3=v9;//quiz3
    
    this.N=v10;//number of revolutions
    this.iCol=v11;
    this.iRow=v12;
    this.PivoteAnterior=v13;
    
    this.P1=(N1+N2)/2;
    this.P2=(N3+N4)/2;
    this.P3=(N5+N6)/2;
    
    this.sX= P1+P2+P3;
    this.pX=(P1*P1)+(P2*P2)+(P3*P3);//SUM(x^2)
    this.sY=Q1+Q2+Q3;//Quizes
    this.sXY=(P1*Q1)+(P2*Q2)+(P3*Q3);//SUM(x*y)
    
  
}

    
public void montante(){
    
    //Initialize matrix with sea of regresion lineal
    int mati [][]={{N,sX,sY},{sX,pX,sXY}};

    for (int i=0; i<iRow; i++){
      for (int k=0; k<iRow; k++){
    
        if(i != k){
        for (int j=(i+1);j<iCol; j++){
           mati[k][j]=(mati[i][i] * mati[k][j] -  mati[k][i] * mati[i][j]) / PivoteAnterior;
        }
        mati[k][i]=0;
        }
        
    }
    PivoteAnterior = mati[i][i];

}

for(int i=0; i<=(iRow-1);i++){

    mati[i][i]= PivoteAnterior;
}

for(int i=0;i<=1;i++){
    for (int j=2;j<=2; j++){
    
    System.out.print("Error, Pivote igual a ");
    System.out.println(PivoteAnterior);

    mati[i][j] = mati[i][2]/PivoteAnterior;
    System.out.print(mati[i][j]);
}
}

}



}
