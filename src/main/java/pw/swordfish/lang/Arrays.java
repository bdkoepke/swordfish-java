/*
 * Copyright (C) 2013 Brandon Koepke
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
package pw.swordfish.lang;

import java.lang.reflect.Array;

/**
 * @author Brandon Koepke
 */
public class Arrays {
	private Arrays() {}

	/**
	 * Workaround for type erasure.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<T> componentType, int length) {
		return (T[]) Array.newInstance(componentType, length);
	}

	public static <T> T[] prepend(Class<T> componentType, T car, T[] cdr) {
		T[] a = newArray(componentType, cdr.length + 1);
		a[0] = car;
		System.arraycopy(cdr, 0, a, 1, cdr.length);
		return a;
	}
}
