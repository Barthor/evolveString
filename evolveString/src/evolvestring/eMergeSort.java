/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evolvestring;

/**
 *
 * @author Andrew of Matrai
 */
public class eMergeSort
{
    static eString[] nums;
    static eString[] helper;
    
    static int num;
    public static void sort(eString[] values)
    {
        eMergeSort.nums = values;
        num = values.length;
        eMergeSort.helper = new eString[num];
        for (int i=0;i<helper.length;i++)
        {
            eMergeSort.helper[i] = new eString();
        }
        mergesort(0,num-1);
    }
    public static void mergesort(int low, int high)
    {
        if (low < high)
        {
            int mid = low + (high - low) / 2;
            mergesort(low, mid);
            mergesort(mid+1,high);
            merge(low,mid,high);
        }
    }
    public static void merge(int low, int mid, int high)
    {
        for (int i=low;i<=high;i++)
        {
            helper[i]= nums[i];
        }
            
        int i = low;
        int j = mid+1;
        int k = low;
        
        while (i<mid && j <=high)
        {
            if (helper[i].fitness <= helper[j].fitness)
            {
                nums[k] = helper[i];
                i++;
            }
            else
            {
                nums[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= mid)
        {
            nums[k] = helper[i];
            k++;
            i++;
        }
    }
    
}
