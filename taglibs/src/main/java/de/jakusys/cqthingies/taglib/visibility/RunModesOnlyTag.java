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

import org.apache.sling.settings.SlingSettingsService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Set;

/**
 * Taglib that will display wrapped content only any of the specified runmodes match.
 *
 * @author Jakob Külzer
 */
public class RunModesOnlyTag extends BodyTagSupport {

	private String runmodes;

	@Override
	public int doStartTag() throws JspException {
		// No runmodes set? Nothing to display.
		if (runmodes == null || runmodes.isEmpty())
			return SKIP_BODY;

		final BundleContext bundleContext = FrameworkUtil.getBundle(RunModesOnlyTag.class).getBundleContext();
		final ServiceReference serviceRef = bundleContext.getServiceReference(SlingSettingsService.class.getName());
		final SlingSettingsService settingsService = (SlingSettingsService) bundleContext.getService(serviceRef);
		final Set<String> activeRunmodes = settingsService.getRunModes();

		final String[] split = runmodes.replaceAll("\\s+", "").replaceAll(",,+", ",").split(",");
		for (String s : split) {
			if (activeRunmodes.contains(s))
				return EVAL_BODY_INCLUDE;
		}

		bundleContext.ungetService(serviceRef);

		runmodes = null;
		return SKIP_BODY;
	}

	/**
	 * Set comma separated list of runmodes.
	 *
	 * @param runmodes
	 */
	public void setRunmodes(String runmodes) {
		this.runmodes = runmodes;
	}

}
