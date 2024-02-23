package edu.zjnu.biz.utils;

/**
 * @author: 杨海波
 * @date: 2023-01-11 17:00:55
 * @description: todo
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author setsunayang
 */
public class SplitListUtil {

	public static <T> List<List<T>> split(List<T> list, int batchSize) {
		List<List<T>> res = new ArrayList<>();
		int k = 0;
		List<T> temp = new ArrayList<>();
		for (T t : list) {
			temp.add(t);
			k++;
			if (k >= batchSize) {
				k = 0;
				res.add(temp);
				temp = new ArrayList<>();
			}
		}
		if (!temp.isEmpty()) {
			res.add(temp);
		}
		return res;
	}

}

