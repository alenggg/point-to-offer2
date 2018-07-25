package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/4
 * Time  : 20:45
 * Description: 数字在排序数组中出现的次数
 **/
public class Code_052_GetNumberOfK {

    public static int getNumberOfK(int[] arr, int target) {
        int number = 0;
        if (arr != null || arr.length >= 1) {
            int first = getFirstK(arr, 0, arr.length - 1, target);
            int last = getLastK(arr, 0, arr.length - 1, target);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    private static int getFirstK(int[] arr, int l, int r, int target) {
        if (l == r && arr[l] != arr[l]) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] > target) {
            return getFirstK(arr, l, mid - 1, target);
        }
        if (arr[mid] < target) {
            return getFirstK(arr, mid + 1, r, target);
        }
        if (mid - 1 >= l && arr[mid - 1] == target) {
            return getFirstK(arr, l, mid - 1, target);
        }
        return mid;
    }

    private static int getLastK(int[] arr, int l, int r, int target) {
        if (l == r && arr[l] != arr[l]) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] > target) {
            return getLastK(arr, l, mid - 1, target);
        }
        if (arr[mid] < target) {
            return getLastK(arr, mid + 1, r, target);
        }
        if (mid + 1 <= r && arr[mid + 1] == target) {
            return getLastK(arr, mid + 1, r, target);
        }
        return mid;
    }


    public static int getNumberOfK2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int flag = getNumberOfK2(array, 0, array.length - 1, k);
        if (array[flag] == k) {
            int start = flag, end = flag;
            while (start >= 0 && array[start] == k) {
                start--;
            }
            while (end <= array.length - 1 && array[end] == k) {
                end++;
            }
            return end - start - 1;
        }
        return 0;
    }

    private static int getNumberOfK2(int[] array, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        int mid = (l + r) / 2;
        if (array[mid] > k) {
            return getNumberOfK2(array, l, mid - 1, k);
        } else if (array[mid] < k) {
            return getNumberOfK2(array, mid + 1, r, k);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1,2,3,3,3,3,5,6};
        int[] data2 = new int[]{1,2,3,3,3,3,4,5};
        int[] data3 = new int[]{3,3,3,3,3,3,3,3};

        System.out.println(getNumberOfK(data1,3));
        System.out.println(getNumberOfK(data2,3));
        System.out.println(getNumberOfK(data3,3));

    }
}
/*
排序数组，定位某一个数值的位置，很容易想到二分查找。
分成两部分：求第一个出现该值的位置start，求最后一个出现该值得位置end，
end-start+1即为所求。
 */