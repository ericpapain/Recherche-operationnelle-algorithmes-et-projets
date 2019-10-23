/***
* Name: tri_fusion
* Author: eric Papain
* Description: 
* Tags: Tag1, Tag2, TagN
***/


public class tri_fusion {
	public static void triFusion(int tableau[])
    {
    int longueur=tableau.length;
    if (longueur>0)
        {
        triFusion(tableau,0,longueur-1);
        }
    }

private static void triFusion(int tableau[],int deb,int fin)
    {
    if (deb!=fin)
        {
        int milieu=(fin+deb)/2;
        triFusion(tableau,deb,milieu);
        triFusion(tableau,milieu+1,fin);
        fusion(tableau,deb,milieu,fin);
        }
    }

private static void fusion(int tableau[],int deb1,int fin1,int fin2)
    {
    int deb2=fin1+1;

    //on recopie les éléments du début du tableau
    int table1[]=new int[fin1-deb1+1];
    for(int i=deb1;i<=fin1;i++)
        {
        table1[i-deb1]=tableau[i];
        }
    
    int compt1=deb1;
    int compt2=deb2;
    
    for(int i=deb1;i<=fin2;i++)
        {        
        if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
            {
            break; //tous les éléments ont donc été classés
            }
        else if (compt2==(fin2+1)) //c'est que tous les éléments du second tableau ont été utilisés
            {
            tableau[i]=table1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
            compt1++;
            }
        else if (table1[compt1-deb1]<tableau[compt2])
            {
            tableau[i]=table1[compt1-deb1]; //on ajoute un élément du premier tableau
            compt1++;
            }
        else
            {
            tableau[i]=tableau[compt2]; //on ajoute un élément du second tableau
            compt2++;
            }
        }
    }

}
