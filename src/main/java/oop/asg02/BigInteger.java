package oop.asg02;

public class BigInteger  {

   String init;
   String chuoi;    

    public BigInteger (int init) {
       
        this.init=init +"";
    }

    public BigInteger (String init) {
        
        this.init = init;
    }

    public String toString() {
        
            chuoi = init;
	     int xet=0;
           
	     for(int i=0;i<chuoi.length();i++)
	     {
		if(chuoi.charAt(i)=='0')
	        {
	 		xet++;
		}
                else break;
	     }
             if(xet==chuoi.length())
             {
                 chuoi = "0";
                 return chuoi;
             }
	        chuoi=chuoi.substring(xet);
	        return chuoi; 
   }    
        
        public long toLong() {
         long songuyen = 0; 
         int n;
         int dem;
         String[] chuoikt = init.split("");
         int[] arr = new int[chuoikt.length];
         n=chuoikt.length;
         for(int i=0; i<n-1;i++)
         {
             arr[i]=init.charAt(i)-48;
         }
             dem=n-2;
        for(int i=0;i<n-1;i++)
        {
            if(dem<0)break;
            songuyen=songuyen + (long)arr[i]*mu(10,dem);
            dem--;
        }
         return songuyen;
    }
    
      public BigInteger add(BigInteger other) {
       
          String s="";  
          String str;
          str = other.toString();
          
          int size = max(init.length(),str.length());
          int [] arr1 = new int[size];
          int [] arr2 = new int[size];
          int [] sum = new int[size+1];
          int dem1=init.length()-1; 
          int dem2=str.length()-1;
          
          for(int i=size-1;i>=0;i--)
          {
             if(dem1 >= 0)
             {
                 arr1[i]=init.charAt(dem1)-48;
                 dem1--;
             }
             else
             {
                 arr1[i]=0;
             }
             if(dem2>=0)
             {
                 arr2[i]=str.charAt(dem2)-48;
                 dem2--;
             }
             else
             {
                 arr2[i]=0;
             }
              
          }
   
          int nho=0, tong = 0, du = 0;
          for(int i=size;i>=0 ;i--)
          {
              if(i>0)
              {
                 tong = arr1[i-1] + arr2[i-1];
                
              }
              else tong=0;
              if(tong>9 || nho>0)
              {
                tong=tong+nho; 
                nho=0;
                if(tong>9)
                {
                   du=tong%10;
                   nho++;
                    
                }
                else du=tong;
               sum[i]=du;
              }
              else
              {
                  sum[i]=tong;
              }
             
          }
        
           for(int i=0; i<size+1 ; i++)
           {
            
                   s=s + sum[i];
                   
           }
          
        return new BigInteger(s); 
     }
      
     public BigInteger subtract(BigInteger other) {
         
          String s="";  
          String str;
          str = other.toString();
         
          int size = max(init.length(),str.length());
          int [] arr1 = new int[size];
          int [] arr2 = new int[size];
          int [] sum = new int[size];
          int dem1=init.length()-1; 
         int dem2=str.length()-1;
          
          for(int i=size-1;i>=0;i--)
          {
             if(dem1 >= 0)
             {
                 arr1[i]=init.charAt(dem1)-48;
                 dem1--;
             }
             else
             {
                 arr1[i]=0;
             }
             if(dem2>=0)
             {
                 arr2[i]=str.charAt(dem2)-48;
                 dem2--;
             }
             else
             {
                 arr2[i]=0;
             }
              
          }
   
          int nho=0, hieu = 0, du = 0;
          
          if(arr1[0]>arr2[0])
          {
              for(int i=size-1;i>=0 ;i--)
              { 
                 arr2[i]=arr2[i]-nho;
                 if(arr1[i] >= arr2[i] )
                  {
                      hieu = arr1[i] - arr2[i] ;
                      nho=0;
                  }
                  else
                  {
                      hieu = arr1[i] +10 -arr2[i];
                      nho=0;
                      nho--;
                      
                  } 
                  sum[i]=hieu; 
               }
          }
          else
          {
              for(int i=size-1;i>=0 ;i--)
              { 
                 arr1[i]=arr1[i]-nho;
                 if(arr2[i] >= arr1[i] )
                  {
                      hieu = arr2[i] - arr1[i] ;
                      nho=0;
                  }
                  else
                  {
                      hieu = arr2[i] +10 -arr1[i];
                      nho=0;
                      nho--;
                      
                  } 
                  sum[i]=hieu; 
              }
              s="-";
          }
           for(int i=0; i<size ; i++)
           {     
                   s=s + sum[i]; 
           }
          
        return new BigInteger(s); 
     }   
     
     
       public boolean equals(Object other) {
	
        return toString().equals(other.toString());
    }
       public int compareTo(BigInteger other)
       {
           int a,b,c;
           
           String str = other.toString();
          int size = max(init.length(),str.length());
          int [] H1 = new int[size];
          int [] H2 = new int[size];
          int dem1=init.length()-1; 
          int dem2=str.length()-1;
          
          for(int i=size-1;i>=0;i--)
          {
             if(dem1 >= 0)
             {
                 H1[i]=init.charAt(dem1)-48;
                 dem1--;
             }
             else
             {
                 H1[i]=0;
             }
             if(dem2>=0)
             {
                 H2[i]=str.charAt(dem2)-48;
                 dem2--;
             }
             else
             {
                 H2[i]=0;
             }
          }
          if (dem1>dem2) return 1;
          else if(dem1 < dem2) return -1;
          else
          {
              for(int i=0; i<size;i++)
              {
                  if(H1[i]>H2[i])
                  {
                      return 1;
                  }
                  else if (H1[i]<H2[i])
                  {
                      return -1;
                  }
              }
          }
           return 0;
       }
   
       public BigInteger clone()
       {
          String S;
          S=init;
          BigInteger bansao = new BigInteger(S);
           return bansao;
       }
     public int mu(int x, int n){
           int S=1;
           for(int i=0;i<n;i++)
           {
               S=S*x;
           }
           return S;
       }
     
     public int max(int x, int n){
         if(x>n) return x;
         else return n;
     }
}



