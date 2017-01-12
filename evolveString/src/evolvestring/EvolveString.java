/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evolvestring;

import java.util.Random;

/**
 *
 * @author Andrew of Matrai
 */
public class EvolveString
{
    public static String genString(int length)//generates random string of length
    {
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<length;i++)
        {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
    public static eString[] generatePopulation(int n, int m) //generates the initial population. n estrings of length m
    {
        eString population[] = new eString[n];
        for (int i=0;i<n;i++)//number of eStrings to be generated
        {
            population[i] = new eString();
            population[i].str = genString(m);
        }
        return population;
    }
    public static void printeStringArray(eString pop[])//method to print an estring array
    {
        for (int i=0;i<pop.length;i++)
        {
            System.out.println("String: " + pop[i].str + " Fitness: " + pop[i].fitness);
        }
    }
    //hamming distance is how I am evaluating the fitness of the string. It is a value that measures how close a string is to the 'perfect' string
    public static int getHammingDistance1(String perfect, String tested)//first method only getting the num of chars that are different

    {
        int distance = 0;
        for (int i=0;i<perfect.length();i++)
        {
            if (perfect.charAt(i)!=tested.charAt(i))
            {
                distance++;
            }
        }
        return distance;
    }
    public static void evaluateFitness(eString pop[], String perfectStr)
    {
        for (int i=0;i<pop.length;i++)
        {
            System.out.println("test\n");
            pop[i].fitness = getHammingDistance1(perfectStr, pop[i].str);
        }
    }
    //method to return a new population array of eStrings that will reproduce
    //int n is number of parents we want
    public static eString[] getParents(int n, eString population)
    {
        eString newPop[] = new eString[n];
        return newPop;
    }
    
    
    

    public static void main(String[] args)
    {
        //eString is a class that is essentially a string with an assigned 'fitness' other data can be added to estring class to improve genetic algrorithm
        String perfectStr = "Darwin";//perfect string we 'evolve' towards
        int popNum = 3;//eStrings in population
        int strLen = perfectStr.length();//length of strings
        int generations = 5;
        
        eString population[] = generatePopulation(popNum, strLen);//initialize population
        evaluateFitness(population, perfectStr);
        
        System.out.println("Unsorted population\n");
        printeStringArray(population);
        
        eMergeSort.sort(population);
        System.out.println("Sorted population\n");
        printeStringArray(population);
        while (generations>0)
        {
            //evaluateFitness(population, perfectStr);//evaluate fitness of individuals
            //select individuals for reproduction according to fitness
            //combine parent genotypes to produce offspring
            //replace parents with offspring
            generations--;
        }
    }
    
}