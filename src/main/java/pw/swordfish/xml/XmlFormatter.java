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

package pw.swordfish.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBException;
import pw.swordfish.io.FormatException;
import pw.swordfish.io.Formatter;

/**
 * @author brandon
 */
public class XmlFormatter<T> extends Formatter<T> {
	private final XmlContext<T> context;

	public XmlFormatter(XmlContext<T> context) {
		this.context = context;
	}

	public T deserialize(InputStream i) throws FormatException {
		try {
			return this.context.unmarshall(i);
		} catch (JAXBException ex) {
			throw new FormatException(ex);
		}
	}

	public T fromBuffer(byte[] buffer, int offset) throws FormatException {
		return deserialize(new ByteArrayInputStream(buffer, offset, buffer.length - offset));
	}

	public byte[] asBuffer(T self) throws FormatException {
		ByteArrayOutputStream o = new ByteArrayOutputStream();
		try {
			context.marshall(self, o);
		} catch (JAXBException ex) {
			throw new FormatException (ex);
		}
		return o.toByteArray();
	}

	public void toBuffer(T self, byte[] buffer, int offset) throws FormatException {
		byte[] o = asBuffer(self);
		System.arraycopy(o, offset, buffer, offset, offset + o.length - offset);
	}
}