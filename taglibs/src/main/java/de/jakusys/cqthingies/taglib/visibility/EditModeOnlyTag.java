/**
 * Copyright (C) 2013 Jakob Külzer (jakob.kuelzer@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.jakusys.cqthingies.taglib.visibility;

import com.day.cq.wcm.api.WCMMode;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Simple tag that will only show it's content in edit mode.
 *
 * @author Jakob Külzer
 */
public class EditModeOnlyTag extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {

		final WCMMode wcmMode = WCMMode.fromRequest(pageContext.getRequest());

		if (wcmMode == WCMMode.EDIT)
			return SKIP_BODY;

		return EVAL_BODY_INCLUDE;
	}
}
