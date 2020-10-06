public class Sword21 {
    public int[] exchange(int[] nums) {
        // 双指针法
        int left = 0, right = nums.length - 1;
        int temp;
        while (left < right){
//            if (!isOdd(nums[left]) &&  isOdd(nums[right])) {// 前偶右奇
//                temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//                right--;
//            }else if (!isOdd(nums[left]) && !isOdd(nums[right])){// 前偶右偶
//                right--;
//            }else if (isOdd(nums[left]) && isOdd(nums[right])){// 前奇右奇
//                left++;
//            }else {// 前奇右偶
//                left++;
//                right--;
//            }
            if (isOdd(nums[left])) {// 前奇
                left++;
            }else if (!isOdd(nums[right])){// 后偶
                right--;
            }else {// 前偶后奇
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    private boolean isOdd(int num){
        return num % 2 == 1;
    }
}
