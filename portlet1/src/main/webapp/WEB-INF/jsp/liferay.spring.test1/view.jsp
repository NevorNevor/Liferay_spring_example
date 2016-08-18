<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<portlet:actionURL name="action" var="actionUrl"></portlet:actionURL>
<portlet:actionURL name="event" var="eventUrl"></portlet:actionURL>
<a href="<%= eventUrl%>">Event</a>
<br>
<aui:form action="<%= actionUrl %>" method="post">
    <aui:input label="greeting" name="greeting" type="text" value="POST ZAPROS"/>
    <aui:button type="submit"/>
</aui:form>
This is the <b>liferay.spring.test1</b> portlet.<br />


<c:out escapeXml="true" value="${releaseInfo}" />.