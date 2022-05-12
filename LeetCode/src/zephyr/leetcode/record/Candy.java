package zephyr.leetcode.record;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 贪心算法
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return 1;
        }
        int[] candyNum = new int[ratings.length];
        // 全部初始化为1
        Arrays.fill(candyNum, 1);
        // 向右边遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candyNum[i] = candyNum[i-1] + 1;
            }
        }

        // 向左边遍历 （需要选取当前和+1之后的最大值）
        for (int i = ratings.length-2; i >=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candyNum[i] = Math.max(candyNum[i+1] + 1, candyNum[i]);
            }
        }

        int num = 0;
        for (int value : candyNum) {
            num += value;
        }
        return num;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int[] {1, 3, 4, 5, 2}));
    }
}
