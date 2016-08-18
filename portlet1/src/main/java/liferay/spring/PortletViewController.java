/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package liferay.spring;

import com.liferay.portal.kernel.util.ReleaseInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;
import javax.xml.namespace.QName;
import java.io.IOException;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	@RenderMapping
	public String question(Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());
		System.out.println("########################RENDER portlet1##########################");
		return "liferay.spring.test1/view";
	}

	@ActionMapping("action")
	public void action(@RequestParam String greeting, ActionResponse response, ActionRequest request) throws ReadOnlyException, IOException, ValidatorException {
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("greeting", greeting);
		prefs.store();
		System.out.println("#####################" + greeting + "#############");
		System.out.println("###################### ACTION ###############");
	}

	@ActionMapping("event")
	public void event(ActionResponse response, ActionRequest request){
		PortletPreferences pref = request.getPreferences();
		QName actionEvent = new QName("actionEvent");
		String greeting = pref.getValue("greeting","Greeting is null");
		response.setEvent(actionEvent, greeting);
	}

}