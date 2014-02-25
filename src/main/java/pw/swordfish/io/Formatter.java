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

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author brandon
 */
public abstract class Formatter<T> implements Deserializer<T>, Serializer<T> {
	@Override
	public T fromBuffer(byte[] buffer) throws FormatException {
		return fromBuffer(buffer, 0);
	}

	@Override
	public void serialize(T self, OutputStream o) throws FormatException {
		try {
			o.write(asBuffer(self));
		} catch (IOException ex) {
			throw new FormatException(ex);
		}
	}

	@Override
	public void toBuffer(T self, byte[] buffer) throws FormatException {
		toBuffer(self, buffer, 0);
	}
}
