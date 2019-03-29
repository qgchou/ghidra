/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated by Together */

package ghidra.program.util;

import ghidra.framework.options.SaveState;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Program;
import ghidra.program.model.symbol.SourceType;

/**
 * The <CODE>FunctionSignatureFieldLocation</CODE> class provides specific information
 * about the Function Signature field within a program location.
 */

public class FunctionSignatureSourceFieldLocation extends FunctionLocation {

	private String source;

	/**
	 * Construct a new FunctionSignatureFieldLocation object.
	 * 
	 * @param the program of the location
	 * @param locationAddr the address of this location.
	 * @param functionAddr the function address
	 * @param source the function signature SourceType at this location.
	 * @param charOffset field character position
	 */
	public FunctionSignatureSourceFieldLocation(Program program, Address locationAddr,
			Address functionAddr, String source, int charOffset) {

		super(program, locationAddr, functionAddr, 0, 0, charOffset);
		this.source = source;
	}

	/**
	 * Default constructor needed for restoring
	 * a program location from XML
	 */
	public FunctionSignatureSourceFieldLocation() {
	}

	/**
	 * Return the function signature source at this location.
	 * @see SourceType
	 */
	public String getSignatureSource() {
		return source;
	}

	/**
	 * Returns a String representation of this location.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Function signature source = " + source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionSignatureSourceFieldLocation other = (FunctionSignatureSourceFieldLocation) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		}
		else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public void saveState(SaveState obj) {
		super.saveState(obj);
		obj.putString("_SIGNATURE_SOURCE", source);
	}

	@Override
	public void restoreState(Program p, SaveState obj) {
		super.restoreState(p, obj);
		source = obj.getString("_SIGNATURE_SOURCE", null);
	}

}