/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author pc
 */
public class PSO {
    
static ArrayList<Particle> plist;
static int N=10;
  public static Particle globalBest;
    double pre_gbest=0;
    public static void main(String[] args) {
         plist = new ArrayList<>();
   
        //initializing n particles
        for (int i = 0; i < N; i++) {
           
            plist.add(new Particle());
            plist.get(i).calculatePersonalBest();
           
        }
         globalBest= Particle.calculateGlobalBest(plist, globalBest);
       int j=1;
       for(int q=0;q<100;q++) {

            for (Particle particle : plist)
        //     for (int i=0; i<plist.size();i++) 
             {
                    
                  double C1=2, C2=2;
          
            particle.setVx ( particle.getVx() + C1 * getRandom(0,1) * (particle.getPersonalBest().getX()- particle.getX()) + C2 *getRandom(0,1) * (globalBest.getX() -  particle.getX()));
            particle.setX ( particle.getX() + particle.getVx()) ;
         
            particle.setVy ( particle.getVy() + C1 * getRandom(0,1)* (particle.getPersonalBest().getY()- particle.getY()) + C2 * getRandom(0,1) * (globalBest.getY() - particle.getY()));
             particle.setY(  particle.getY() + particle.getVy());
          
          
            particle.setVz (  particle.getVz() + C1 * getRandom(0,1)* ( particle.getPersonalBest().getZ()- particle.getZ()) + C2 * getRandom(0,1) * (globalBest.getZ() -  particle.getZ()));
            particle.setZ (   particle.getZ() + particle.getVz());
           
           particle.fitness_func(particle.getX(),particle.getY(),particle.getZ());
                particle.calculatePersonalBest();
                
            }

           
            double pre_gbest=globalBest.getFitness();
            System.out.println("\n\n"+(j-1)+"th-PREVIOUS GENERATION : "+pre_gbest);
            globalBest=Particle.calculateGlobalBest(plist, globalBest);
            System.out.println(+j+"th-CURRENT GENERATION : "+globalBest.getFitness());
            for (int i = 0; i < plist.size(); i++) {
                   
              // System.out.println(" Particle :"+(i+1)+"\tfitness="+plist.get(i).getFitness()+"   x="+ plist.get(i).getX()+"   y="+plist.get(i).getY()+"   z="+plist.get(i).getZ()+"   xv="+plist.get(i).getVx()+"   yv="+plist.get(i).getVy()+"   xz="+plist.get(i).getVz());
                System.out.println(plist.get(i).getFitness());
            }
           
            j++;
         
        }
        
        
    }
    public static double getRandom(double min, double max) {

         Random r2 = new Random();
   return min + (max - min) * r2.nextDouble();

    }
}
