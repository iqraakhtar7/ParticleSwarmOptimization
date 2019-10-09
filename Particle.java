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
public class Particle {
       
        public double x,y,z,vx,vy,vz,fitness;
        private double minX=-2;
        private double maxX=2;
        private double minY=-1;
        private double maxY=3;
        private double minZ=0;
        private double maxZ=3;
        private Particle p_best;
        public double C1 = 2, C2 = 2;
        Random r = new Random();
        
    public static double getRandom(double min, double max) {

         Random r2 = new Random();
   return min + (max - min) * r2.nextDouble();

    }
        public Particle()
        {
         x = getRandom(minX,maxX) ;
         y = getRandom(minY,maxY);
         z = getRandom(minZ,maxZ);
         fitness_func(x,y,z);
        }
        
        
     public Particle(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
      fitness_func(x,y,z);
    }
         
         public void fitness_func(double x,double y,double z)
    {
        
        this.fitness =Math.pow(x, 2)- 2*x*y*Math.pow(z, 2) + 2*Math.pow(y, 2)*z - 5.7*x*y*z + Math.pow(z,2);
       
    }
         
    public void calculatePersonalBest() {

        if (p_best != null) {
            if (this.getFitness() > this.p_best.getFitness()) {
                this.p_best = new Particle(this.x, this.y,this.z);
            }
        } 
        else {
            p_best = new Particle(this.x, this.y,this.z);
        }
    }
    
    
    
     public static Particle calculateGlobalBest(ArrayList<Particle> plist, Particle g_best) {

        if (g_best != null) {
            for (int i = 1; i < plist.size(); i++) {
                if (plist.get(i).getFitness() > g_best.getFitness()) {

                    g_best = new Particle(plist.get(i).getX(), plist.get(i).getY(), plist.get(i).getZ());

                }
            }
        } 
        else {
            g_best = new Particle(plist.get(0).getX(), plist.get(0).getY(), plist.get(0).getZ());
        }

        return g_best;
    }
     

 public Particle getPersonalBest() {
        return p_best;
    }

    public void setPersonalBest(Particle best) {
        this.p_best = best;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getX() {
        return x;
    }

   public void setX(double x) {

        if (x > maxX) {
            this.x = maxX; 
        } else if (x < minX) {
            this.x = minX; 
        }
        else{            

            this.x=x;
        }
    }
 public void setY(double y) {

        if (y > maxY) {
            this.y = maxY; 
        } else if (y < minY) {
            this.y = minY;
        }
        else{
            
            this.y=y;
        }
    }
public void setZ(double z) {

        if (z > maxZ) {
            this.z =maxZ; 
        } else if (z <minZ)
        {
            this.z = minZ;
        }
        else{
            
            this.z=z;
        }
    }
    public double getY() {
        return y;
    }

  
    public double getZ() {
        return z;
    }

  
    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getVz() {
        return vz;
    }

    public void setVz(double vz) {
        this.vz = vz;
    }
    
        public String sout() {
            return "x = " +x+ "  y = " +y+ "  z= " +z+ "  fitness = " +fitness;
        }
        
    }
    
   


