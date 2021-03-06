<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-integer code="administrator.dashboard.label.numberOfPublicTasks" path="numberOfPublicTasks" />
	<acme:form-integer code="administrator.dashboard.label.numberOfPrivateTasks" path="numberOfPrivateTasks" />
	<acme:form-integer code="administrator.dashboard.label.numberOfFinishedTasks" path="numberOfFinishedTasks" />
	<acme:form-integer code="administrator.dashboard.label.numberOfNonFinishedTasks" path="numberOfNonFinishedTasks" />
	<acme:form-double code="administrator.dashboard.label.avgWorkload" path="avgWorkload" />
	<acme:form-double code="administrator.dashboard.label.devWorkload" path="devWorkload" />
	<acme:form-double code="administrator.dashboard.label.minWorkload" path="minWorkload" />
	<acme:form-double code="administrator.dashboard.label.maxWorkload" path="maxWorkload" />
	<acme:form-double code="administrator.dashboard.label.avgPeriod" path="avgPeriod" />
	<acme:form-double code="administrator.dashboard.label.devPeriod" path="devPeriod" />
	<acme:form-double code="administrator.dashboard.label.minPeriod" path="minPeriod" />
	<acme:form-double code="administrator.dashboard.label.maxPeriod" path="maxPeriod" />
	
<acme:form-return code="administrator.dashboard.button.return" />
	
</acme:form>
