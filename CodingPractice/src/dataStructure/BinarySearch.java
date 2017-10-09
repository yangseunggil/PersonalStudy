package dataStructure;

public class BinarySearch {
	
	public static int location(int[] arr, int key, int low, int high) {
		int mid;
		
		if(low > high){
			return 0;
		}else{
			mid = (low + high) / 2;
			if(key == arr[mid]){
				return mid;
			}else if(key < arr[mid]){
				return location(arr, key, low, mid -1);
			}else{
				return location(arr, key, mid+1, high);
			}
		}
	}
	
	public static void main(String args[]){
		int arr[] = {10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47};
		System.out.println(location(arr, 18, 0, 12));
	}
}

    