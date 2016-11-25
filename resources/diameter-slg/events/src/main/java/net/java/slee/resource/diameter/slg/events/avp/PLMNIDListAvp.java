/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Reporting-PLMN-List AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.49	PLMN-ID-List
 * The PLMN-ID-List AVP is of type Grouped.
 * AVP format:
 * 						PLMN-ID-List ::= <AVP header: 2544 10415>
 * 														{ Visited-PLMN-Id }
 * 														[ Periodic-Location-Support-Indicator ]
 * 														*[ AVP ]
 * If not included, the default value of Periodic-Location-Support-Indicator shall be considered as "NOT_SUPPORTED" (0).
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface PLMNIDListAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.272 V12.9.0

		The Visited-PLMN-Id AVP is of type OctetString. This AVP shall contain the concatenation of MCC and MNC. See 3GPP TS 23.003 [3].
		The content of this AVP shall be encoded as an octet string according to table 7.3.9-1.
		See 3GPP TS 24.008 [31], clause 10.5.1.13, PLMN list, for the coding of MCC and MNC.
		If MNC is 2 digits long, bits 5 to 8 of octet 2 are coded as "1111".

		Table 7.3.9/1: Encoding format for Visited-PLMN-Id AVP
		8	 7	6 	5		4	 3	2	 1
		MCC digit 2 	MCC digit 1		octet1
		MNC digit 3	  MCC digit 3		octet 2
		MNC digit 2	 	MNC digit 1		octet 3
  */
  public boolean hasVisitedPLMNId();
  public byte[] getVisitedPLMNId();
  public void setVisitedPLMNId(byte[] visitedPLMNId);

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.50	Periodic-Location-Support-Indicator
		The Periodic-Location-Support-Indicator AVP is of type Enumerated and it indicates if the given PLMN-ID
		(indicated by Visited-PLMN-Id) supports periodic location or not. The following values are defined:
			NOT_SUPPORTED (0)
			SUPPORTED (1)
	*/
  public boolean hasPeriodicLocationSupportIndicator();
  public PeriodicLocationSupportIndicator getPeriodicLocationSupportIndicator();
  public void setPeriodicLocationSupportIndicator(PeriodicLocationSupportIndicator periodicLocationSupportIndicator);

}
