package com.lxl.algorithms;

import java.util.Arrays;

public class MergeSort {
	/**
	 * 合并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
	 * 
	 * 合并排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
	 * 然后再把有序子序列合并为整体有序序列。
	 * 
	 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
	 * 合并排序也叫归并排序。 复杂度 最坏时间复杂度 最好时间复杂度 空间复杂度 与快速排序类似
	 * 
	 * @param array
	 */
	public static void mergeSort(int[] array) {

		int length = array.length;
		int middle = length / 2;

		if (length > 1) {

			int[] left = Arrays.copyOfRange(array, 0, middle);// 拷贝数组array的左半部分
			int[] right = Arrays.copyOfRange(array, middle, length);// 拷贝数组array的右半部分
			mergeSort(left);// 递归array的左半部分
			mergeSort(right);// 递归array的右半部分
			merge(array, left, right);// 数组左半部分、右半部分合并到Array

		}
	}

	// 合并数组，升序
	private static void merge(int[] result, int[] left, int[] right) {

		int i = 0, l = 0, r = 0;

		while (l < left.length && r < right.length) {

			if (left[l] < right[r]) {
				result[i] = left[l];
				i++;
				l++;
			} else {
				result[i] = right[r];
				i++;
				r++;
			}
		}

		while (r < right.length) {// 如果右边剩下合并右边的
			result[i] = right[r];
			r++;
			i++;
		}

		while (l < left.length) {
			result[i] = left[l];
			l++;
			i++;
		}
	}
}
