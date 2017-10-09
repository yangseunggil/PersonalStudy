package dataStructure;

public class SelectionSort {
	public static void selectionSort(int[] list) {
	    int indexMin, temp;

	    for (int i = 0; i < list.length - 1; i++) {
	        indexMin = i;
	        for (int j = i + 1; j < list.length; j++) {
	            if (list[j] < list[indexMin]) {
	                indexMin = j;
	            }
	        }
	        System.out.println(indexMin);
	        temp = list[indexMin];
	        list[indexMin] = list[i];
	        list[i] = temp;
	    }
	}
	
	public static void main(String args[]){
		int[] arr = {15,22,13,27,12,10,20,25};
		selectionSort(arr);

	}
}
