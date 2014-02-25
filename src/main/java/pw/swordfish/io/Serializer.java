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

package pw.swordfish.io;

import java.io.OutputStream;

/**
 * @author brandon
 */
public interface Serializer<T> {
	void serialize(T self, OutputStream o) throws FormatException;
	byte[] asBuffer(T self) throws FormatException;
	void toBuffer(T self, byte[] buffer) throws FormatException;
	void toBuffer(T self, byte[] buffer, int offset) throws FormatException;
}