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
