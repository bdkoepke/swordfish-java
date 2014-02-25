/*
 * Copyright (C) 2013 brandon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pw.swordfish.util;

import com.google.common.base.Function;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author brandon
 */
public class Maps {
	public static <K, V> Map<K, V> asMap(Set<V> s, Function<V, K> f) {
		Map<K, V> map = new HashMap<K, V>();
		for (V value : s) {
			map.put(f.apply(value), value);
		}
		return map;
	}
}
